import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class UserRegistration extends JFrame {
    private JPanel mainContent;
    private JLabel lbName;
    private JTextField tfName;
    private JLabel lbTypeOfStreet;
    private JTextField tfStreet;
    private JLabel lbStreet;
    private JLabel lbStreetNumber;
    private JTextField tfStreetNumber;
    private JLabel lbResidencialNumber;
    private JLabel lbComercialNumber;
    private JLabel lbPersonalNumber;
    private JLabel lbCPF;
    private JLabel lbRG;
    private JComboBox<String> cbTypeOfStreets;
    private JFormattedTextField ftfResidencialNumber = null;
    private JFormattedTextField ftfComercialNumber = null;
    private JFormattedTextField ftfPersonalNumber = null;
    private JFormattedTextField ftfCPF = null;
    private JFormattedTextField ftfRG = null;
    
    public static void main(String[] args) {
        UserRegistration myFrame = new UserRegistration();
        myFrame.createUIComponents();
    }
    
    public UserRegistration() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        createUIComponents();
    }
    
    public void createUIComponents()  {
        try {
            MaskFormatter maskResidencialNumber = new MaskFormatter("(##) ####-####");
             maskResidencialNumber.install(ftfResidencialNumber);
    
            MaskFormatter maskComercialNumber = new MaskFormatter("(##) ####-####");
            maskComercialNumber.install(ftfComercialNumber);
    
            MaskFormatter maskPersonalNumber = new MaskFormatter("(##) ####-####");
            maskPersonalNumber.install(ftfPersonalNumber);
    
            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.install(ftfCPF);
    
            MaskFormatter maskRG = new MaskFormatter("##.###.###-#");
            maskRG.install(ftfRG);
        } catch (ParseException error) {
           JOptionPane.showMessageDialog(null, "Erro ao criar máscara", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
