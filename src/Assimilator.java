//https://the-eye.eu/public/Books/IT%20Various/JavaMail%20API.pdf
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.*;
public class Assimilator {
    public static void main(String[] args) {
        Properties props = new Properties();
        Session session = Session.getInstance(props);
        MimeMessage msg = new MimeMessage(session);
        Transport t = null;
        try {
            Address bill = new InternetAddress("god@microsoft.com", "Bill Gates");
            Address elliotte = new InternetAddress("elharo@ibiblio.org");
            msg.setText("Resistance is futile. You will be assimilated!");
            msg.setFrom(bill);
            msg.setRecipient(Message.RecipientType.TO, elliotte);
            msg.setSubject("You must comply.");
            t = session.getTransport("smtps");
            t.connect("smtp.gmail.com", "erharold", "password");
            t.sendMessage(msg, msg.getAllRecipients());
        } catch (MessagingException | UnsupportedEncodingException ex) { ex.printStackTrace();
        } finally { // Transport does not implement AutoCloseable :-(
            if (t != null) {
                try {
                    t.close();
                } catch (MessagingException ex) {
                }
            }
        }
    }
}