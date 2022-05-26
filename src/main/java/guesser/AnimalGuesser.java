package guesser;

import java.io.File;
import java.io.IOException;

public class AnimalGuesser {

    private String[] animals = {"Lion", "Dog", "Cat", "Deer", "Fox", "Parrot", "Lizard", "Snake", "Horse"};
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


    }

    public String getAnimal() {
        int index = (int) (Math.random() * (animals.length));
        return animals[index];
    }

    public File getAnimalFile() throws IOException {
        String name = getAnimal();
        File animal = animalFiles[0];
        for(int i = 1; i<animalFiles.length; i++){
            if(animalFiles[i].getName().substring(0, animalFiles.length-4).equalsIgnoreCase(name)){
                animal = animalFiles[i];
            } else return animalFiles[(int)(Math.random() * animalFiles.length)];
        }
        return animal;
    }
}
