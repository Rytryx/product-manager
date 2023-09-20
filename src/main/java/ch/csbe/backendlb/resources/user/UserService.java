package ch.csbe.backendlb.resources.user;

import java.util.List;

public interface UserService {

    // Create a new user and return the created user
    User create(User user);

    // Get a user by their unique ID
    User getById(Long id);

    // Get a list of all users in the system
    List<User> getAll();

    // Update an existing user's information by their ID and return the updated user
    User update(Long id, User user);

    // Delete a user by their ID
    void delete(Long id);

    // Find a user by their email address and return the user
    User findUserByEmail(String email);
}
