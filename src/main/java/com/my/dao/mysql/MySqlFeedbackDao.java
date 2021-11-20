package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.FeedbackDao;
import com.my.entity.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlFeedbackDao implements FeedbackDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlFeedbackDao.class);

    @Override
    public boolean createFeedback(int userId, String masterLogin) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_FEEDBACK);
            ps.setInt(1,userId);
            ps.setString(2,masterLogin);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("feedback creation failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateFeedback(int id, int userId, String masterLogin, String feedbackMessage, String userRate) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_FEEDBACK);
            ps.setInt(1,userId);
            ps.setString(2,masterLogin);
            ps.setString(3,feedbackMessage);
            ps.setString(4,userRate);
            ps.setInt(5,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("feedback update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Feedback getFeedback(int id) {
        Feedback feedback;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_FEEDBACK);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                return null;}
            feedback= new Feedback(rs.getInt(1),rs.getInt(2),rs.getString(3));
            feedback.setFeedbackMessage(rs.getString(4));
            feedback.setUserRate(rs.getString(5));

        } catch (Exception e) {
            logger.error("feedback extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return feedback;
    }
    @Override
    public Feedback getFeedback(int userId,String masterLogin) {
        Feedback feedback;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_FEEDBACK_BY_USER_MASTER);
            ps.setInt(1, userId);
            ps.setString(2, masterLogin);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no feedback data");
                return null;}
            feedback= new Feedback(rs.getInt(1),rs.getInt(2),rs.getString(3));
            feedback.setFeedbackMessage(rs.getString(4));
            feedback.setUserRate(rs.getString(5));

        } catch (Exception e) {
            logger.error("feedback extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return feedback;
    }

    @Override
    public boolean deleteFeedback(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_FEEDBACK);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("feedback delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Feedback> feedbacks= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_FEEDBACK_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                feedbacks.add(getFeedback(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("feedback list extraction failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return feedbacks;
    }
}
