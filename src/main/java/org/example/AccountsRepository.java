package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountsRepository {

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT ID, LOGIN, PASSWORD FROM accounts";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String login = resultSet.getString("LOGIN");
                String password = resultSet.getString("PASSWORD");
                accounts.add(new Account(id, login, password));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving accounts", e);
        }
        return accounts;
    }

    public HashMap<String, String> getCredentialsById(int id) {
        HashMap<String, String> credentials = new HashMap<>();
        String query = "SELECT LOGIN, PASSWORD FROM accounts WHERE ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String login = resultSet.getString("LOGIN");
                String password = resultSet.getString("PASSWORD");
                credentials.put("login", login);
                credentials.put("password", password);
            } else {
                throw new RuntimeException("No account found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving account credentials", e);
        }
        return credentials;
    }
}