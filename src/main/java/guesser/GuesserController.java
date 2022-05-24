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

public class GuesserController {

    @FXML
    private TextField txtSongGuess, txtAnimalGuess;

    @FXML
    private Label lblSongResult, lblAnimalResult;

    @FXML
    private MediaView songPlayer;

    @FXML
    private ImageView imgEmoji, imgAnimal, white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16;

    AnimalGuesser ag = new AnimalGuesser();
    SongGuesser sg = new SongGuesser();
    String randomSong = sg.getSong();
    String songLocation = "/Users/67143/IdeaProjects/JavaFX_Projects/src/main/resources/guesser/songs/" + randomSong + ".mp4";
    Media song = new Media(new File(songLocation).toURI().toString());
    String randomPicture = ag.getAnimal();
    String pictureLocation = "/resources/guesser/images" + randomPicture + ".png";
    Image image = new Image(new File(pictureLocation).toURI().toString());
    Image white = new Image(new File("//Users/67143/IdeaProjects/JavaFX_Projects/src/main/resources/guesser/images/white.png").toURI().toString());
    public ImageView[] hints = {white1, white2, white3, white4, white5, white6, white7, white8, white9, white10, white11, white12, white13, white14, white15, white16};


    public void setWhites() {
        this.white1 = new ImageView(white);
        this.white2 = new ImageView(white);
        this.white3 = new ImageView(white);
        this.white4 = new ImageView(white);
        this.white5 = new ImageView(white);
        this.white6 = new ImageView(white);
        this.white7 = new ImageView(white);
        this.white8 = new ImageView(white);
        this.white9 = new ImageView(white);
        this.white10 = new ImageView(white);
        this.white11 = new ImageView(white);
        this.white12 = new ImageView(white);
        this.white13 = new ImageView(white);
        this.white14 = new ImageView(white);
        this.white15 = new ImageView(white);
        this.white16 = new ImageView(white);
    }

    public void setImgAnimal(){
        this.imgAnimal = new ImageView(image);
    }

    public void playSong() {
        MediaPlayer mediaPlayer = new MediaPlayer(song);
        songPlayer = new MediaView(mediaPlayer);
        mediaPlayer.play();
    }

    public void pauseSong() {
        songPlayer.getMediaPlayer().pause();
    }

    public void onAnimalGuessClick(ActionEvent event) throws IOException {
        pauseSong();
        Parent animalGuesser = FXMLLoader.load(getClass().getResource("animalGuesser-view.fxml"));
        Scene scene = new Scene(animalGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Animal!");
        stage.setScene(scene);
        stage.show();

        setImgAnimal();
        setWhites();
    }

    public void onSongGuessClick(ActionEvent event) throws IOException {
        Parent songGuesser = FXMLLoader.load(getClass().getResource("songGuesser-view.fxml"));
        Scene scene = new Scene(songGuesser);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guess the Song!");
        stage.setScene(scene);
        stage.show();
    }

    public void onEnterSong() {
        String guess = txtSongGuess.getText();
        String song = "";
        for(int i = 0; i<guess.length(); i++){
            if(guess.charAt(i) == ' '){
                song += '-';
            } else song+= guess.charAt(i);
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

    public void onGetHint(){
        while(true){
            int randomIndex = (int)(Math.random() * 16);
            if(hints[randomIndex] != null){
                hints[randomIndex].setVisible(false);
                hints[randomIndex] = null;
                break;
            }
        }
    }

    public void onEnterAnimal(){
        String guess = txtAnimalGuess.getText();
        if(guess.equalsIgnoreCase(randomPicture)){
            lblAnimalResult.setFont(Font.font("Avenir Book"));
            lblAnimalResult.setTextFill(Color.GREEN);
            lblAnimalResult.setText("Congratulations! You guessed the animal!");
        } else{
            lblAnimalResult.setFont(Font.font("Avenir Book"));
            lblAnimalResult.setTextFill(Color.ORANGE);
            lblAnimalResult.setText("Wrong Answer! Try Again >:)");
        }
    }

}
