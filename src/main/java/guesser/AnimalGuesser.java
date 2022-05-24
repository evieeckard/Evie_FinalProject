package guesser;

public class AnimalGuesser {

    private String[] animals = {"Lion", "Dog", "Cat", "Deer", "Fox", "Parrot", "Lizard", "Snake", "Horse"};

    public String getAnimal() {
        int index = (int) (Math.random() * (animals.length));
        return animals[index];
    }
}
