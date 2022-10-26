package com.twitter;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post getPost(Long postId) {
        for (Post post : posts)
            if (post.getId() == postId)
                return post;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Post post : posts) {
            builder.append(post.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
