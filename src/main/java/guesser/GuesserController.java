package guesser;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class GuesserController {

    @FXML
    private TextField txtSongGuess;

    @FXML
    private Label txtSongResult;

    @FXML
    private MediaView songPlayer;

    AnimalGuesser ag = new AnimalGuesser();
    SongGuesser sg = new SongGuesser();
    Media song = new Media("src/main/resources/guesser/songs/" + sg.getSong() + ".mp3");

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

}
