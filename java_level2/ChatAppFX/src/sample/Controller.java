package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Controller {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    @FXML
    public TextArea mainTextArea;
    public TextField messageTextField;

    public void btnOneClickAction(ActionEvent actionEvent) {
        sendMessage();
    }

    public void keyPressedAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessage();
        }
    }

    public Controller() {
        try {
            socket = new Socket("localhost", 8189);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            setAuthorized(false);

            Thread t1 = new Thread(() -> {
                try {
                    while (true) {
                        String strMsg = dis.readUTF();
                        if (strMsg.startsWith("/authOk")) {
                            setAuthorized(true);
                            mainTextArea.appendText("You were authorized as "
                                    + strMsg.split("\\s", 2)[1] + "\n");
                            break;
                        }
                        mainTextArea.appendText(strMsg + "\n");

                    }
                    while (true) {
                        String strMsg = dis.readUTF();
                        if (strMsg.equals("/exit")) {
                            break;
                        }
                        mainTextArea.appendText(strMsg + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t1.setDaemon(true);
            t1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String messageText = messageTextField.getText().trim();
        if (messageText.length() > 0) {
            mainTextArea.appendText("You: ");
            mainTextArea.appendText(messageText);
            mainTextArea.appendText("\n");
            try {
                dos.writeUTF(messageText);
            } catch (IOException e) {
            }
        }
        messageTextField.clear();
        messageTextField.requestFocus();
    }

    private void setAuthorized(boolean authorized) {
    }

}
