package com.twitter;

public class Comment extends BaseTweet {

    private User byUser;

    public Comment(Long id, String content, User byUser) {
        super(id, content);
        this.byUser = byUser;
    }

    public User getByUser() {
        return byUser;
    }

    @Override
    public String toString() {
        return "Comment by user " + byUser.getUsername() + ": " + getContent();
    }
}
