import javax.swing.*;

public class UserRegistration extends JFrame {
    private JPanel mainPanel;
    private JTextField jtUserName;
    private JLabel jlUserName;
    private JComboBox jcbStreetType;
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
    
    public UserRegistration(String title) {
        super(title);
    
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    public static void main(String[] args) {
        UserRegistration myFrame = new UserRegistration("User Registration");
        myFrame.setVisible(true);
    }
}
