package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {

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

    private void sendMessage() {
        String messageText = messageTextField.getText().trim();
        if (messageText.length() > 0) {
            mainTextArea.setStyle("");
            mainTextArea.appendText("You: ");
            mainTextArea.appendText(messageText);
            mainTextArea.appendText("\n");
        }
        messageTextField.clear();
        messageTextField.requestFocus();
    }

}
