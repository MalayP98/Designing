package com.twitter;

import java.util.ArrayList;
import java.util.List;

public class Friends {

    private List<User> followers = new ArrayList<>();

    private List<User> following = new ArrayList<>();

    public void addFollower(User user) {
        followers.add(user);
    }

    public void addFollowing(User user) {
        following.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void removeFollowing(User user) {
        following.remove(user);
    }

    public void notify(Post post) {
        for (User follower : followers) {
            follower.getWall().addPost(post);
        }
    }
}
