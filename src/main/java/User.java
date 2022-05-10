import Utils.UserException;

public class User {
    private String userName;
    private String userStreet;
    private String userStreetNumber;
    private String userRecidencialNumber;
    private String userComercialNumber;
    private String userPersonalNumber;
    private String userCpf;
    private String userRg;
    
    public User() {}
    
    public User(String userCpf) throws UserException {
        if(userCpf.length() == 14) {
            this.setUserCpf(userCpf);
        } else {
           throw new UserException("CPF inválido");
        }
    }
    
    public User(String newUserName, String newRecidencialNumber) throws UserException{
        
        if(newUserName == null || newRecidencialNumber == null) {
            throw new UserException("Nome e Telefone Recidencial inválidos");
            
        } else if(newUserName.length() == 0 || newRecidencialNumber.length() == 0) {
            throw new UserException("Nome ou senha não podem ser vazios");
        } else {
            this.setUserName(newUserName);
            this.setUserRecidencialNumber(newRecidencialNumber);
    
            System.out.println("Usuário criado com sucesso");
        }
    }
    
    public User(String userCpf, String userName, String userRecidencialNumber) throws UserException {
        if(userCpf == null) {
            throw new UserException("CPF inválido");
        } else if(userName.length() == 0 || userRecidencialNumber.length() == 0) {
            throw new UserException("Nome ou senha não podem ser vazios");
        } else {
            this.setUserCpf(userCpf);
            this.setUserName(userName);
            this.setUserRecidencialNumber(userRecidencialNumber);
        }
    }
    
    public User(String userName, String userStreet, String userStreetNumber,
                 String userRecidencialNumber, String userComercialNumber,
                 String userPersonalNumber, String userCpf, String userRg
    ) throws UserException {
        if(
                userName == null || userStreet == null || userStreetNumber == null
                        || userRecidencialNumber == null || userComercialNumber == null
                        || userPersonalNumber == null || userCpf == null || userRg == null
        ) {
            throw new UserException("Não podem haver campos vazios");
        } else if(userName.length() == 0 || userCpf.length() == 0 || userRg.length() == 0) {
            throw new UserException("Não podem haver campos vazios");
        } else {
            this.setUserName(userName);
            this.setUserStreet(userStreet);
            this.setUserStreetNumber(userStreetNumber);
            this.setUserRecidencialNumber(userRecidencialNumber);
            this.setUserComercialNumber(userComercialNumber);
            this.setUserPersonalNumber(userPersonalNumber);
            this.setUserCpf(userCpf);
            this.setUserRg(userRg);
        }
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserStreet() {
        return userStreet;
    }
    
    public void setUserStreet(String userStreet) {
        this.userStreet = userStreet;
    }
    
    public String getUserStreetNumber() {
        return userStreetNumber;
    }
    
    public void setUserStreetNumber(String userStreetNumber) {
        this.userStreetNumber = userStreetNumber;
    }
    
    
    public String getUserComercialNumber() {
        return userComercialNumber;
    }
    
    public void setUserComercialNumber(String userComercialNumber) {
        this.userComercialNumber = userComercialNumber;
    }
    
    public String getUserPersonalNumber() {
        return userPersonalNumber;
    }
    
    public void setUserPersonalNumber(String userPersonalNumber) {
        this.userPersonalNumber = userPersonalNumber;
    }
    
    public String getUserCpf() {
        return userCpf;
    }
    
    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }
    
    public String getUserRg() {
        return userRg;
    }
    
    public void setUserRg(String userRg) {
        this.userRg = userRg;
    }
    
    public String getUserRecidencialNumber() {
        return userRecidencialNumber;
    }
    
    public void setUserRecidencialNumber(String userRecidencialNumber) {
        this.userRecidencialNumber = userRecidencialNumber;
    }
}
