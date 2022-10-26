package com.twitter;

import java.util.Set;

public class BaseTweet {

    private Long id;

    private String content;

    private Set<Long> likedByUsers;

    public BaseTweet(Long id, String content) {
        this.id = id;
        this.content = content;
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
}
