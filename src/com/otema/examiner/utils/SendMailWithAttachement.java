package com.otema.examiner.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author TheOnlySmartBoy
 */
public class SendMailWithAttachement {

    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public boolean sendMailWithAttachment(String from, String to, String cc, String subject, String message, String path) {

        Properties prop = new Properties();
        prop.put("mail.debug", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // Gmail nees tls to be called first
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.port", "465"); // default port is 25 but to use TLS we need port 587

        // Get the Session object.
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage msg = new MimeMessage(session);

            // Set From: header field of the header.
            msg.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            msg.setSubject("Testing Subject");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = path;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            Logger.getLogger(SendMailWithAttachement.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

}
