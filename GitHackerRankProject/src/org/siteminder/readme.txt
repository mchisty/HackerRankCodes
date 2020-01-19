/** ---------- **/
/** Objective: **/
/** ---------- **/
The objective is to develop an application that should provide an abstraction between two different email service providers. If one of the services goes down, the service can quickly fail-over to a different provider without affecting the customers.



/** ------------ **/
/** Constraints: **/
/** ------------ **/
1. No authentication is required for the scope of this exercise
2. No 3rd party client library should be used to integrate with Mailgun, Sendgrid or other providers. 



/** ------------ **/
/** LIMITATIONS: **/
/** ------------ **/

The load balancer will work with as many email servers as required (not just two). However, this is only a test exercise, therefore the followings limitations need to be considered:

1. A Map object is created with email server api as key, and authentication as value. Although this is not an standard way, but this was done for the sake of simplicity to demonstrate that this works. 
a. Ideally any credential should not be put into Map or in a hard-coded way
b. A Map object could be used for different purpose e.g. server name (key), weight (value)
c. An ideal way would be to put credentials/authentication in a server configuration file 

(Ref. EmailServerPool.java)

2. Since this is not a professional requirement, the followings are NOT provided:
a. No JUnit test was written
b. No separate Exception handling class was written to handle exception
c. No separate Logger handling class was written to handle logs




/** ---------------------- **/
/** Technical explanation: **/
/** ---------------------- **/
To develop this scenario, a simple load balancer of email servers have been developed. The load balancer will work with as many email servers as required (not just two).

1. The basic idea is to execute a REST api with necessary attributes. A curl command to execute such RESTful api is generally as follows (example from sendgrid.com):

curl --request POST \
  --url https://api.sendgrid.com/v3/mail/send \
  --header "Authorization: Bearer $SENDGRID_API_KEY" \
  --header 'Content-Type: application/json' \
  --data '{"personalizations": [{"to": [{"email": "test@example.com"}]}],"from": {"email": "test@example.com"},"subject": "Sending with SendGrid is Fun","content": [{"type": "text/plain", "value": "and easy to do anywhere, even with cURL"}]}'
  
There can be slight differences among APIs of several email service providers. However, providing an Authentication credential is common to all service providers. The reason is: without authentication, no email API will execute. 

For the sake of this simple exercise, all the email servers in pool are fake EXCEPT one: https://api.sendgrid.com/v3/mail/send. This is just to ENSURE that if one of the service fails, it continues to move on with the next available service and goes on like this until it reaches to the last item in the pool. (A brutal force approach is applied to fail some scenarios intentionally)

2. A load balancer service is implemented which will fetch email servers from Pool on a round robin basis. (Ref. EmailServerLoadBalancerServiceImpl.java)

3. The main thread will use load balancer to pick a email service for API execution. If an API execution succeeds, the main thread just exits; otherwise it continues with the next server from the pool, provided by the load balancer. (Ref. EmailLoadBalancerManageApplication.java)

4. Enum are used to hold constant variable like email properties, response code etc. (Ref. EmailPropEnum.java, HttpResponseEnum.java)

5. The email properties are used in a property configuration file called "email.properties"

6. Plain/Core java is used for this exercise; no framework solution like Spring/SpringBoot, no third party API like APache tools or any other SDK tools provided by email service providers are used.




/** --------------- **/
/** How to execute: **/
/** --------------- **/
1. Create directory as "C:\\Temp" and place the email.properties in the directory

2. Modify the attribute values for "to", "from", "subject" and "text" 

3. Execute the main class EmailLoadBalancerManageApplication

4. A successfully sent email will be returned with a status code of 202. A successful run might produce an output like this (where the first two fails, but the next one succeeds):

/*==============================================================================================================================*/
Jan 19, 2020 9:55:54 PM demo.email.restful.EmailServerLoadBalancerServiceImpl sendEmail
SEVERE: Sending email failed for https://fake.email.server/v1/messages with response code: -1

Jan 19, 2020 9:55:54 PM demo.email.restful.EmailServerLoadBalancerServiceImpl sendEmail
SEVERE: Sending email failed for https://xyz.fake.org/bbb/messages with response code: -1

Jan 19, 2020 9:55:55 PM demo.email.restful.EmailServerLoadBalancerServiceImpl sendEmail
INFO: Sending with api: https://api.sendgrid.com/v3/mail/send. Response code: 202
Jan 19, 2020 9:55:55 PM demo.email.restful.EmailLoadBalancerManageApplication verifyEmailServerAndSendEmail
INFO: 
[*** EMAIL sent Successfully ***] [EmailServerLoadBalancerServiceImpl]  index: 2, https://api.sendgrid.com/v3/mail/send
/*==============================================================================================================================*/


5. Once the application is executed successfully, please check all the emails mentioned in the "to" attributes to verify that the emails have gone through. This might take a few minutes for the emails to arrive at inbox.