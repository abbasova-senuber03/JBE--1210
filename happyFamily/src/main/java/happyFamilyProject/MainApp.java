package happyFamilyProject;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        Pet pet = new Pet("dog", "Rock", 5, 55, new String[]{"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1955);
        Human father = new Human("Vito", "Karleone", 1950);

        String[][] schedule = {
                {"Monday", "Go to the gym"},
                {"Tuesday", "Do homework"}
        };
        Human child = new Human("Michael", "Karleone", 1977, 90, pet, father, mother, schedule);

        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);

        child.greetPet();
        child.describePet();
        pet.eat();
        pet.respond();
        pet.foul();

        boolean fed = child.feedPet(false);
        System.out.println("Was the pet fed? " + fed);

        Family family1 = new Family(mother, father);
        System.out.println(family1);

        family1.addChild(child);
        family1.addChild(child);
        System.out.println(Arrays.deepToString(family1.getChildren()));
    }
}