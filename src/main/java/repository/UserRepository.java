package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.User;

public class UserRepository extends BaseRepository {
	
	public boolean existsByUsername(String username) {
		try (PreparedStatement statement = db.prepareStatement("SELECT COUNT(*) FROM users WHERE name = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Check if count > 0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}
	
	public boolean existsByEmail(String email) {
		try (PreparedStatement statement = db.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Check if count > 0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}
	
    // Save a new user into the database
	public void save(User user) {
		String query = "INSERT INTO users (name,password,email,birthday,gender,platform,communitiesOfInterest) VALUES (?,?,?,?,?,?,?)";
		try (PreparedStatement statement = db.prepareStatement(query)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setDate(4, user.getBirthday());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getPlatform());
			statement.setString(7, user.getCommunitiesOfInterest());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Find a user by their name
    public Optional<User> findByName(String name) {
        String query = "SELECT id, name, password FROM users WHERE name = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
        	statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    // Retrieve all users from the database
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, name, password FROM users";
        
        try (PreparedStatement statement = db.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }

}