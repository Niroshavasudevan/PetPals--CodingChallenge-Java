package dao;

import entity.Pet;
import java.util.List;

public interface PetDAO {
    void addPet(Pet pet);
    List<Pet> getAllPets();
    void deletePet(String petName);
}
