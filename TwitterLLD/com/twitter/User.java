package com.twitter;

public class User {

    private Long id;

    private String username;

    private String password;

    private Wall wall;

    private Friends friends;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        wall = new Wall();
        friends = new Friends();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Wall getWall() {
        return wall;
    }

    public Friends getFriends() {
        return friends;
    }
}
