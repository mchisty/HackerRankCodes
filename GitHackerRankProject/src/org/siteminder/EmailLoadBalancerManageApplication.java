package org.siteminder;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class EmailLoadBalancerManageApplication.
 */
public class EmailLoadBalancerManageApplication {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(EmailLoadBalancerManageApplication.class.getName());

	/** The Constant PATH. */
	private final static String PATH = "C:\\Temp";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int queryTimes = EmailServerPool.emailServerUrlMap.size();
//		LOGGER.log(Level.INFO, "queryTimes:" + queryTimes);
		try {
			verifyEmailServerAndSendEmail(new EmailServerLoadBalancerServiceImpl(), queryTimes);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "An Error Occurred", e);
		}
	}

	/**
	 * Pick an email server from load balancer.
	 *
	 * @param loadBalance the load balance
	 * @param queryTimes  the query times
	 * @throws Exception the exception
	 */
	private static void verifyEmailServerAndSendEmail(EmailServerLoadBalancerService loadBalance, int queryTimes)
			throws Exception {
		String to = null, from = null, subject = null, text = null;
		String appConfigPath = PATH + "\\email.properties";
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(appConfigPath));
		to = appProps.getProperty(EmailPropEnum.TO.getVal());
		from = appProps.getProperty(EmailPropEnum.FROM.getVal());
		subject = appProps.getProperty(EmailPropEnum.SUBJECT.getVal());
		text = appProps.getProperty(EmailPropEnum.TEXT.getVal());
		for (int i = 0; i < queryTimes; i++) {
			String api = loadBalance.getServer();
			String authorization = EmailServerPool.emailServerUrlMap.get(api);
			int response = -1;
			try {
				response = loadBalance.sendEmail(api, authorization, to, from, subject, text);
			} catch (Exception e) {
				continue;
			}
			if (response == HttpResponseEnum.CODE_201.getCode() || response == HttpResponseEnum.CODE_202.getCode()) {
				LOGGER.log(Level.INFO, "\n[*** EMAIL sent Successfully ***] "
						+ String.format("[%s]  index: %s, %s", loadBalance.getClass().getSimpleName(), i, api));
				break;
			}
		}
	}

}
