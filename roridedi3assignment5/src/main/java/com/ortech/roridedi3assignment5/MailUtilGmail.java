package com.ortech.roridedi3assignment5;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class MailUtilGmail {

	public static void sendEmail(String to, String from, String subject, String body)  {
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthentication("orisdev@gmail.com", "somefakepassword");
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");

	

		try {
			email.getMailSession().getProperties().put("mail.smtp.auth", "true");
			email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
			email.addTo(to, "Rahman Oridedi");
			email.setFrom(from, "Rahman Oridedi");
			email.setSubject(subject);
			email.setHtmlMsg(body);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}