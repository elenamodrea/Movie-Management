package Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Email {

    private String SMTP_HOST = "smtp.gmail.com";
    private String FROM_ADDRESS = "isproject160@gmail.com";
    private String PASSWORD = "hqtfkmnmpblpzehx";
    private String FROM_NAME = "Elena";

    public boolean sendMail(String recipient, String bccRecipient, String message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.auth", "true");
            //props.put("mail.debug", "false");
            props.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(props, new SocialAuth());
            Message msg = new MimeMessage(session);

            InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
            msg.setFrom(from);

            InternetAddress toAddress = new InternetAddress();
            toAddress = new InternetAddress(recipient);
            msg.setRecipient(Message.RecipientType.TO, toAddress);


            InternetAddress bccAddress = new InternetAddress();
            bccAddress = new InternetAddress(bccRecipient);
            msg.setRecipient(Message.RecipientType.BCC, bccAddress);

            msg.setSubject("Proiect Magazin");
            msg.setContent(message, "text/plain");
            Transport.send(msg);
            return true;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    class SocialAuth extends Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);

        }
    }

    public static void main(String[] args) {
        Email confirmEmail = new Email();
        // confirmEmail.sendMail("fazakasedina2001@gmail.com",);
    }
}
