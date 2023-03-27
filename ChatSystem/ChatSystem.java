import ChatInterface;
import RemoteUser;


public class ChatSystem {


public boolean verificationNickname(String nickname) {
// Check if nickname is valid
boolean valid = true;
for (int i = 0; i < nickname.length(); i++) {
char c = nickname.charAt(i);
if (!Character.isLetterOrDigit(c)) {
valid = false;
break;
}
}
return valid;
}

public void printWelcomeInterface() {
ChatInterface chatInterface = new ChatInterface();
chatInterface.setVisible(true);
chatDialog.dispose();
}

/*
public RemoteUser sendHello() {
// Send hello message to remote user
// Implementation omitted for brevity
RemoteUser remoteUser = new RemoteUser("remoteNickname");
return remoteUser;
}


public boolean verificationRemoteNickname(RemoteUser remoteUser) {
// Check if remote user nickname is valid
// Return true if valid, false otherwise
// Implementation omitted for brevity
return true;
}

public void modifyRemoteNickname(RemoteUser remoteUser) {
// Modify remote user nickname
// Implementation omitted for brevity
}*/

public void notifyChanging() {
// Notify user of nickname change
// Implementation omitted for brevity
}


public void launchChatInterface() {
// Create new ChatInterface object
ChatInterface chatInterface = new ChatInterface(this);

// Display ChatInterface to user
chatInterface.setVisible(true);
}
public static void main(String[] args) {
launchChatInterface();
}
