package entity;

import java.util.ArrayList;
import java.util.List;

public class PetShelter {
    private List<Pet> availablePets = new ArrayList<>();

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    public void listAvailablePets() {
        for (Pet pet : availablePets) {
            System.out.println(pet);
        }
    }
}
