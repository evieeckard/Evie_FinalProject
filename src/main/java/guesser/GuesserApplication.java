package guesser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import textNumber.TextNumberApplication;

import java.io.IOException;
import java.net.URL;

public class GuesserApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = GuesserApplication.class.getResource("songGuesser-view.fxml");
        System.out.println(url);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);
        primaryStage.setTitle("Guess the Song!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
