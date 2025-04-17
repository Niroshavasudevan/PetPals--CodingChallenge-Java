package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Pet;
import util.DBConnUtil;


public class PetDAOImpl implements PetDAO {
 

    private Connection connection;

    public PetDAOImpl() throws SQLException {
        connection = DBConnUtil.getConnection();
    }

    @Override
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getBreed());
            stmt.executeUpdate();
            System.out.println("Pet added to DB successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to add pet.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("breed")
                );
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public void deletePet(String petName) {
        String sql = "DELETE FROM pets WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, petName);
            stmt.executeUpdate();
            System.out.println("Pet deleted from DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
