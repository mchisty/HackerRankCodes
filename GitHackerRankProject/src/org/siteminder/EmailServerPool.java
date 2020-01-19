package org.siteminder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The Class EmailServerPool. Contains a map of sample email server APIs, along with their authentication code.
 * All of the items in the are fake except the one from sendgrid: https://api.sendgrid.com/v3/mail/send
 * 
 * <br/>
 * The objective here is to test: if one of the email services goes down, the service can quickly failover to a different provider without affecting customers.
 * 
 * @see {@link EmailLoadBalancerManageApplication}
 * 
 */
public class EmailServerPool {
	
	/** The email server url map. */
	public static Map<String, String> emailServerUrlMap = new ConcurrentHashMap<>();

    static {
        emailServerUrlMap.put("https://abc.com/server1/messages", "api:server1_12334455fdfdsfsdf");
		emailServerUrlMap.put("https://xyz.fake.org/bbb/messages", "bbb_2342344$%^44456456dsdfsdopreptelflgldfg");
        emailServerUrlMap.put("https://api.mailgun.net/v3/mydomain.com/messages", "api:XUAIazSDAa00290121OASDKAS_is344DKASDK");
		emailServerUrlMap.put("https://fake.email.server/v1/messages", "serverxyz_95304503ioklaoie4234234cdsdfsd");
        emailServerUrlMap.put("https://api.sendgrid.com/v3/mail/send", "Bearer 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");
    }
}
