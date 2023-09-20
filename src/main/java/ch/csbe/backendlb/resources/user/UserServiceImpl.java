package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.user.Dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        // Retrieve and return a list of all users in the system
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        // Return the user if found, otherwise return null
        return userOptional.orElse(null);
    }

    @Override
    public User create(User user) {
        // Create a new user and return the created user
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            // If the user exists, update their username and email
            User existingUser = userOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        // If the user doesn't exist, return null
        return null;
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            // Delete the user with the specified ID if it exists
            userRepository.deleteById(id);
        } else {
            // Throw an exception if the user with the specified ID is not found
            throw new ResourceNotFoundException("User with the id " + id + " could not be found!");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElse(null);
    }

    public boolean userExistsById(Long id) {
        // Check if a user with the specified ID exists
        return userRepository.existsById(id);
    }

    public User getUserWithCredentials(LoginRequestDto loginRequestDto) {
        // Get the username and password from the LoginRequestDto
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        // Perform authentication logic (e.g., checking credentials against a database)
        // Here, we'll assume a simple check for demonstration purposes
        User authenticatedUser = userRepository.findByUsernameAndPassword(username, password);

        return authenticatedUser;
    }

}
