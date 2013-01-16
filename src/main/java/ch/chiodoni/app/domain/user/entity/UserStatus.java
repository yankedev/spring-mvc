package ch.chiodoni.app.domain.user.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 21.11.12
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
public enum UserStatus implements Serializable {

    /**
     * Value in state machine: 'Unverified'.
     */
    UNVERIFIED(0) {
        @Override
        public UserStatus emailVerified() {
            return EMAIL;
        }
    },

    /**
     * Value in state machine: 'Verified'.
     */
    EMAIL(1) {
        @Override
        public UserStatus unverified() {
            return UNVERIFIED;
        }

        @Override
        public UserStatus phoneVerified() {
            return PHONE;
        }
    },


    /**
     * Value in state machine: 'Verified'.
     */
    PHONE(2) {
        @Override
        public UserStatus emailVerified() {
            return EMAIL;
        }

        @Override
        public UserStatus unverified() {
            return UNVERIFIED;
        }
    };

    private int value;

    private UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static List<UserStatus> getAllStatuses() {
        return Arrays.asList(values());
    }

    private UserStatus illegalTransition() {
        throw new IllegalUserStatusTransition(this);
    }

    public UserStatus unverified() {
        illegalTransition();
        return this;
    }

    public UserStatus emailVerified() {
        illegalTransition();
        return this;
    }

    public UserStatus phoneVerified() {
        illegalTransition();
        return this;
    }

}
