package ch.chiodoni.app.domain.user;

import ch.chiodoni.app.domain.user.entity.User;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/13/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {

    @Test
    public void testUnknownBirthdayUser() {
        User user = new User();
        Assert.assertFalse(user.isUserTooOld());
    }

    @Test
    public void testYoungUser() {
        User user = new User();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1*(User.OLDEST_USER-1));
        user.setBirthday(calendar.getTime());
        Assert.assertFalse(user.isUserTooOld());
    }

    @Test
    public void testOldUser() {
        User user = new User();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1*(User.OLDEST_USER+1));
        user.setBirthday(calendar.getTime());
        Assert.assertTrue(user.isUserTooOld());
    }
}
