package org.mailosaur.emailautomation;

import java.io.IOException;
import org.mailosaur.configfactory.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

/**
 * This class will allow to connect with email client Mailosaur and retrieve the email subject and body to assert it.
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 */
public class MailosaurEmailAutomation {
	
	/**
	 * This method will retrieve the Email content after your application with sent email on the Mailosaur designated email address. Sending email is not part of this method.
	 * Mar 1, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	@Test
	public void emailTest() throws IOException, MailosaurException {
		MailosaurClient mailosaur = new MailosaurClient(ConfigFactory.getConfig().APIKEY());
		MessageSearchParams params = new MessageSearchParams();
		params.withServer(ConfigFactory.getConfig().SERVERID());
		SearchCriteria criteria = new SearchCriteria();
	//	criteria.withSentTo("vdsrb2i4@" + ConfigFactory.getConfig().SERVERDOMAIN());
		criteria.withSentTo("vdsrb2i4@mailosaur.net");
		Message message = mailosaur.messages().get(params, criteria);
		Assert.assertNotNull(message);
		Assert.assertEquals("My email subject", message.subject());
	}
}
