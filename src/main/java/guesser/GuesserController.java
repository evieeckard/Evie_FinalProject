package guesser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GuesserController {

    @FXML
    private TextField txtSongGuess;

    @FXML
    private Label lblSongResult;

    @FXML
    private MediaView songPlayer;


    @FXML
    private ImageView imgAnimal, white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16;

    AnimalGuesser ag = new AnimalGuesser();
    SongGuesser sg = new SongGuesser();
    String randomSong = sg.getSong();
    Media song = new Media("src/main/resources/guesser/songs/" + randomSong + ".mp3");

    public void playSong(){
        MediaPlayer mediaPlayer = new MediaPlayer(song);
        songPlayer = new MediaView(mediaPlayer);
        songPlayer.getMediaPlayer().play();
    }

    public void pauseSong(){
        songPlayer.getMediaPlayer().pause();
    }

    public void resetSong(){
        songPlayer.getMediaPlayer().seek(Duration.seconds(0.0));
    }

    public void onAnimalGuessClick(ActionEvent event) throws IOException {
        Parent animalGuesser = FXMLLoader.load(getClass().getResource("animalGuesser-view.fxml"));
        Scene scene = new Scene(animalGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Animal!");
        stage.setScene(scene);
        stage.show();


    }

    public void onSongGuessClick(ActionEvent event) throws IOException {
        Parent songGuesser = FXMLLoader.load(getClass().getResource("songGuesser-view.fxml"));
        Scene scene = new Scene(songGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Song!");
        stage.setScene(scene);
        stage.show();
    }

    public void onEnterSong(){
        String guess = txtSongGuess.getText();
        if(guess.equalsIgnoreCase(randomSong)){
            lblSongResult.setFont(Font.font("Avenir Book"));
            lblSongResult.setTextFill(Color.GREEN);
            lblSongResult.setText("Congratulations! You guessed the song!");
        } else {
            lblSongResult.setFont(Font.font("Avenir Book"));
            lblSongResult.setTextFill(Color.ORANGE);
            lblSongResult.setText("Wrong Answer! Try Again >:)");
        }
    }


}
