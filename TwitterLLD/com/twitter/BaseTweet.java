package com.twitter;

import java.util.Set;

public abstract class BaseTweet {

    private Long id;

    private String content;

    private Long ownerId;

    private Set<Long> likedByUsers;

    public BaseTweet(Long id, String content, Long ownerId) {
        this.id = id;
        this.content = content;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getLikes() {
        return likedByUsers.size();
    }

    public void like(Long userId) {
        likedByUsers.add(userId);
    }

    public void dislike(Long userId) {
        likedByUsers.remove(userId);
    }

    public Long getOwner() {
        return ownerId;
    }
}
