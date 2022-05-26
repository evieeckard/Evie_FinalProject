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

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GuesserController {

    @FXML
    private TextField txtSongGuess, txtAnimalGuess;

    @FXML
    private Label lblSongResult, lblAnimalResult;

    @FXML
    private MediaView songPlayer;

    @FXML
    private ImageView imgAnimal = new ImageView();


    AnimalGuesser ag = new AnimalGuesser();
    SongGuesser sg = new SongGuesser();
    String randomSong = sg.getSong();
    String songLocation = "/Users/67143/IdeaProjects/JavaFX_Projects/src/main/resources/guesser/songs/" + randomSong + ".mp4";
    Media song = new Media(new File(songLocation).toURI().toString());
    File animal = new File(ag.getAnimalFile().getCanonicalPath());
    String animalName = animal.getCanonicalPath().substring(76, animal.getCanonicalPath().length() - 4);
    Image image = new Image(animal.toURI().toString());

    @FXML
    private Label white1 = new Label();
    @FXML
    private Label white2 = new Label();
    @FXML
    private Label white3 = new Label();
    @FXML
    private Label white4 = new Label();
    @FXML
    private Label white5 = new Label();
    @FXML
    private Label white6 = new Label();
    @FXML
    private Label white7 = new Label();
    @FXML
    private Label white8 = new Label();
    @FXML
    private Label white9 = new Label();
    @FXML
    private Label white10 = new Label();
    @FXML
    private Label white11 = new Label();
    @FXML
    private Label white12 = new Label();
    @FXML
    private Label white13 = new Label();
    @FXML
    private Label white14 = new Label();
    @FXML
    private Label white15 = new Label();
    @FXML
    private Label white16 = new Label();
    private Label[] hints = {white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16};

    public GuesserController() throws IOException {
    }

    public void setImgAnimal() {
        imgAnimal.setImage(image);
    }

    @FXML
    public void playSong() {
        MediaPlayer mediaPlayer = new MediaPlayer(song);
        songPlayer = new MediaView(mediaPlayer);
        mediaPlayer.play();
    }

    @FXML
    public void pauseSong() {
        songPlayer.getMediaPlayer().pause();
    }

    @FXML
    public void onAnimalGuessClick(ActionEvent event) throws IOException {
        if (songPlayer.getMediaPlayer() != null) {
            pauseSong();
        }
        Parent animalGuesser = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("animalGuesser-view.fxml")));
        Scene scene = new Scene(animalGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Animal!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSongGuessClick(ActionEvent event) throws IOException {
        Parent songGuesser = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("songGuesser-view.fxml")));
        Scene scene = new Scene(songGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Song!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onEnterSong() {
        String guess = txtSongGuess.getText();
        String song = "";
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == ' ') {
                song += '-';
            } else song += guess.charAt(i);
        }
        if (song.equalsIgnoreCase(randomSong)) {
            lblSongResult.setFont(Font.font("Avenir Book"));
            lblSongResult.setTextFill(Color.GREEN);
            lblSongResult.setText("Congratulations! You guessed the song!");
        } else {
            lblSongResult.setFont(Font.font("Avenir Book"));
            lblSongResult.setTextFill(Color.ORANGE);
            lblSongResult.setText("Wrong Answer! Try Again >:)");
        }
    }

    @FXML
    public void onGetHint() {
        setImgAnimal();
        boolean isTrue = true;
        while (isTrue) {
            int randomIndex = (int) (Math.random() * 16);
            Label hint = hints[randomIndex];
            if (!hint.isDisable()) {
                hint.setDisable(true);
                isTrue = false;
            }
        }
    }

    @FXML
    public void onEnterAnimal() {
        String guess = txtAnimalGuess.getText();
        if (guess.equalsIgnoreCase(animalName)) {
            lblAnimalResult.setFont(Font.font("Avenir Book"));
            lblAnimalResult.setTextFill(Color.GREEN);
            lblAnimalResult.setText("Congratulations! You guessed the animal!");
        } else {
            lblAnimalResult.setFont(Font.font("Avenir Book"));
            lblAnimalResult.setTextFill(Color.ORANGE);
            lblAnimalResult.setText("Wrong Answer! Try Again >:)");
        }
    }


}

