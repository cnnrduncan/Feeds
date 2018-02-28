/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Feed;
import domain.Post;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author cnnrd
 */
public class JDBCFeedDAO implements FeedDAO {

    private static String DB_URL = "jdbc:h2:tcp://localhost:9092/Feeds;IFEXISTS=TRUE";

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

    public JDBCFeedDAO() {
    }

    public JDBCFeedDAO(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    @Override
    public void add(Feed feed) {

        String sql = "insert into Feeds (ID, FEEDNAME, NUMSUBS, NUMPOSTS)"
                + " values (?,?,?,?)";

        try (
                // get connection to database
                Connection dbCon = JDBCFeedDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // copy the data from the customer domain object into the SQL parameters
            stmt.setInt(1, feed.getFeedID());
            stmt.setString(2, feed.getName());
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);

            stmt.executeUpdate();  // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(Feed feed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Post> getPosts(Feed feed, Integer postsToRetrieve) {
        
        String sql = "select * from Feeds where ID = ?";

        HashSet<String> postIDs;

        try (
                // get connection to database
                Connection connection = JDBCFeedDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            // set the parameter
            stmt.setString(1, feedID);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            int i = 0;
            while (rs.next() && i <= postsToRetrieve) {

                // get the data out of the query
                ID = rs.getInt("ID");
                

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }.
    }

    @Override
    public Collection<User> getAdministrators(Feed feed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feed searchID(String feedID) {

        String sql = "select * from Feeds where ID = ?";

        Integer ID, numSubs, numPosts;
        String name, picture;
        HashSet<User> administrators;

        try (
                // get connection to database
                Connection connection = JDBCFeedDAO.getConnection(DB_URL);
                // create the statement
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            // set the parameter
            stmt.setString(1, feedID);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            if (rs.next()) {

                // get the data out of the query
                ID = rs.getInt("ID");
                name = rs.getString("FeedName");
                picture = rs.getString("Picture");
                numSubs = rs.getInt("NumSubs");
                numPosts = rs.getInt("NumPosts");

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Feed> searchName(String feedName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
