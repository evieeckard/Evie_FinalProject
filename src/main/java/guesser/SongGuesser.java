package guesser;

public class SongGuesser {

    private String[] songs = {"Kiss-Me-More", "Faded"};

    public String getSong() {
        int index = (int) ((Math.random() * ((songs.length - 1) + 1)));
        return songs[index];
    }


}
