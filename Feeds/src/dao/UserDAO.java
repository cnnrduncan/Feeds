/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Feed;
import domain.User;
import java.util.Collection;

/**
 *
 * @author cnnrd
 */

public interface UserDAO {
    //Add or delete a user
    public void add(User user);
    public void delete(User user);
    
    //Get user information
    public String getPicture(User user);
    public String getNickname(User user);
    public String getBio(User user);
    public Collection<User> getFriends(User user);
    public Collection<Feed> getSubscriptions(User user);
    
    //Find users by using known information
    public User searchUsername(String username);
    
    //Validate credentials -- MAKE THIS SECURE ASAP
    public boolean validate(String username, String password);
}
