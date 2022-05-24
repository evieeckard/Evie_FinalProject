package guesser;

public class SongGuesser {

    private String[] songs = {"Kiss-Me-More", "Faded", "Shape-Of-You", "Happy", "Bad-Guy", "One-Kiss", "Somebody-That-I-Used-To-Know", "Sugar", "Bulletproof", "Raining-Tacos"};

    public String getSong() {
        int index = (int) ((Math.random() * ((songs.length - 1) + 1)));
        return songs[index];
    }


}
