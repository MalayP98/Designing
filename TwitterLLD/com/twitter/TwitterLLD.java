package com.twitter;

public class TwitterLLD {

    public static void main(String[] args) {
        Driver driver = new Driver(new UserService(), new TweetService());
        driver.run();
    }
}
