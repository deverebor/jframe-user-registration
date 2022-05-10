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
    
    public void updateUser(String userName, String userRecidencialNumber) throws UserActionException {
        if(pointer < 0){
            throw new UserActionException("There no users to update");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(
                        userName.equals(users[i].getUserName())
                        && userRecidencialNumber.equals(users[i].getUserRecidencialNumber())
                ){
                    throw new UserActionException("The new user data is the same as the old one");
                } else if(userName.length() == 0 || userRecidencialNumber.length() == 0){
                    throw new UserActionException("The new user data is empty");
                }
                else {
                    users[i].setUserName(userName);
                    users[i].setUserRecidencialNumber(userRecidencialNumber);
                }
            }
        } catch (Exception error) {
            throw new UserActionException("Can not update user");
        }
        
    }
    
    public String[] searchUser(String userCpf) throws UserActionException {
        if (pointer <= 0) {
            throw new UserActionException("There are no users to search");
        }
        String[] searchedUsers = new String[0];
        for (int i = 0; i < pointer; i++) {
            if (userCpf.equals(users[i].getUserCpf())) {
                searchedUsers = new String[]{
                        users[i].getUserName(),
                        users[i].getUserCpf(),
                        users[i].getUserPersonalNumber()
                };
            }
        }
    
        return searchedUsers;
    }
}
