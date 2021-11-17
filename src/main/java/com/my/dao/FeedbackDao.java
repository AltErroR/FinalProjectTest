package com.my.dao;

import com.my.entity.Feedback;

import java.util.List;

public interface FeedbackDao {
    boolean createFeedback(int userId, String masterLogin);
    boolean updateFeedback(int id, int userId, String masterLogin, String feedbackMessage, String userRate);
    Feedback getFeedback(int userId,String masterLogin);
    Feedback getFeedback(int id);
    boolean deleteFeedback(int id);
    List<Feedback> getAllFeedbacks();
}
