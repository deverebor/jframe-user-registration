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
        if(users == null || pointer < 0){
            System.out.println("[ERROR] No users to remove");
        } else {
            for(int i = 0; i < pointer; i++){
                users[i] = null;
            }
    
            System.out.println("User removed successfully");
        }
    }
    
    public void updateUser(User user){
        if(users == null || pointer < 0){
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
        if(users == null || pointer < 0){
            System.out.println("[ERROR] No users to search");
        }
        try {
            for(int i = 0; i < pointer; i++){
                users[i].getUserName();
                users[i].getUserStreet();
                users[i].getUserStreetNumber();
                users[i].getUserComercialNumber();
                users[i].getUserRecidencialNumber();
                users[i].getUserPersonalNumber();
                users[i].getUserCpf();
                users[i].getUserRg();
            }
        } catch (Exception error) {
            System.out.println("[ERROR] " + error.getMessage());
        }
    }
}
