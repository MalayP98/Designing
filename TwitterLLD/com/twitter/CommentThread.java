package com.twitter;

import java.util.ArrayList;
import java.util.List;

public class CommentThread {

    private Long id;

    private List<Comment> comments = new ArrayList<>();

    public CommentThread(Long id) {
        this.id = id;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Thread" + id + ": \n");
        for (Comment comment : comments) {
            builder.append(comment.toString() + "\n");
        }
        return builder.toString();
    }
}
