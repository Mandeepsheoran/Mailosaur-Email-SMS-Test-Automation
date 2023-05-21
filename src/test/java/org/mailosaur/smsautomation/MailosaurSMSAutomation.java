package org.mailosaur.smsautomation;

import java.io.IOException;
import java.util.Date;

import org.mailosaur.configfactory.ConfigFactory;
import org.testng.annotations.Test;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

/**
 * This class will allow to connect with SMS client Mailosaur using provided
 * mobile no and retrieve the SMS details to assert it. Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 */
public class MailosaurSMSAutomation {
	/**
	 * This method will retrieve the SMS content after your application with sent
	 * SMS on the Mailosaur designated number. Sending SMS is not part of this
	 * method. Mar 1, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	@Test
	public void smsTest() throws IOException, MailosaurException {
		MailosaurClient mailosaur = new MailosaurClient(ConfigFactory.getConfig().APIKEY());
		Date testStart = new Date(); // Only look for messages after our test began
		// Send an SMS message to your test number...
		MessageSearchParams params = new MessageSearchParams();
		params.withServer(ConfigFactory.getConfig().SERVERID()).withReceivedAfter(testStart);
		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("1234567890"); // Sample Phone no
		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.text().body()); // "Your order number is 51223"
		System.out.println(message.text().codes().get(0).value()); // "51223"
	}
}
