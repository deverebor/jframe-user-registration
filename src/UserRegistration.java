import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class UserRegistration extends JFrame {
    private JPanel mainPanel;
    private JTextField jtUserName;
    private JLabel jlUserName;
    private JComboBox<String> jcbStreetType;
    private JLabel jlStreetType;
    private JLabel jlStreet;
    private JTextField jtfStreet;
    private JLabel jlStreetNumber;
    private JTextField jtfStreetNumber;
    private JFormattedTextField jftfRecidencialNumber;
    private JLabel jlRecidencialNumber;
    private JLabel jlComercialNumber;
    private JFormattedTextField ftfComercialNumber;
    private JLabel jlPersonalNumber;
    private JFormattedTextField ftfPersonalNumber;
    private JLabel jlCPF;
    private JFormattedTextField ftfCPF;
    private JLabel jlRG;
    private JFormattedTextField ftfRG;
    private JButton jbCreateUser;
    private JButton jbUpdateUser;
    private JButton jbRemoveUser;
    private JButton jbSearchUser;
    
    private String userName, userStreet, userStreetNumber, userRecidencialNumber, userComercialNumber,
            userPersonalNumber, userCpf, userRg;
    
    public UserRegistration(String title) {
        super(title);
    
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        maskFields();
        createComboBox();
        createNewUser();
    }
    
    public void maskFields(){
        try {
            MaskFormatter recidencialNumberMask = new MaskFormatter("####-####");
            MaskFormatter numberMask = new MaskFormatter("(0##)9####-####");
            MaskFormatter cpfMask = new MaskFormatter("###.###.##-##");
            MaskFormatter rgMask = new MaskFormatter("##.###.###-#");
            
            jftfRecidencialNumber.setFormatterFactory(new DefaultFormatterFactory(recidencialNumberMask));
            ftfComercialNumber.setFormatterFactory(new DefaultFormatterFactory(numberMask));
            ftfPersonalNumber.setFormatterFactory(new DefaultFormatterFactory(numberMask));
            ftfCPF.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
            ftfRG.setFormatterFactory(new DefaultFormatterFactory(rgMask));
        } catch (ParseException error) {
            error.getMessage();
        }
        
    }
    
    public void createComboBox(){
        try {
        String[] streetTypes = {"Rua", "Avenida", "Alameda", "Praça", "Travessa"};
        jcbStreetType.setModel(new DefaultComboBoxModel<>(streetTypes));
        } catch (Exception error) {
            System.out.println("Não foi possível selecionar um logadouro");
        }
    }
    
    public void createNewUser() {
        jbCreateUser.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    userName = jtUserName.getText();
                    userStreet = jtfStreet.getText();
                    userStreetNumber = jtfStreetNumber.getText();
                    userRecidencialNumber = jftfRecidencialNumber.getText();
                    userComercialNumber = ftfComercialNumber.getText();
                    userPersonalNumber = ftfPersonalNumber.getText();
                    userCpf = ftfCPF.getText();
                    userRg = ftfRG.getText();
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(mainPanel, "Não foi possível criar o usuário");
                } finally {
                    clearFormFields();
                }
    
                validateFormFields();
            }
        });
    }
    
    public void validateFormFields() {
        if (userName.isEmpty() || userStreet.isEmpty() || userStreetNumber.isEmpty()
                || userRecidencialNumber.isEmpty() || userComercialNumber.isEmpty()
                || userPersonalNumber.isEmpty() || userCpf.isEmpty() || userRg.isEmpty()
        ) {
            JOptionPane.showMessageDialog(mainPanel, "Por favor, preencha todos os campos!");
        } else {
            User newUser = new User(userName, userStreet, userStreetNumber, userRecidencialNumber, userComercialNumber, userPersonalNumber, userCpf, userRg);
            UserActions createNewUser = new UserActions();
    
            createNewUser.createUser(newUser);
    
            JOptionPane.showMessageDialog(mainPanel, "Usuário criado com sucesso!");
        }
    }
    
    public void clearFormFields() {
        jtUserName.setText(null);
        jtfStreet.setText(null);
        jtfStreetNumber.setText(null);
        jftfRecidencialNumber.setText(null);
        ftfComercialNumber.setText(null);
        ftfPersonalNumber.setText(null);
        ftfCPF.setText(null);
        ftfRG.setText(null);
    }
    
    public static void main(String[] args) {
        UserRegistration myFrame = new UserRegistration("User Registration");
        myFrame.setVisible(true);
    }
}
