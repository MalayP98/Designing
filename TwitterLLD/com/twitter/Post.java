package com.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post extends BaseTweet {

    private List<CommentThread> commentThreads = new ArrayList<>();

    public Post(Long id, String content, Long ownerId) {
        super(id, content, ownerId);
    }

    public CommentThread addCommentThread(Comment comment) {
        CommentThread commentThread = new CommentThread(IdGenerator.generate());
        commentThreads.add(commentThread);
        addToCommentThread(commentThread.getId(), comment);
        return commentThread;
    }

    public void addToCommentThread(Long threadId, Comment comment) {
        CommentThread commentThread = getThreadWithId(threadId);
        if (Objects.nonNull(commentThread))
            commentThread.addComment(comment);
        else
            System.out.println("No Comment Thread found with supplied id.");
    }

    public CommentThread getThreadWithId(Long threadId) {
        for (CommentThread commentThread : commentThreads) {
            if (commentThread.getId() == threadId)
                return commentThread;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tweet (id=" + getId() + "): " + getContent());
        for (CommentThread commentThread : commentThreads) {
            builder.append("\n**********************\n");
            builder.append(commentThread.toString());
            builder.append("**********************\n");
        }
        return builder.toString();
    }
}
