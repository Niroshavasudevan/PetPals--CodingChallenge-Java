package main;

import dao.*;
import entity.Pet;
import exception.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PetDAO petDAO = null;
        try {
            petDAO = new PetDAOImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (petDAO == null) {
            System.out.println("Failed to initialize PetDAO. Exiting program.");
            return;
        }

        DonationDAO donationDAO = new DonationDAOImpl();

        int choice;

        do {
            System.out.println("\n====== Welcome to PetPals ======");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Delete Pet");
            System.out.println("4. Make Donation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {

                case 1:
                    // Add Pet
                    try {
                        System.out.print("Enter Pet Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Pet Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();  // consume newline

                        if (age <= 0)
                            throw new InvalidPetAgeException("Pet age must be a positive number.");

                        System.out.print("Enter Pet Breed: ");
                        String breed = sc.nextLine();

                        Pet pet = new Pet(name, age, breed);
                        petDAO.addPet(pet);

                    } catch (InvalidPetAgeException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Something went wrong while adding pet.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // View Pets
                    try {
                        List<Pet> pets = petDAO.getAllPets();
                        if (pets.isEmpty()) {
                            System.out.println("No pets available.");
                        } else {
                            for (Pet p : pets) {
                                if (p.getName() == null || p.getAge() == 0) {
                                    throw new NullReferenceException("Pet details missing.");
                                }
                                System.out.println(p);
                            }
                        }
                    } catch (NullReferenceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Delete Pet
                    System.out.print("Enter Pet Name to Delete: ");
                    String delName = sc.nextLine();
                    petDAO.deletePet(delName);
                    break;

                case 4:
                    // Donation
                    try {
                        System.out.print("Enter Donor Name: ");
                        String donor = sc.nextLine();
                        System.out.print("Enter Donation Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();  // consume newline

                        if (amount < 10) {
                            throw new InsufficientDonationException("Minimum donation is ₹10.");
                        }

                        donationDAO.addCashDonation(donor, amount);

                    } catch (InsufficientDonationException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thanks for visiting PetPals!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
