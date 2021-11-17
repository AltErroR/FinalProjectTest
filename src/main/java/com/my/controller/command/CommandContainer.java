package com.my.controller.command;

import com.my.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private static Map<String,Command> commands= new HashMap<>();
    static {
        commands.put("adminHomeInit",new AdminHomeCommand());
        commands.put("booking",new BookingCommand());
        commands.put("creation",new AccountCreationCommand());
        commands.put("error",new ErrorCommand());
        commands.put("feedback",new FeedbackCommand());
        commands.put("feedbackWrite",new FeedbackWriteCommand());
        commands.put("home",new HomePageCommand());
        commands.put("login",new LoginCommand());
        commands.put("logout",new LogoutCommand());
        commands.put("mainPage",new MainPageCommand());
        commands.put("mainPageByMaster",new SortByMasterCommand());
        commands.put("mainPageByService",new SortByServiceCommand());
        commands.put("mainPageByRating",new SortByRatingCommand());
        commands.put("mainPageByMasterLogin",new SortByMasterLoginCommand());
        commands.put("mainPageByServiceName",new SortByServiceNameCommand());
        commands.put("masterHomeInit",new MasterHomeInitCommand());
        commands.put("orders",new OrdersCommand());
        commands.put("orderChange",new OrderChangeCommand());
        commands.put("payment",new PaymentCommand());
        commands.put("paymentAccept",new PaymentAcceptCommand());
        commands.put("statusChange",new StatusChangeCommand());
        commands.put("success",new SuccessCommand());
    }
    public static Command getCommand(String commandName){
        logger.debug("command "+ commandName+" invoked");
        return commands.get(commandName);
    }

    private CommandContainer(){ }
}
