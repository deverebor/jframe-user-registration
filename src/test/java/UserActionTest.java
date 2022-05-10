import Utils.UserActionException;
import Utils.UserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserActionTest {
    
    @Test
    public void shouldUserActionCreateUser() throws UserException, UserActionException {
        User user = new User(
                "Adeobaldo", "street", "12",
                "111111111", "1111111",
                "11111111", "1111111111", "11111111"
        );
        UserAction userAction = new UserAction();
        userAction.createUser(user);
    
        assertEquals("Adeobaldo", user.getUserName());
        
        int numberOfUsers = 26;
        
        User newUsers = new User(
                "Adeobaldo", "street", "12",
                "111111111", "1111111",
                "11111111", "1111111111", "11111111"
        );
        
        UserActionException userActionExceptionCreateUser = assertThrows(UserActionException.class, () -> {
            for(int i = 0; i < numberOfUsers; i++) {
                userAction.createUser(newUsers);
            }
        });
        
        assertEquals("Maximum number of users reached!", userActionExceptionCreateUser.getMessage());
        
    }
    
    @Test
    public void shouldUserActionRemoveUser() throws UserException, UserActionException {
        User user = new User(
                "Adeobaldo", "street", "12",
                "111111111", "1111111",
                "11111111", "1111111111", "11111111"
        );
        UserAction userAction = new UserAction();
        
        userAction.createUser(user);
        
        userAction.removeUser(user);
        
        assertFalse(false, user.getUserName());
        
        UserActionException userActionExceptionRemoveUser = assertThrows(UserActionException.class, () -> {
            userAction.removeUser(null);
        });
        
        assertEquals("The user you tries to remove does not exists", userActionExceptionRemoveUser.getMessage());
    }
    
    @Test
    public void shouldUserActionUpdateUser() throws UserException, UserActionException {
        User user = new User(
                "Adeobaldo", "street", "12",
                "111111111", "1111111",
                "11111111", "1111111111", "11111111"
        );
        UserAction userAction = new UserAction();
        
        userAction.createUser(user);
        
        userAction.updateUser("Josiscleison", "111-111");
        
        assertEquals("Josiscleison", user.getUserName());
        assertEquals("111-111", user.getUserRecidencialNumber());
        
        UserActionException userActionExceptionUpdateUser = assertThrows(UserActionException.class, () -> {
            userAction.updateUser(null, null);
        });
        
        assertEquals("Can not update user", userActionExceptionUpdateUser.getMessage());
        
        UserActionException userActionExceptionUpdateUser2 = assertThrows(UserActionException.class, () -> {
            User user2 = new User(
                    "Adeobaldo", "street", "12",
                    "111111111", "1111111",
                    "11111111", "1111111111", "11111111"
            );
            
            userAction.createUser(user2);
            userAction.updateUser("", "");
        });
        
        assertEquals("Can not update user", userActionExceptionUpdateUser2.getMessage());
    
        UserActionException userActionExceptionUpdateUser3 = assertThrows(UserActionException.class, () -> {
            userAction.updateUser("Adeobaldo", "111111111");
        });
    
        assertEquals("Can not update user", userActionExceptionUpdateUser3.getMessage());
    }
}
