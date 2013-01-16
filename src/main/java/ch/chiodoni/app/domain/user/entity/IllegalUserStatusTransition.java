package ch.chiodoni.app.domain.user.entity;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 21.11.12
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class IllegalUserStatusTransition extends RuntimeException {
    public IllegalUserStatusTransition(UserStatus value) {
        super("The transition from the current user status (" + value + ") is not allowed");
    }
}
