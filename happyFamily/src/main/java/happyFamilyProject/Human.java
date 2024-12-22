package happyFamilyProject;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human extends Family {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;

    private String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        super(mother, father);
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this(name, surname, year, mother, father);
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnam() {
        return surname;
    }

    public void setSurnam(String surnam) {
        this.surname = surnam;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        if (pet != null) {
            System.out.println("Hello, " + pet.getNickname());
        } else {
            System.out.println("No pet to greet");
        }
    }

    public void describePet() {
        if (pet != null) {
            String slyLevel = (pet.getTrickLevel() > 50) ? "very sly" : "almost not sly";
            System.out.println("I have a " + pet.getSpecies() + ", it is " + pet.getAge() + " years old, it is " + slyLevel + ".");
        } else {
            System.out.println("No pet to describe");
        }
    }
    public boolean feedPet(boolean isItTimeForFeeding) {
        if (pet == null) {
            System.out.println("No pet to feed");
            return false;
        }
        if (isItTimeForFeeding) {
            System.out.println("Hm... I will feed " + name + "'s " + pet.toString());
            return true;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(101); // 0-100
            if (pet.getTrickLevel()> randomNumber) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.getNickname());
                return true;
            } else {
                System.out.println("I think " + name + " is not hungry.");
                return false;
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname)
                && Objects.equals(pet, human.pet) && Objects.equals(getMother(), getFather()) && Objects.equals(getMother(), getFather())
                && Arrays.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq, pet, getMother(), getFather());
        result = 31 * result + Arrays.hashCode(schedule);
        return result;
    }

    @Override
    public String toString() {
        return "Human{name='" + name +
                ", surname='" + surname +
                ", year=" + year +
                ", iq=" + iq +
                ", mother=" + (getMother() != null ? getMother().name + " " + getMother().surname : "unknown") +
                ", father=" + (getFather() != null ? getFather().name + " " + getFather().surname : "unknown") +
                ", pet=" + (pet != null ? pet.toString():"Dont have a pet") + "}";

    }
}