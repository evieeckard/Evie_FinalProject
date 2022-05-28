package guesser;

public class SongGuesser {

    private String[] songs = {"Somebody-That-I-Used-To-Know", "Faded", "Shape-Of-You", "Happy", "Bad-Guy", "Kiss-Me-More", "Sugar", "Raining-Tacos", "Mic-Drop", "The-Less-I-Know-The-Better", "Riptide", "E_Girls-Are-Ruining-My-Life", "Feel-Good-Inc"};

    public String getSong() {
        int index = (int) (Math.random() * songs.length);
        return songs[index];
    }


}
