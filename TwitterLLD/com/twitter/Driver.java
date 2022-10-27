package com.twitter;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private UserService userService;

    private TweetService tweetService;

    public Driver(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService = tweetService;
    }

    public void run() {

        // 1. Create n users account.
        int n = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add(new User(IdGenerator.generate(), "Username" + i + 1, "Password" + i + 1));
        }

        // 2. Follow users.
        userService.follow(users.get(0), users.get(1));
        userService.follow(users.get(3), users.get(1));
        userService.follow(users.get(4), users.get(1));

        userService.follow(users.get(1), users.get(3));
        userService.follow(users.get(1), users.get(5));
        userService.follow(users.get(1), users.get(8));

        userService.follow(users.get(2), users.get(1));
        userService.follow(users.get(2), users.get(9));
        userService.follow(users.get(2), users.get(4));

        // 3. Make users tweet.
        Post addedPost = tweetService.addPost(users.get(1), "Hello, from User-1");

        // Add comment
        CommentThread newCommentThread =
                tweetService.addNewComment(addedPost, "Hi there.", users.get(0));
        tweetService.addCommentToThread(addedPost, "Welcome to Twitter!", users.get(3),
                newCommentThread.getId());
        tweetService.addCommentToThread(addedPost, "Hello from user-4", users.get(4),
                newCommentThread.getId());

        // Add comment
        newCommentThread = tweetService.addNewComment(addedPost, "Hi there.", users.get(0));
        tweetService.addCommentToThread(addedPost, "Welcome to Twitter!", users.get(3),
                newCommentThread.getId());
        tweetService.addCommentToThread(addedPost, "Hello from user-4", users.get(4),
                newCommentThread.getId());

        // Make user tweet
        addedPost = tweetService.addPost(users.get(1), "Here is a new tweet.");

        // Add comment
        newCommentThread = tweetService.addNewComment(addedPost, "Nice", users.get(0));
        tweetService.addCommentToThread(addedPost, "Well done.", users.get(3),
                newCommentThread.getId());
        tweetService.addCommentToThread(addedPost, "Good one.", users.get(4),
                newCommentThread.getId());

        // Add comment
        newCommentThread = tweetService.addNewComment(addedPost, "Nice", users.get(0));
        tweetService.addCommentToThread(addedPost, "Well done.", users.get(3),
                newCommentThread.getId());
        tweetService.addCommentToThread(addedPost, "Good one.", users.get(4),
                newCommentThread.getId());

        // 4 Disply User-1 wall.
        System.out.println(users.get(0).getWall());

    }

}
