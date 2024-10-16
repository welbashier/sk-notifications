package com.gwais.sk_notifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gwais.sk_notifications.dto.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    
    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("welbashier@gmail.com");

        mailSender.send(message);
    }
    
    public void sendHtmlEmailRequest(EmailRequest emailRequest) {
    	
		try {
	    	// Create a MimeMessage
	        MimeMessage message = mailSender.createMimeMessage();
	
	        // Use MimeMessageHelper to set multipart flag to true (to handle attachments if needed)
	        MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true, "UTF-8");
			// Set email attributes
	        helper.setTo(emailRequest.getEmailAddress());
	        helper.setSubject("Please verify your email!");
	        // Set the content type to text/html
	        helper.setText(buildHtmlBody(emailRequest.getFirstName(), 
	        		emailRequest.getVerificationLink(),
	        		emailRequest.getPin()), true);  // The 'true' is for HTML
	        helper.setFrom("support@scholakit.com");
	
	        mailSender.send(message);
	        
        } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private String buildHtmlBody(String firstName, String verificationLink, String pin) {
    	
    	String htmlBody = "<!DOCTYPE html>\r\n"
    			+ "<html lang=\"en\">\r\n"
    			+ "<head>\r\n"
    			+ "    <meta charset=\"UTF-8\">\r\n"
    			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
    			+ "    <title>Email Verification</title>\r\n"
    			+ "    <style>\r\n"
    			+ "        body {\r\n"
    			+ "            font-family: Arial, sans-serif;\r\n"
    			+ "            background-color: #f4f4f4;\r\n"
    			+ "            margin: 0;\r\n"
    			+ "            padding: 0;\r\n"
    			+ "        }\r\n"
    			+ "        .container {\r\n"
    			+ "            width: 100%;\r\n"
    			+ "            max-width: 600px;\r\n"
    			+ "            margin: 0 auto;\r\n"
    			+ "            background-color: #ffffff;\r\n"
    			+ "            padding: 20px;\r\n"
    			+ "            border-radius: 8px;\r\n"
    			+ "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n"
    			+ "        }\r\n"
    			+ "        h2 {\r\n"
    			+ "            color: #333333;\r\n"
    			+ "        }\r\n"
    			+ "        p {\r\n"
    			+ "            color: #555555;\r\n"
    			+ "            line-height: 1.6;\r\n"
    			+ "        }\r\n"
    			+ "        .button {\r\n"
    			+ "            display: inline-block;\r\n"
    			+ "            padding: 10px 20px;\r\n"
    			+ "            background-color: #007bff;\r\n"
    			+ "            color: #ffffff;\r\n"
    			+ "            text-decoration: none;\r\n"
    			+ "            border-radius: 4px;\r\n"
    			+ "            margin-top: 20px;\r\n"
    			+ "        }\r\n"
    			+ "        .button:hover {\r\n"
    			+ "            background-color: #0056b3;\r\n"
    			+ "        }\r\n"
    			+ "        .footer {\r\n"
    			+ "            margin-top: 20px;\r\n"
    			+ "            font-size: 12px;\r\n"
    			+ "            color: #777777;\r\n"
    			+ "            text-align: center;\r\n"
    			+ "        }\r\n"
    			+ "    </style>\r\n"
    			+ "</head>\r\n"
    			// ----------------- Body -----------------
    			+ "<body>\r\n"
    			+ "    <div class=\"container\">\r\n"
    			+ "        <h2>Email Verification</h2>\r\n"
    			+ "        <p>Dear <strong>" + firstName + "</strong>,</p>\r\n"
    			+ "        <p>Thank you for registering with <strong>ScholaKit</strong>! To complete your registration, please verify your email address by clicking the button below:</p>\r\n"
    			+ "        <p>\r\n"
    			+ "            <a href=\"" + verificationLink + "?token=abcd1234\" class=\"button\">Verify Email Address</a>\r\n"
    			+ "        </p>\r\n"
    			+ "        <p>If the button doesn't work, copy and paste the following URL into your browser:</p>\r\n"
    			+ "        <p><a href=\"" + verificationLink + "?token=" + pin + "\">" + verificationLink + "?token=" + pin +"</a></p>\r\n"
    			+ "        <p>This link will expire in 24 hours, so please verify your email as soon as possible.</p>\r\n"
    			+ "        <p>If you did not create an account with us, please ignore this email.</p>\r\n"
    			+ "        <div class=\"footer\">\r\n"
    			+ "            <p>Best regards,<br>ScholaKit Team</p>\r\n"
    			+ "            <p>If you need assistance, contact us at <a href=\"mailto:support@ScholaKit.com\">support@ScholaKit.com</a></p>\r\n"
    			+ "        </div>\r\n"
    			+ "    </div>\r\n"
    			+ "</body>\r\n"
    			+ "</html>\r\n"
    			+ "";
		return htmlBody;
    	
    }
}
