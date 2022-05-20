package guesser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import textNumber.TextNumberApplication;

import java.io.IOException;

public class GuesserApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuesserApplication.class.getResource("songGuesser-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);
        primaryStage.setTitle("Guessing Games!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
