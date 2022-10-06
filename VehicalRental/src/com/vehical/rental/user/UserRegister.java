package com.vehical.rental.user;

import java.util.HashMap;

public class UserRegister {

    private static UserRegister INSTANCE = null;

    private HashMap<String, User> users = new HashMap<>();

    private UserRegister() {
    }

    public static UserRegister getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRegister();
        }
        return INSTANCE;
    }

    public void add(User user) throws Exception {
        String key = createKey(user);
        if (users.containsKey(key))
            throw new Exception("User already present!");
        users.put(key, user);
    }

    private String createKey(User user) {
        return createKey(user.getEmail(), user.getPassword());
    }

    private String createKey(String email, String password) {
        return email + "#" + password;
    }

    public User getUser(String email, String password) {
        return users.getOrDefault(createKey(email, password), null);
    }

    public int totalUsers() {
        return users.size();
    }
}
