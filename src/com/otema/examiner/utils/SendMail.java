package com.otema.examiner.utils;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author TheOnlySmartBoy
 */
public class SendMail {

    private static final String SMTP_SERVER = "smtp.gmail.com"; // smtp server adress/ip
    private static final String USERNAME = "o2jsmartboy@gmail.com"; //Your gmail adress
    private static final String PASSWORD = "vgnjjefnqdfbsgkl"; //Your gmail passwordd

    public static boolean sendMail(String from, String to, String cc, String subject, String message) {
        Properties prop = new Properties();

        prop.put("mail.debug", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // Gmail nees tls to be called first
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.port", "465"); // default port is 25 but to use TLS we need port 587
        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        MimeMessage msg = new MimeMessage(session);
        try {
            // from
            msg.setFrom(new InternetAddress(from));
            // to 
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // cc
            msg.addRecipient(Message.RecipientType.CC,
                    new InternetAddress(cc));
            // subject
            msg.setSubject(subject);
            // content 
            msg.setText(message);
            msg.setSentDate(new Date());
            // connect
            // Get SMTPTransport
            //SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            // connect
            // send
            Transport.send(msg, msg.getAllRecipients());
            System.out.println("Mail sent successfuly ");
        } catch (MessagingException e) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
}
