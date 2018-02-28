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
class Post {

    private Integer postID, score;
    private String text;
    private Feed feed;
    private User poster;
    private ArrayList<String> images;
    private HashSet<Post> parentPosts;

    public Post(String text, Feed feed) {
        this.text = text;
        this.feed = feed;
    }

    public Post(String text, Feed feed, User poster) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
    }

    public Post(String text, Feed feed, ArrayList<String> images) {
        this.text = text;
        this.feed = feed;
        this.images = images;
    }

    public Post(String text, Feed feed, User poster, ArrayList<String> images) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
        this.images = images;
    }

    public Post(String text, Feed feed, HashSet<Post> parentPosts) {
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

    public Post(String text, Feed feed, ArrayList<String> images, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.images = images;
        this.parentPosts = parentPosts;
    }

    public Post(String text, Feed feed, User poster, ArrayList<String> images, HashSet<Post> parentPosts) {
        this.text = text;
        this.feed = feed;
        this.poster = poster;
        this.images = images;
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

    public ArrayList<String> getImages() {
        return images;
    }

    public HashSet<Post> getParentPosts() {
        return parentPosts;
    }

}
