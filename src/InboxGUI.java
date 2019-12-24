import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class InboxGUI<mouseListener> extends JFrame {
    static String[] messages;
    private JList<String> countryList;
//    static String labels[];
    DefaultListModel<String> labels = new DefaultListModel<>();
    public InboxGUI(String[][] messages) {
         //= {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0, n = messages.length; i < n; i++) {
            String sent = messages[i][3];
            String from = messages[i][0];
            String subject = messages[i][4];
            String inboxString= (String) String.format("%-50s%-200s%-200s\n", sent, from, subject);
            labels.add(i,inboxString);
        }
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList<String> jlist = new JList<>(labels);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        f.add(scrollPane1, BorderLayout.CENTER);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList<String> theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        try {
                            new EmailOutput(index, messages);
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // System.out.println("Double-clicked on: " + o.toString());
                    }
                }
            }
        };
        jlist.addMouseListener(mouseListener);
        f.setSize(350, 200);
        f.setVisible(true);
    }
}
//    }
        //create the model and add elements
//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        for (int i = 0, n = messages.length; i < n; i++) {
//            listModel.addElement(messages[i]);
//        }
//        listModel.addElement("USA");
//        listModel.addElement("India");
//        listModel.addElement("Vietnam");
//        listModel.addElement("Canada");
//        listModel.addElement("Denmark");
//        listModel.addElement("France");
//        listModel.addElement("Great Britain");
//        listModel.addElement("Japan");
//
//        //create the list
//        countryList = new JList<>(listModel);
//        add(countryList);
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("JList Example");
//        this.setSize(200, 200);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//    }
//
//    MouseListener mouseListener = new MouseAdapter() {
//        public void mouseClicked(MouseEvent mouseEvent) {
//            JList<String> theList = (JList) mouseEvent.getSource();
//            if (mouseEvent.getClickCount() == 2) {
//                int index = theList.locationToIndex(mouseEvent.getPoint());
//                if (index >= 0) {
//                    Object o = theList.getModel().getElementAt(index);
//                    System.out.println("Double-clicked on: " + o.toString());
//                }
//            }
//        }
//    };
////    jlist.addMouseListener(mouseListener);
////    f.setSize(350,200);
////    f.setVisible(true);
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
////                new ButtonExample();
//                new InboxGUI(messages);
//            }
//        });
//    }
//
////    public static class ButtonExample {
////        ButtonExample() {
////            JFrame f = new JFrame("Button Example");
////            JButton b = new JButton(new ImageIcon("D:\\icon.png"));
////            b.setBounds(100, 100, 100, 40);
////            f.add(b);
////            f.setSize(300, 400);
////            f.setLayout(null);
////            f.setVisible(true);
////            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        }
//    }
////}