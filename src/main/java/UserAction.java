import Utils.UserActionException;

public class UserAction {
    private final User[] users;
    private final int maxNumberOfUsers = 25;
    private int pointer = 0;
    
    public UserAction() {
        users = new User[maxNumberOfUsers];
    }
    
    public void createUser(User user) throws UserActionException {
        if(pointer < maxNumberOfUsers){
            try {
                users[pointer] = user;
                pointer++;
                
            } catch (Exception error) {
                throw new UserActionException("Can not create user");
            }
        } else {
            throw new UserActionException("Maximum number of users reached!");
        }
    }
    
    public void removeUser(User user) throws UserActionException {
        if(pointer < 0){
            throw new UserActionException("You can not remove users, because there are no users");
        } else if(user == null){
            throw new UserActionException("The user you tries to remove does not exists");
        } else {
            try {
                for(int i = 0; i < pointer; i++){
                    if(user.equals(users[i])){
                        users[i] = null;
                    }
                }
            } catch (Exception error) {
                throw new UserActionException("Can not remove user");
            }
        }
    }
    
    public void updateUser(User user) throws UserActionException {
        if(pointer < 0){
            throw new UserActionException("There no users to update");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.equals(users[i])){
                    users[i] = user;
                    System.out.println("User updated successfully");
                } else {
                    throw new UserActionException("The user you tries to update does not exists");
                }
            }
        } catch (Exception error) {
            throw new UserActionException("Error trying to update an user" + error.getMessage());
        }
        
    }
    
    public void searchUser(User user) throws UserActionException {
        if(pointer <= 0){
            throw new UserActionException("There are no users to search");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.getUserCpf().equals(users[i].getUserCpf())){
                    user = users[i];
                }
            }
        } catch (Exception error) {
            throw new UserActionException("The user you trie to search does not exists " + error.getMessage());
        } finally {
            System.out.println("User found successfully");
        }
    }
}
