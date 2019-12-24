import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;

public class MessagesStore {
    static Message[] messages;

    public static Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public String getMessage(int index) throws MessagingException, IOException {

        for (int i=0; i<messages.length; i++){
            if(i==index){
                return "From: "+messages[i].getFrom()+"\n"
                        +"To: "+messages[i].getAllRecipients()+"\n"
                        +"Received: "+messages[i].getReceivedDate()+"\n"
                        +"Subject: "+messages[i].getSubject()+"\n"+"\n"
                        +messages[i].getContent().toString();
            }
        }
        return "Email not found";
    }

}
