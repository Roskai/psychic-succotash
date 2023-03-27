
package ChatSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatInterface extends JFrame {

    private JList<String> userList;
    private DefaultListModel<String> listModel;


    public ChatInterface() {
        // Set up the main window
        setTitle("Chat Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create the user list
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(userList);

        // Create the disconnect button
        JButton disconnectButton = new JButton("Disconnect");
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the disconnect method of ChatSystem
                //ChatSystem.getInstance().disconnect();
            }
        });

        // Create the label and combo box for selecting a user to chat with
        JLabel selectUserLabel = new JLabel("Please choose a user to begin chat:");
       JComboBox<String> userComboBox = new JComboBox<>(listModel.toArray(new String[0]));

        // Create the button for starting a chat with the selected user
        JButton startChatButton = new JButton("Start Chat");
        startChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected user and call the startChat method of ChatSystem
//                String selectedUser = (String) userComboBox.getSelectedItem();
                //ChatSystem.getInstance().startChat(selectedUser);
            }
        });

        // Add components to the main window
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(disconnectButton, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(selectUserLabel, BorderLayout.NORTH);
        add(userComboBox, BorderLayout.WEST);
        add(startChatButton, BorderLayout.SOUTH);

        // Show the window
        setVisible(true);
    }

    public void addUser(String user) {
        // Add a user to the list model
        listModel.addElement(user);
    }
    public static void main(String[] args) {
      ChatInterface ci = new ChatInterface();

    }
    public void removeUser(String user) {
        // Remove a user from the list model
        listModel.removeElement(user);
    }

    public void close() {
        // Close the window
        setVisible(false);
        dispose();
    }
}
