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
    private HashSet<User> administrators;

    public Feed(Integer feedID, String name, HashSet<User> administrators) {
        this.feedID = feedID;
        this.name = name;
        this.administrators = administrators;
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

    public HashSet<User> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(HashSet<User> administrators) {
        this.administrators = administrators;
    }
    
    
}
