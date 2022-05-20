package guesser;

public class AnimalGuesser {

    private String[] animals;

    public String getAnimal(){
        int index = (int)((Math.random() * (animals.length) + 1));
        return animals[index];
    }
}
