package com.my.controller.service.imlementation;

import com.my.controller.command.FeedbackCommand;
import com.my.controller.service.FeedbackService;
import com.my.dao.mysql.MySqlFeedbackDao;
import com.my.entity.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
    MySqlFeedbackDao mySqlFeedbackDao= new MySqlFeedbackDao();
    List<Feedback> feedbacks= new ArrayList<>();
    @Override
    public String feedbackInit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        feedbacks= mySqlFeedbackDao.getAllFeedbacks();
        if(feedbacks.isEmpty()){
            logger.warn("feedbacks list is clear");
            throw  new Exception("No feedbacks yet");
        }
        request.setAttribute("feedbackList",feedbacks);
        logger.debug("success");
        return "view/feedback.jsp";
    }
    @Override
    public String feedbackWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int userId =(int) request.getSession().getAttribute("userId");
        String message=request.getParameter("message");
        String rate=request.getParameter("rate");
        String masterLogin=request.getParameter("master");
        Feedback feedback=mySqlFeedbackDao.getFeedback(userId,  masterLogin);
        if(feedback!=null){
            logger.warn("feedbacks insertion to bd failed");
            throw new Exception("You already left your feedback, to this master, thanx");
        }
         mySqlFeedbackDao.createFeedback(userId,masterLogin);
        feedback=mySqlFeedbackDao.getFeedback(userId,  masterLogin);
        mySqlFeedbackDao.updateFeedback(feedback.getId(),userId,masterLogin,message,rate);
        logger.debug("success");
        return "view/success.jsp";
    }
    
}
