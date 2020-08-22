package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientService extends Application {


    public ClientService() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Network Chat");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch();
    }

}
