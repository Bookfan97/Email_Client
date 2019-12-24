import java.util.Properties;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

public class CheckingMail {
    private static Message[] messages;
    public Credentials credentials;

    public static void check(String host, String storeType, String user, String password, Credentials credentials)
    {
        try {

            // create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.starttls.enable", "true");

            // Setup authentication, get session
            Session emailSession = Session.getInstance(properties,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    credentials.getUsername(), credentials.getPassword());
                        }
                    });
            // emailSession.setDebug(true);

            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect();

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
             messages = emailFolder.getMessages();
            new MessagesStore();
            MessagesStore messageStore= new MessagesStore();
            messageStore.setMessages(messages);
            System.out.println("messages.length---" + messages.length);
            String[][] inboxView = new String[messages.length][messages.length];
            for (int i = 0; i<5; i++){
//            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("Downloading "+(i+1)+"/"+messages.length);
                    inboxView[i][0] = String.format(message.getFrom()[0].toString());
                //https://stackoverflow.com/questions/6806449/printing-out-the-email-address-of-sender-from-internetaddress
                    inboxView[i][1] = InternetAddress.toString(messages[i].getFrom());
                    inboxView[i][2] = String.format(message.getSentDate().toString());
                    if (messages[i].getSubject().equals(null) || message.getSubject().equals("")){
                        inboxView[i][3] = "No Subject";
                    }
                    else
                    {
                        inboxView[i][3] = String.format(messages[i].getSubject());
                    }
//                    inboxView[i][3] = String.format(message.getSubject());
                    System.out.println(inboxView[i][3]);
                String contentType = message.getContentType();
                String messageContent="";
                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        messageContent = part.getContent().toString();
                    }
                }
                else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }
                inboxView[i][4] = messageContent;//String.format(message.getContent().toString());
            }

            // close the store and folder objects
            emailFolder.close(false);
            new InboxGUI(inboxView);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    Message[] getMessages(){
//        return messages;
//    }

//    public static void main(String[] args) {
//        Credentials credentials;//= credentials.toString();
//        String host = "pop.gmail.com";// change accordingly
//        String mailStoreType = "pop3";
//        String username = credentials.getEmail();// change accordingly
//        String password = credentials.getPassword();// change accordingly
//
//        check(host, mailStoreType, username, password, credentials);
//
//    }

}
