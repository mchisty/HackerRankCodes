package org.siteminder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class EmailServerLoadBalancerServiceImpl.
 */
public class EmailServerLoadBalancerServiceImpl implements EmailServerLoadBalancerService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(EmailServerLoadBalancerServiceImpl.class.getName());
	
	/** The position. */
	private static Integer INDEX = 0;

	final static String QUOTE = "\"";

	/**
	 * Gets the server.
	 *
	 * @return the server
	 */
	@Override
	public String getServer() {
		ArrayList<String> serverList = new ArrayList<String>(EmailServerPool.emailServerUrlMap.keySet());
		String target = null;
		synchronized (INDEX) {
			if (INDEX > serverList.size() - 1) {
				INDEX = 0;
			}
			target = serverList.get(INDEX);
			INDEX++;
		}
		return target;
	}

	/**
	 * Send email.
	 *
	 * @param emailServerUrl the email server url
	 * @param authorization the authorization
	 * @param to the to
	 * @param from the from
	 * @param subject the subject
	 * @param text the text
	 * @return the int
	 */
	@Override
	public int sendEmail(String emailServerUrl, String authorization, String to, String from, String subject,
			String text) {
		int code = -1;
		try {
			URL url = new URL(emailServerUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Authorization", authorization);
			con.setDoOutput(true);
			con.setConnectTimeout(10000);

			String jsonInputString = getEmailPropertiesAsJson(to, from, subject, text);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
			code = con.getResponseCode();
			LOGGER.log(Level.INFO, "Sending with api: " + emailServerUrl + ". Response code: " +  code);

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Sending email failed for " + emailServerUrl + " with response code: " + code + "\n");
		}
		return code;
	}

	/**
	 * Gets the email properties as json.
	 *
	 * @param to the to
	 * @param from the from
	 * @param subject the subject
	 * @param text the text
	 * @return the email properties as json
	 */

	private String getEmailPropertiesAsJson(String to, String from, String subject, String text) {
		StringTokenizer stoken = new StringTokenizer(to, ", ");
		StringBuffer to_sb = new StringBuffer();
		while (stoken.hasMoreTokens()) {
			to_sb.append("{\"email\": ").append(QUOTE).append(stoken.nextToken()).append(QUOTE).append("},");
		}

		to = to_sb.substring(0, to_sb.length() - 1);
		String jsonInputString = "{\"personalizations\": [{\"to\": [REPLACE_TO]}],\"from\": {\"email\": \"REPLACE_FROM\"},\"subject\": \"REPLACE_SUB\",\"content\": [{\"type\": \"text/plain\", \"value\": \"REPLACE_BODY\"}]}";
		jsonInputString = jsonInputString.replaceAll("REPLACE_TO", to);
		jsonInputString = jsonInputString.replaceAll("REPLACE_FROM", from);
		jsonInputString = jsonInputString.replaceAll("REPLACE_SUB", subject);
		jsonInputString = jsonInputString.replaceAll("REPLACE_BODY", text);
		return jsonInputString;
	}


}
