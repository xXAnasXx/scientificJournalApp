package com.example.scientificjournalapp.service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailService {


    public Session createSession(String username, String password){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }
    public void sendMail(String username, String password, String fromMail, String toMail, String subject) throws MessagingException {

        Session session = createSession(username, password);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromMail));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(toMail));
        message.setSubject(subject);

        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
