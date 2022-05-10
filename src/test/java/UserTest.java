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
        
        assertEquals("CPF inválido", userException.getMessage());
    }
    
    @Test
    public void shouldThrowUserExceptionWhenUserAndRecidecialCreate() {
        UserException newUserExceptionBothNull = assertThrows(UserException.class, () -> {
            User user = new User(null, null);
        });
        
        assertEquals("Nome e Telefone Recidencial inválidos", newUserExceptionBothNull.getMessage());
    
        UserException newUserExceptionNameNull = assertThrows(UserException.class, () -> {
            User user = new User(null, "123456789");
        });
        
        assertEquals("Nome e Telefone Recidencial inválidos", newUserExceptionNameNull.getMessage());
    
        UserException newUserExceptionRecNull = assertThrows(UserException.class, () -> {
            User user = new User("Adeobaldo", null);
        });
    
        assertEquals("Nome e Telefone Recidencial inválidos", newUserExceptionRecNull.getMessage());
    
        UserException newUserExceptionNameEmpty = assertThrows(UserException.class, () -> {
            User user = new User("", "11111111");
        });
    
        assertEquals("Nome ou senha não podem ser vazios", newUserExceptionNameEmpty.getMessage());
    
        UserException newUserExceptionRecEmpty = assertThrows(UserException.class, () -> {
            User user = new User("Adeobaldo", "");
        });
    
        assertEquals("Nome ou senha não podem ser vazios", newUserExceptionRecEmpty.getMessage());
    }
    
    @Test
    public void shouldThrowUserExceptionWhenCreateCpfUserRecidencial() {
        UserException newUserExceptionCPFNull = assertThrows(UserException.class, () -> {
            User user = new User(null, "Adeobaldo", "123456789");
        });
        
        assertEquals("CPF inválido", newUserExceptionCPFNull.getMessage());
        
        UserException newUserExceptionNameReciEmpty = assertThrows(UserException.class, () -> {
            User user = new User("1121212", "", "");
        });
        
        assertEquals("Nome ou senha não podem ser vazios", newUserExceptionNameReciEmpty.getMessage());
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
        
        assertEquals("Não podem haver campos vazios", newUserExceptionAllNull.getMessage());
    
        UserException newUserExceptionUserNameCpfRGEmpty = assertThrows(UserException.class, () -> {
            User user = new User(
                    "", "street", "12",
                    "111111111", "1111111",
                    "11111111", "", ""
            );
        });
    
        assertEquals("Não podem haver campos vazios", newUserExceptionAllNull.getMessage());
    }
}
