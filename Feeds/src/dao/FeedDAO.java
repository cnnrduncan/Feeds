/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Feed;
import domain.User;
import domain.Post;

import java.util.Collection;

/**
 *
 * @author cnnrd
 */

public interface FeedDAO {
    //Add or delete a feed
    public void add(Feed feed);
    public void delete(Feed feed);
    
    //Get feed information
    public Collection<Post> getPosts(Feed feed, Integer postsToRetrieve);
    public Collection<User> getAdministrators(Feed feed);
    
    //Find feeds by using known information
    public Feed searchID(String feedID);
    public Collection<Feed> searchName(String feedName);
    //public Collection<Feed> searchAdministrator(User admin);
}
