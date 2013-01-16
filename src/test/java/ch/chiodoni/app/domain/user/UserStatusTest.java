package ch.chiodoni.app.domain.user;

import ch.chiodoni.app.domain.user.entity.IllegalUserStatusTransition;
import ch.chiodoni.app.domain.user.entity.UserStatus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/13/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserStatusTest {

    @Test
    public void testEmailVerificationStateTransition() {
        UserStatus status = UserStatus.UNVERIFIED;
        status = status.emailVerified();
        Assert.assertEquals(UserStatus.EMAIL, status);
    }

    @Test
    public void testCancelEmailVerificationStateTransition() {
        UserStatus status = UserStatus.EMAIL;
        status = status.unverified();
        Assert.assertEquals(UserStatus.UNVERIFIED, status);
    }

    @Test
    public void testPhoneVerificationStateTransition() {
        UserStatus status = UserStatus.EMAIL;
        status = status.phoneVerified();
        Assert.assertEquals(UserStatus.PHONE, status);
    }

    @Test(expected = IllegalUserStatusTransition.class)
    public void testIllegalStateTransition() {
        UserStatus status = UserStatus.UNVERIFIED;
        status = status.phoneVerified();
        Assert.assertTrue(false);
    }
}
