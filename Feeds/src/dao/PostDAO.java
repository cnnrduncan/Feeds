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

public interface PostDAO {
    //Add or delete a post
    public void add(Post post);
    public void delete(Post post);

    //Find posts by using known information
    public Post searchID(String postID);
    //public Collection<Post> searchFeed(Feed feed);
    //public Collection<Post> searchText(String string);
}
