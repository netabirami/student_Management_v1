package com.StartStep.new_student_management_v1;

import java.util.HashMap;

public class UserManagement {

    private static HashMap<String, User> userHashMap = new HashMap<>();

    public static void registerUser(String username, String password) {
        // Check if the username already exists
        if (userHashMap.containsKey(username)) {
            System.out.println("Username already exists");
            return;
        }

        // Create a new user object
        User user = new User(username, password);

        // Add the user to the hashmap
        userHashMap.put(username, user);
        System.out.println("User registered successfully");
    }

    public boolean loginUser(String username, String password) {
        // Check if the username exists
        if (!userHashMap.containsKey(username)) {
            System.out.println("Username does not exist");
            return false;
        }

        // Get the user object from the hashmap
        User user = userHashMap.get(username);

        // Check if the password is correct
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password");
            return false;
        }
        System.out.println("User logged in successfully");
        return true;
    }
    // CRUD operations for users
    public User getUser(String username) {
        return userHashMap.get(username);
    }
    public void addUser(User user) {
        userHashMap.put(user.getUsername(), user);
    }
    public void deleteUser(String username) {
        userHashMap.remove(username);
    }
}
