public class UserActions {
    private final User[] users;
    private final int numberOfUsers = 25;
    private int pointer = 0;
    
    public UserActions() {
        users = new User[numberOfUsers];
    }
    
    public void createUser(User user){
        if(pointer <= numberOfUsers){
            try {
                users[pointer] = user;
                this.pointer++;
    
                System.out.println("User created successfully");
            } catch (Exception error) {
                System.out.println("[ERROR] " + error.getMessage());
            }
        }
    }
    
    public void removeUser(User user){
        if(pointer < 0){
            System.out.println("[ERROR]: No users to remove");
        } else {
            try {
                for(int i = 0; i < pointer; i++){
                    if(user.equals(users[i])){
                        users[i] = null;
                    }
                }
            } catch (Exception error) {
                System.out.println("[ERROR] " + error.getMessage());
            }
    
            System.out.println("User removed successfully");
        }
    }
    
    public void updateUser(User user){
        if(pointer < 0){
            System.out.println("[ERROR] No users to update");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.equals(users[i])){
                    users[i] = user;
                    System.out.println("User updated successfully");
                } else {
                    System.out.println("[ERROR] User not found");
                }
            }
        } catch (Exception error) {
            System.out.println("[ERROR] " + error.getMessage());
        }
        
    }
    
    public void searchUser(User user){
        if(pointer <= 0){
            System.out.println("[ERROR] No users to search");
        }
        try {
            for(int i = 0; i < pointer; i++){
                if(user.getUserCpf().equals(users[i].getUserCpf())){
                    user = users[i];
                }
            }
        } catch (Exception error) {
            System.out.println("[ERROR] " + error.getMessage());
        } finally {
            System.out.println("User found successfully");
        }
    }
}
