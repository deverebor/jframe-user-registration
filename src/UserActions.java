import Utils.UserActionsException;

public class UserActions {
    private final User[] users;
    private final int numberOfUsers = 25;
    private int pointer = 0;
    
    public UserActions() {
        users = new User[numberOfUsers];
    }
    
    public void createUser(User user) throws UserActionsException {
        if(pointer <= numberOfUsers){
            try {
                users[pointer] = user;
                this.pointer++;
    
                System.out.println("User created successfully");
            } catch (Exception error) {
                throw new UserActionsException("Can not create user: " + error.getMessage());
            }
        }
    }
    
    public void removeUser(User user) throws UserActionsException {
        if(pointer < 0){
            throw new UserActionsException("You can not remove users, because there are no users");
        } else {
            try {
                for(int i = 0; i < pointer; i++){
                    if(user.equals(users[i])){
                        users[i] = null;
                    }
                }
            } catch (Exception error) {
                throw new UserActionsException("The user you tries to remove docent exists " + error.getMessage());
            }
    
            System.out.println("User removed successfully");
        }
    }
    
    public void updateUser(User user) throws UserActionsException{
        if(pointer < 0){
            throw new UserActionsException("There no users to update");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.equals(users[i])){
                    users[i] = user;
                    System.out.println("User updated successfully");
                } else {
                    throw new UserActionsException("The user you tries to update does not exists");
                }
            }
        } catch (Exception error) {
            throw new UserActionsException("Error trying to update an user" + error.getMessage());
        }
        
    }
    
    public void searchUser(User user) throws UserActionsException{
        if(pointer <= 0){
            throw new UserActionsException("There are no users to search");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.getUserCpf().equals(users[i].getUserCpf())){
                    user = users[i];
                }
            }
        } catch (Exception error) {
            throw new UserActionsException("The user you trie to search does not exists " + error.getMessage());
        } finally {
            System.out.println("User found successfully");
        }
    }
}
