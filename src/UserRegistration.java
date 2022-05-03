import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
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
    }
    
    public void maskFields(){
        try {
            MaskFormatter recidencialNumberMask = new MaskFormatter("####-####");
            MaskFormatter numberMask = new MaskFormatter("(0##)#####-####");
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
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
    
    public static void main(String[] args) {
        UserRegistration myFrame = new UserRegistration("User Registration");
        myFrame.setVisible(true);
    }
}
