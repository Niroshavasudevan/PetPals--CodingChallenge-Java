package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnUtil;

public class DonationDAOImpl implements DonationDAO {

    private Connection connection;

    public DonationDAOImpl() {
        connection = DBConnUtil.getConnection("db.properties");
    }

    @Override
    public void addCashDonation(String donorName, double amount) {
        String sql = "INSERT INTO donations (donor_name, amount) VALUES (?, ?)";
        try (   Connection connection = DBConnUtil.getConnection();
        		PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, donorName);
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
            System.out.println("Donation recorded successfully.");
        } catch (SQLException e) {
        	System.out.println("Failed to record donation.");
            e.printStackTrace();
        }
    }
}
