package happyFamilyProject;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String nickname;
    private int age;
    private String species;
    private int trickLevel;
    private String[] habits;

    public Pet() {}

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void eat(){
        System.out.println("I am eating");
    }

    public void respond(){
        System.out.println("Hello, owner. I am " + nickname +". I miss you!");
    }

    public void foul(){
        System.out.println("I need to cover it up");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(nickname, pet.nickname)
                && Objects.equals(species, pet.species) && Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nickname, age, species, trickLevel);
        result = 3 * result + Arrays.hashCode(habits);
        return result;
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickname='" + nickname +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + java.util.Arrays.toString(habits) + "}";

    }
}