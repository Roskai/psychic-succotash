package ChatSystem;

import javax.swing.*;

public class ChatDialog extends JFrame {

    private JLabel welcomeLabel;
    private JLabel nicknameLabel;
    private JTextField nicknameField;
    private JButton connectButton;

    public ChatDialog() {
        // Set window title
        super("Chat System");

        // Create welcome label
        welcomeLabel = new JLabel("Welcome to our Chat System");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create nickname label and text field
        nicknameLabel = new JLabel("My nickname");
        nicknameField = new JTextField(20);

        // Create connect button
        connectButton = new JButton("Connection");
        connectButton.addActionListener(e -> {
            String nickname = nicknameField.getText();
            // Call method to handle connection button click
            handleConnection(nickname);
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(welcomeLabel);
        panel.add(nicknameLabel);
        panel.add(nicknameField);
        panel.add(connectButton);

        // Add panel to frame and set window properties
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleConnection(String nickname) {
        ChatSystem chatSystem = new ChatSystem();
        boolean nicknameValid = chatSystem.verificationNickname(nickname);
        if (nicknameValid) {
            chatSystem.printWelcomeInterface();
            RemoteUser remoteUser = chatSystem.sendHello();
            boolean remoteNicknameValid = chatSystem.verificationRemoteNickname(remoteUser);
            if (remoteNicknameValid) {
                chatSystem.modifyRemoteNickname(remoteUser);
                chatSystem.notifyChanging();
            } else {
               sendRetry();
            }
        } else {
            sendRetry();
        }
    }

    public static void main(String[] args) {
        ChatDialog chatDialog = new ChatDialog();
    }
  public void sendRetry() {
    JOptionPane.showMessageDialog(chatDialog, "Le surnom entré n'est pas valide. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
    chatDialog.resetNicknameField();
}

}
