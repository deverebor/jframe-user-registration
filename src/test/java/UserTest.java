import Utils.UserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    
    @Test
    public void shouldCreateUserCorrectly() throws UserException {
        // User with CPF only
        
        User userCpfTest = new User("111.111.111-11");
        
        assertEquals("111.111.111-11", userCpfTest.getUserCpf());
    
        // User with newCPF, newRecidencialNumber
        User userCpfNameTest = new User("Adeobaldo", "123456789");
        
        assertEquals("Adeobaldo", userCpfNameTest.getUserName());
        assertEquals("123456789", userCpfNameTest.getUserRecidencialNumber());
        
        // User with CPF, name and recidencial number
        
        User userCpfNameRecTest = new User("111.111.111-11", "Adeobaldo", "123456789");
        
        assertEquals("111.111.111-11", userCpfNameRecTest.getUserCpf());
        assertEquals("Adeobaldo", userCpfNameRecTest.getUserName());
        assertEquals("123456789", userCpfNameRecTest.getUserRecidencialNumber());
        
        // Complete User
        
        User userCompleteTest = new User(
                "Adeobaldo", "Rua", "123", "1111111", "11111111", "123456789", "111.111.111-11", "111.111.-11"
        );
        
        assertEquals("111.111.111-11", userCompleteTest.getUserCpf());
        assertEquals("Adeobaldo", userCompleteTest.getUserName());
        assertEquals("1111111", userCompleteTest.getUserRecidencialNumber());
        assertEquals("123456789", userCompleteTest.getUserPersonalNumber());
        assertEquals("11111111", userCompleteTest.getUserComercialNumber());
        assertEquals("123", userCompleteTest.getUserStreetNumber());
        assertEquals("Rua", userCompleteTest.getUserStreet());
        assertEquals("111.111.-11", userCompleteTest.getUserRg());
        
    }
    
    @Test
    public void shouldThrowUserExceptionWhenCPFIsBigger() throws UserException {
        
        UserException userException = assertThrows(UserException.class, () -> {
            User user = new User("111.111.111-11-111");
        });
        
        assertEquals("Invalid CPF", userException.getMessage());
    }
    
    @Test
    public void shouldThrowUserExceptionWhenUserAndRecidecialCreate() {
        UserException newUserExceptionBothNull = assertThrows(UserException.class, () -> {
            User user = new User(null, null);
        });
        
        assertEquals("Name and recidencial number cannot be null", newUserExceptionBothNull.getMessage());
    
        UserException newUserExceptionNameNull = assertThrows(UserException.class, () -> {
            User user = new User(null, "123456789");
        });
        
        assertEquals("Name and recidencial number cannot be null", newUserExceptionNameNull.getMessage());
    
        UserException newUserExceptionRecNull = assertThrows(UserException.class, () -> {
            User user = new User("Adeobaldo", null);
        });
    
        assertEquals("Name and recidencial number cannot be null", newUserExceptionRecNull.getMessage());
    
        UserException newUserExceptionNameEmpty = assertThrows(UserException.class, () -> {
            User user = new User("", "11111111");
        });
    
        assertEquals("Name or recidencial number cannot be empty", newUserExceptionNameEmpty.getMessage());
    
        UserException newUserExceptionRecEmpty = assertThrows(UserException.class, () -> {
            User user = new User("Adeobaldo", "");
        });
    
        assertEquals("Name or recidencial number cannot be empty", newUserExceptionRecEmpty.getMessage());
    }
    
    @Test
    public void shouldThrowUserExceptionWhenCreateCpfUserRecidencial() {
        UserException newUserExceptionCPFNull = assertThrows(UserException.class, () -> {
            User user = new User(null, "Adeobaldo", "123456789");
        });
        
        assertEquals("Invalid CPF", newUserExceptionCPFNull.getMessage());
        
        UserException newUserExceptionNameReciEmpty = assertThrows(UserException.class, () -> {
            User user = new User("1121212", "", "");
        });
        
        assertEquals("Name or recidencial number cannot be empty", newUserExceptionNameReciEmpty.getMessage());
    }
    
    @Test
    public void shouldThrowUserExceptionWhenCreateNewUser() {
        UserException newUserExceptionAllNull = assertThrows(UserException.class, () -> {
            User user = new User(
                    null, null, null,
                    null, null,
                    null, null, null
            );
        });
        
        assertEquals("Can not create with empty fileds", newUserExceptionAllNull.getMessage());
    
        UserException newUserExceptionUserNameCpfRGEmpty = assertThrows(UserException.class, () -> {
            User user = new User(
                    "", "street", "12",
                    "111111111", "1111111",
                    "11111111", "", ""
            );
        });
    
        assertEquals("Can not create with empty fileds", newUserExceptionAllNull.getMessage());
    }
}
