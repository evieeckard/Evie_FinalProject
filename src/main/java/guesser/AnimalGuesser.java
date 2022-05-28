package guesser;

import java.io.File;
import java.io.IOException;

public class AnimalGuesser {

    private String[] animals = {"Lion", "Dog", "Cat", "Deer", "Fox", "Parrot", "Lizard", "Snake", "Horse", "Bear", "Giraffe", "Capybara", "Panda", "Zebra", "Fish"};
    private File[] animalFiles = new File[animals.length];

    public AnimalGuesser() {
        animalFiles[0] = new File("src/main/resources/guesser/images/Lion.png");
        animalFiles[1] = new File("src/main/resources/guesser/images/Dog.png");
        animalFiles[2] = new File("src/main/resources/guesser/images/Cat.png");
        animalFiles[3] = new File("src/main/resources/guesser/images/Deer.png");
        animalFiles[4] = new File("src/main/resources/guesser/images/Fox.png");
        animalFiles[5] = new File("src/main/resources/guesser/images/Parrot.png");
        animalFiles[6] = new File("src/main/resources/guesser/images/Lizard.png");
        animalFiles[7] = new File("src/main/resources/guesser/images/Snake.png");
        animalFiles[8] = new File("src/main/resources/guesser/images/Horse.png");
        animalFiles[9] = new File("src/main/resources/guesser/images/Bear.png");
        animalFiles[10] = new File("src/main/resources/guesser/images/Giraffe.png");
        animalFiles[11] = new File("src/main/resources/guesser/images/Capybara.png");
        animalFiles[12] = new File("src/main/resources/guesser/images/Panda.png");
        animalFiles[13] = new File("src/main/resources/guesser/images/Zebra.png");
        animalFiles[14] = new File("src/main/resources/guesser/images/Fish.png");


    }

    public File getAnimalFile() throws IOException {
        return animalFiles[(int)(Math.random() * animalFiles.length)];
    }
}
