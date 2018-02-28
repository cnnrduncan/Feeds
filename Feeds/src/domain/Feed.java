/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashSet;

/**
 *
 * @author cnnrd
 */
public class Feed {
    private Integer feedID;
    private String name, picture;
    private HashSet<Post> posts;
    private Integer numPosts, numSubs;

    public Feed(Integer feedID, String name) {
        this.feedID = feedID;
        this.name = name;
    }

    public Feed(Integer feedID, String name, String picture) {
        this.feedID = feedID;
        this.name = name;
        this.picture = picture;
    }

    public Integer getFeedID() {
        return feedID;
    }

    public void setFeedID(Integer feedID) {
        this.feedID = feedID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public HashSet<Post> getPosts() {
        return posts;
    }

    public void setPosts(HashSet<Post> posts) {
        this.posts = posts;
    }

    public Integer getNumPosts() {
        return numPosts;
    }

    public void setNumPosts(Integer numPosts) {
        this.numPosts = numPosts;
    }

    public Integer getNumSubs() {
        return numSubs;
    }

    public void setNumSubs(Integer numSubs) {
        this.numSubs = numSubs;
    }
    
    public void addPost(Post post){
        posts.add(post);
    }
}
