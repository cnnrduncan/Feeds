/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author cnnrd
 */
public class JDBCPostDAO implements PostDAO{

    private static String DB_URL = "jdbc:h2:tcp://localhost:9092/Feeds;IFEXISTS=TRUE;allowMultiQueries=true";

    private static final String USERNAME = "sa"; // H2 default
    private static final String PASSWORD = ""; // H2 default

    private static JdbcConnectionPool pool;

    public static Connection getConnection(String url) {
        if (pool == null) {
            pool = JdbcConnectionPool.create(url, USERNAME, PASSWORD);
        }
        try {
            return pool.getConnection();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    public JDBCPostDAO() {
    }

    public JDBCPostDAO(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    @Override
    public void add(Post post) {
        
        String sql = "insert into Posts (ID, PostText, Score, PosterID)"
                + " values (?,?,?,?)";

        try (
                // get connection to database
                Connection dbCon = JDBCFeedDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // copy the data from the customer domain object into the SQL parameters
            stmt.setInt(1, post.getPostID());
            stmt.setString(2, post.getText());
            stmt.setInt(3, 1);
            stmt.setString(4, post.getPoster().getUsername());

            stmt.executeUpdate();  // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }
        
        sql = "insert into Feed_Posts (PostID, FeedID)"
                + " values (?,?)";

        try (
                // get connection to database
                Connection dbCon = JDBCFeedDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            for(Feed f : post.getFeeds()){
            stmt.setInt(1, post.getPostID());
            stmt.setString(2, post.getText());
            stmt.setInt(3, 1);
            stmt.setString(4, post.getPoster().getUsername());

            stmt.executeUpdate();  // execute the statement
            }

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Post post) {
        
        String sql = "delete from Posts where ID = ?; ";

        try (
                // get connection to database
                Connection connection = JDBCPostDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            // set the parameter
            stmt.setInt(1, post.getPostID());

            // execute the query
            stmt.execute();

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Post searchID(String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
