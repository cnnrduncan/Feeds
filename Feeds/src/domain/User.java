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
public class User {

    private String username, picture, password, bio, nickname;
    private HashSet<User> friends;
    private HashSet<Feed> subscriptions;

    public User(String username, String password, HashSet<Feed> subscriptions) {
        this.username = username;
        this.password = password;
        this.subscriptions = subscriptions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<User> getFriends() {
        return friends;
    }

    public void setFriends(HashSet<User> friends) {
        this.friends = friends;
    }

    public HashSet<Feed> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(HashSet<Feed> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addSubscription(Feed feed) {
        subscriptions.add(feed);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
}
