/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: Mailer instance SendGrid
 * */
package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sendgrid.*;

public class Mailer {
	static Properties prop = new Properties();
	static InputStream input;
	private SendGrid getMailerInstance() throws IOException {
		SendGrid sg = null;
		try {
			input = this.getClass().getClassLoader().getResourceAsStream ("/config.properties");
			prop.load(input);
			String SENDGRID_API_KEY = prop.getProperty("sendgridAPI");
			if(!SENDGRID_API_KEY.isEmpty()) {
				sg = new SendGrid(SENDGRID_API_KEY);
			}else {
				throw new IOException("Can't find API Key from SendGrid");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sg;
	}
	public boolean send(String _to, String _subject, String _content) {
		Email from = new Email("noreply@securely.com");
		String subject = _subject;
		Email to = new Email(_to);
		Content content = new Content("text/html",_content);
		Mail mail = new Mail(from, subject, to, content);
		try {
			SendGrid sg = getMailerInstance();
			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			if(response.getStatusCode() < 400) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
