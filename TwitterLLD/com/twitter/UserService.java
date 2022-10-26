package com.twitter;

public class UserService {

    public void follow(User requestedBy, User toFollow) {
        requestedBy.getFriends().addFollowing(toFollow);
        toFollow.getFriends().addFollower(requestedBy);
    }

    public void unfollow(User requestedBy, User toUnfollow) {
        requestedBy.getFriends().removeFollowing(toUnfollow);
        toUnfollow.getFriends().removeFollower(requestedBy);
    }
}
