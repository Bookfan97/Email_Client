import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
//https://stackoverflow.com/questions/11428573/write-a-string-on-a-jpanel-centered

public class EmailOutput extends Container {
//    private static final Object NewJFrame1 = JFrame;
//    Message[] messages= (Message[]) MessagesStore.getMessages();
    MessagesStore messagesStore;
    //System.out.println(messages);
     JPanel mainPanel = new JPanel();
    EmailOutput(int index, String[][] messages) throws MessagingException, IOException {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JLabel jlabel1 = new JLabel(String.format("From: "+messages[index][0]));
        JLabel jlabel2 = new JLabel(String.format("To: "+messages[index][1]));
        JLabel jlabel3 = new JLabel(String.format("Received: "+messages[index][2]));
        JLabel jlabel4 = new JLabel(String.format("Subject: "+messages[index][3]));
        //JLabel jlabel5 = new JLabel(String.format(messages[index][5]));
        //jlabel5.setLineWrap(true);
        JTextArea textArea = new JTextArea(5, 40);
        String text = String.format(messages[index][4]);
        textArea.setText(text);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        jlabel1.setFont(new Font("Verdana",1,20));
        panel1.add(jlabel1);
        panel2.add(jlabel2);
        panel3.add(jlabel3);
        panel4.add(jlabel4);
        panel5.add(textArea);
        panel1.setBorder(new LineBorder(Color.BLACK));
        panel2.setBorder(new LineBorder(Color.BLACK));
        panel3.setBorder(new LineBorder(Color.BLACK));
        panel4.setBorder(new LineBorder(Color.BLACK));
        panel5.setBorder(new LineBorder(Color.BLACK));// make it easy to se
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);
        setSize(400,400);
        setVisible(true);
        frame.add(panel1, new GridBagConstraints());
        frame.add(panel2, new GridBagConstraints());
        frame.add(panel3, new GridBagConstraints());
        frame.add(panel4, new GridBagConstraints());
        frame.add(panel5, new GridBagConstraints());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
//JPanel mainPanel = new JPanel();
//  mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//
//  JPanel paintPanel = new JPanel();
//  JPanel textPanel = new JPanel();
//
//  mainPanel.add(paintPanel);
//  mainPanel.add(textPanel);


//    private void printEmail(Message message) throws MessagingException {
////        System.out.println("From: "+message.getFrom());
////        System.out.println("To: "+message.getAllRecipients());
////        System.out.println("Received: "+message.getReceivedDate());
////        System.out.println("Subject: "+message.getSubject());
//    }
}
