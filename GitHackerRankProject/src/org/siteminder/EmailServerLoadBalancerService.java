package org.siteminder;

import java.util.*;

/**
 * The Interface EmailServerLoadBalancerService.
 */
public interface EmailServerLoadBalancerService {
	
	 /**
 	 * Gets the server.
 	 *
 	 * @return the server
 	 */
 	String getServer();

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
	 * @throws Exception the exception
	 */
	int sendEmail(String emailServerUrl, String authorization, String to, String from, String subject, String text)
			throws Exception;
}
