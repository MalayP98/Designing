package com.twitter;

public class Comment extends BaseTweet {

    public Comment(Long id, String content, Long ownerId) {
        super(id, content, ownerId);
    }

    @Override
    public String toString() {
        return "Comment by user " + getOwner() + ": " + getContent();
    }
}
