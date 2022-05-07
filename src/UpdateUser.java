import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUser extends JFrame {
    private JPanel updateUserPanel;
    private JButton jbReturnButton;
    private JButton jbChangeUser;
    private JTextField jtfUserName;
    private JLabel jlUserName;
    private JLabel jlNewUserName;
    private JTextField jtfNewUserName;
    private JFormattedTextField ftfUserResidencialNumber;
    private JLabel jlUserResidencialNumber;
    private JFormattedTextField ftfNewUserResidencialNumber;
    private JLabel jlNewUserResidencialNumber;
    
    private String oldUserName, newUserName, oldResidencialNumber, newResidencialNumber;
    
    public UpdateUser() {
        JFrame updataUserFrame = new JFrame("Tela de Atualização de Usuário");
        updataUserFrame.setContentPane(updateUserPanel);
        updataUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updataUserFrame.pack();
        updataUserFrame.setVisible(true);
        returnToMenu();
        changeExistentUser();
    }
    
    public void returnToMenu() {
        jbReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserRegistration mainFrame = new UserRegistration();
                mainFrame.openUserRegistrationWindow();
            }
        });
    }
    
    public void changeExistentUser() {
        jbChangeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User oldUser = new User();
                
                 oldUserName = jtfUserName.getText();
                 newUserName = jtfNewUserName.getText();
                 
                 oldResidencialNumber = ftfUserResidencialNumber.getText();
                 newResidencialNumber = ftfNewUserResidencialNumber.getText();
    
                validateFormFields(oldUser);
                
                User newUser = new User(newUserName, newResidencialNumber);
                UserActions createNewUser = new UserActions();
    
                createNewUser.updateUser(newUser);
    
                JOptionPane.showMessageDialog(updateUserPanel, "Informações do usuário alteradas com sucesso!");
            }
        });
    }
    
    public void validateFormFields(User user) {
        if (oldUserName.isEmpty() || newUserName.isEmpty() && oldResidencialNumber.isEmpty() || newResidencialNumber.isEmpty()) {
            JOptionPane.showMessageDialog(updateUserPanel, "Por favor, preencha todos os campos!");
        } else if (oldUserName.equals(user.getUserName()) && newUserName.equals(user.getUserName())
                || oldResidencialNumber.equals(user.getUserRecidencialNumber()) && newResidencialNumber.equals(user.getUserRecidencialNumber())
        ) {
            JOptionPane.showMessageDialog(updateUserPanel, "O nome do usuário não pode ser igual ao antigo!");
        }
    }
    
}
