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
    
    public User(String userCpf, String userName, String userRecidencialNumber) throws UserException {
        if(userCpf.length() == 14) {
            this.setUserCpf(userCpf);
            this.setUserName(userName);
            this.setUserRecidencialNumber(userRecidencialNumber);
        } else {
            throw new UserException("CPF inválido");
        }
    }
    
    public User(String newUserName, String newRecidencialNumber) throws UserException{
        if(newUserName.length() > 0 && newRecidencialNumber.length() > 0) {
            this.setUserName(newUserName);
            this.setUserRecidencialNumber(newRecidencialNumber);
        } else {
            throw new UserException("Nome e Telefone Recidencial inválidos");
        }
    }
    
    public User(String userName, String userStreet, String userStreetNumber,
                 String userRecidencialNumber, String userComercialNumber,
                 String userPersonalNumber, String userCpf, String userRg
    ) throws UserException {
        try {
            this.setUserName(userName);
            this.setUserStreet(userStreet);
            this.setUserStreetNumber(userStreetNumber);
            this.setUserRecidencialNumber(userRecidencialNumber);
            this.setUserComercialNumber(userComercialNumber);
            this.setUserPersonalNumber(userPersonalNumber);
            this.setUserCpf(userCpf);
            this.setUserRg(userRg);
        } catch (Exception error) {
            throw new UserException("Erro ao criar um usuário");
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
