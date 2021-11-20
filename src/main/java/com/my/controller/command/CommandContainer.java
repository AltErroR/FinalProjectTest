package com.my.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.my.constants.Constants.*;

public class CommandContainer {
    private static final Logger logger = LoggerFactory.getLogger(CommandContainer.class);
    private static final Map<String,Command> commands= new HashMap<>();
    static {
        commands.put(ADMIN_HOME,new AdminHomeCommand());
        commands.put(BOOKING,new BookingCommand());
        commands.put(CREATION,new AccountCreationCommand());
        commands.put(ERROR,new ErrorCommand());
        commands.put(FEEDBACK,new FeedbackCommand());
        commands.put(WRITE_FEEDBACK,new FeedbackWriteCommand());
        commands.put(HOME,new HomePageCommand());
        commands.put(LOGIN,new LoginCommand());
        commands.put(LOG_OUT,new LogoutCommand());
        commands.put(MAIN,new MainPageCommand());
        commands.put(MAIN_MASTER,new SortByMasterCommand());
        commands.put(MAIN_SERVICE,new SortByServiceCommand());
        commands.put(MAIN_RATING,new SortByRatingCommand());
        commands.put(MAIN_MASTER_NAME,new SortByMasterLoginCommand());
        commands.put(MAIN_SERVICE_NAME,new SortByServiceNameCommand());
        commands.put(MASTER_HOME,new MasterHomeInitCommand());
        commands.put(ORDERS,new OrdersCommand());
        commands.put(CHANGE_ORDER,new OrderChangeCommand());
        commands.put(PAYMENT,new PaymentCommand());
        commands.put(ACCEPT_PAYMENT,new PaymentAcceptCommand());
        commands.put(CHANGE_STATUS,new StatusChangeCommand());
        commands.put(SUCCESS,new SuccessCommand());
        commands.put(CHANGE_LANGUAGE,new ChangeLanguageCommand());
    }
    public static Command getCommand(String commandName){
        logger.debug("command: {} invoked ", commandName);
        return commands.get(commandName);
    }

    private CommandContainer(){ }
}
