/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author cnnrd
 */
public class Post {

    private Integer postID, score;
    private String text;
    private HashSet<Feed> feeds;
    private User poster;
    private ArrayList<String> attachments;
    private HashSet<Post> parentPosts;

    public Post(String text, HashSet<Feed>  feed) {
        this.text = text;
        this.feeds = feed;
    }

    public Post(String text, HashSet<Feed>  feed, User poster) {
        this.text = text;
        this.feeds = feed;
        this.poster = poster;
    }

    public Post(String text, HashSet<Feed>  feed, ArrayList<String> attachments) {
        this.text = text;
        this.feed = feed;
        this.attachments = attachments;
    }

    public Post(String text, HashSet<Feed>  feed, User poster, ArrayList<String> attachments) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
        this.attachments = attachments;
    }

    public Post(String text, HashSet<Feed>  feed, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.parentPosts = parentPosts;
    }

    public Post(String text, Feed feed, User poster, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
        this.parentPosts = parentPosts;
    }

    public Post(String text, Feed feed, ArrayList<String> attachments, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.attachments = attachments;
        this.parentPosts = parentPosts;
    }

    public Post(String text, Feed feed, User poster, ArrayList<String> attachments, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
        this.attachments = attachments;
        this.parentPosts = parentPosts;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPostID() {
        return postID;
    }

    public String getText() {
        return text;
    }

    public Feed getFeed() {
        return feed;
    }

    public User getPoster() {
        return poster;
    }

    public ArrayList<String> getAttachments() {
        return attachments;
    }

    public HashSet<Post> getParentPosts() {
        return parentPosts;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public void setAttachments(ArrayList<String> attachments) {
        this.attachments = attachments;
    }

    public void setParentPosts(HashSet<Post> parentPosts) {
        this.parentPosts = parentPosts;
    }

    
}
