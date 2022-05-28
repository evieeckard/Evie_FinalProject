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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GuesserController {

    @FXML
    private Text white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16;

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
    File animal = ag.getAnimalFile();
    String animalName = animal.getCanonicalPath().substring(76, animal.getCanonicalPath().length() - 4);
    Image image = new Image(animal.toURI().toString());


    public String[] hints = new String[]{"white1", "white2", "white3", "white4", "white5", "white6", "white7", "white8", "white9", "white10", "white11", "white12", "white13", "white14", "white15", "white16"};

    public GuesserController() throws IOException {
        white1 = new Text();
        white1.setId("white1");
        white2 = new Text();
        white2.setId("white2");
        white3 = new Text();
        white3.setId("white3");
        white4 = new Text();
        white4.setId("white4");
        white5 = new Text();
        white5.setId("white5");
        white6 = new Text();
        white6.setId("white6");
        white7 = new Text();
        white7.setId("white7");
        white8 = new Text();
        white8.setId("white8");
        white9 = new Text();
        white9.setId("white9");
        white10 = new Text();
        white10.setId("white10");
        white11 = new Text();
        white11.setId("white11");
        white12 = new Text();
        white12.setId("white12");
        white13 = new Text();
        white13.setId("white13");
        white14 = new Text();
        white14.setId("white14");
        white15 = new Text();
        white15.setId("white15");
        white16 = new Text();
        white16.setId("white16");
    }

    public void setImgAnimal() {
        imgAnimal.setImage(image);
    }

    @FXML
    public void onGetHint() {
        setImgAnimal();
        int randomNum = (int) (Math.random() * 16);
        String name = hints[randomNum];
        searchWhite(name, white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16);
    }

    private void searchWhite(String name, Text white1, Text white2, Text white3, Text white4, Text white5, Text white6, Text white7, Text white8, Text white9, Text white10, Text white11, Text white12, Text white13, Text white14, Text white15, Text white16) {
        if (white1.getId().equals(name)) {white1.setText(" ");}
        if (white2.getId().equals(name)) {white2.setText(" ");}
        if (white3.getId().equals(name)) {white3.setText(" ");}
        if (white4.getId().equals(name)) {white4.setText(" ");}
        if (white5.getId().equals(name)) {white5.setText(" ");}
        if (white6.getId().equals(name)) {white6.setText(" ");}
        if (white7.getId().equals(name)) {white7.setText(" ");}
        if (white8.getId().equals(name)) {white8.setText(" ");}
        if (white9.getId().equals(name)) {white9.setText(" ");}
        if (white10.getId().equals(name)) {white10.setText(" ");}
        if (white11.getId().equals(name)) {white11.setText(" ");}
        if (white12.getId().equals(name)) {white12.setText(" ");}
        if (white13.getId().equals(name)) {white13.setText(" ");}
        if (white14.getId().equals(name)) {white14.setText(" ");}
        if (white15.getId().equals(name)) {white15.setText(" ");}
        if (white16.getId().equals(name)) {white16.setText(" ");}
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

