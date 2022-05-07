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
    
    public UserRegistration(String title) {
        super(title);
    
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        maskFields();
        createComboBox();
        createUser();
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
    
    public void createUser() {
        jbCreateUser.addActionListener(new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(jtUserName.getText().isEmpty() || jtfStreet.getText().isEmpty() || jtfStreetNumber.getText().isEmpty()
                        || jftfRecidencialNumber.getText().isEmpty() || ftfComercialNumber.getText().isEmpty()
                        || ftfPersonalNumber.getText().isEmpty() || ftfCPF.getText().isEmpty() || ftfRG.getText().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(mainPanel, "Por favor, preencha todos os campos!");
                } else {
                    try {
                        String userName = jtUserName.getText();
                        String userStreet = jtfStreet.getText();
                        String userStreetNumber = jtfStreetNumber.getText();
                        String userRecidencialNumber = jftfRecidencialNumber.getText();
                        String userComercialNumber = ftfComercialNumber.getText();
                        String userPersonalNumber = ftfPersonalNumber.getText();
                        String userCpf = ftfCPF.getText();
                        String userRg = ftfRG.getText();
        
                        Users newUser = new Users(userName, userStreet, userStreetNumber, userRecidencialNumber, userComercialNumber, userPersonalNumber, userCpf, userRg);
                        CreateNewUser createNewUser = new CreateNewUser();
                        
                        createNewUser.createUser(newUser);
                        
                        JOptionPane.showMessageDialog(mainPanel, "Usuário criado com sucesso!");
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(mainPanel, "Não foi possível criar um usuário!");
                    }
                }
            }
        });
    }
    
    public static void main(String[] args) {
        UserRegistration myFrame = new UserRegistration("User Registration");
        myFrame.setVisible(true);
    }
}
