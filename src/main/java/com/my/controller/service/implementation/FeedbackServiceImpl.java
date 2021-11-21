package com.my.controller.service.implementation;

import com.my.controller.service.FeedbackService;
import com.my.dao.DaoFactory;
import com.my.dao.FeedbackDao;
import com.my.dao.OrderDao;
import com.my.dao.mysql.MySqlDaoFactory;
import com.my.dao.mysql.MySqlFeedbackDao;
import com.my.entity.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;

public class FeedbackServiceImpl implements FeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    FeedbackDao mySqlFeedbackDao=daoFactory.getFeedbackDao();
    List<Feedback> feedbacks= new ArrayList<>();
    @Override
    public String feedbackInit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        feedbacks= mySqlFeedbackDao.getAllFeedbacks();
        if(feedbacks.isEmpty()){
            logger.warn("feedbacks list is clear");
            throw  new Exception("No feedbacks yet");
        }
        request.setAttribute(FEEDBACK_LIST,feedbacks);
        logger.debug("success");
        return FEEDBACK_JSP;
    }
    @Override
    public String feedbackWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int userId =(int) request.getSession().getAttribute(USER_ID);
        String message=request.getParameter(MESSAGE);
        String rate=request.getParameter(RATE);
        String masterLogin=request.getParameter(MASTER);
        Feedback feedback=mySqlFeedbackDao.getFeedback(userId,  masterLogin);
        if(feedback!=null){
            logger.warn("feedbacks insertion to bd failed");
            throw new Exception("You already left your feedback, to this master, thanx");
        }
         mySqlFeedbackDao.createFeedback(userId,masterLogin);
        feedback=mySqlFeedbackDao.getFeedback(userId,  masterLogin);
        mySqlFeedbackDao.updateFeedback(feedback.getId(),userId,masterLogin,message,rate);
        logger.debug("success");
        return SUCCESS_JSP;
    }
    
}
