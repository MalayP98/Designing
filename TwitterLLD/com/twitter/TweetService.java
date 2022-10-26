package com.twitter;

public class TweetService {

    public Post addPost(User user, String post) {
        Post addedPost = new Post(IdGenerator.generate(), post);
        user.getFriends().notify(addedPost);
        return addedPost;
    }

    public CommentThread addNewComment(Post forPost, String comment, User user) {
        return forPost.addCommentThread(new Comment(IdGenerator.generate(), comment, user));
    }

    public void addCommentToThread(Post forPost, String comment, User user, Long threadId) {
        forPost.addToCommentThread(threadId, new Comment(threadId, comment, user));
    }

    public void likeTwitte(User user, BaseTweet baseTwitte) {
        baseTwitte.like(user.getId());
    }

    public void dislikeTwitte(User user, BaseTweet baseTwitte) {
        baseTwitte.dislike(user.getId());
    }
}
