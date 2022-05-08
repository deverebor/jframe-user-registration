import Utils.UserActionsException;
import Utils.UserException;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
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
    private JButton jbQuitApp;
    
    private String userName, userStreet, userStreetNumber, userRecidencialNumber, userComercialNumber,
            userPersonalNumber, userCpf, userRg;
    
    public UserRegistration() {
        this.setTitle("User Registration");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        maskFields();
        createComboBox();
        createNewUser();
        updateExistentUser();
        removeExistentUser();
        searchExistentUser();
        quitApp();
    }
    
    public void maskFields(){
        try {
            MaskFormatter recidencialNumberMask = new MaskFormatter("####-####");
            MaskFormatter numberMask = new MaskFormatter("(0##)9####-####");
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
    
                try {
                    validateFormFields();
                } catch (UserActionsException | UserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    
    public void validateFormFields() throws UserActionsException, UserException {
        if (userName.isEmpty() || userStreet.isEmpty() || userStreetNumber.isEmpty()
                || userRecidencialNumber.isEmpty() || userComercialNumber.isEmpty()
                || userPersonalNumber.isEmpty() || userCpf.isEmpty() || userRg.isEmpty()
        ) {
            JOptionPane.showMessageDialog(mainPanel, "Por favor, preencha todos os campos!");
        } else {
            User newUser = new User(userName, userStreet, userStreetNumber, userRecidencialNumber, userComercialNumber, userPersonalNumber, userCpf, userRg);
            UserActions createNewUser = new UserActions();
    
            createNewUser.createUser(newUser);
    
            JOptionPane.showMessageDialog(mainPanel,
                    "O usuário: " + newUser.getUserName() +" foi criado(a) com " + "sucesso!"
            );
        }
    }
    
    public void updateExistentUser() {
        jbUpdateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateUser updateNewUser = new UpdateUser();
                closeWindow();
            }
        });
    }
    
    public void removeExistentUser() {
        jbRemoveUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RemoveUser removeUser = new RemoveUser();
                closeWindow();
            }
        });
    }
    
    public void searchExistentUser() {
        jbSearchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SearchUser searchUser = new SearchUser();
                closeWindow();
            }
        });
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
    
    public void closeWindow() {
        WindowEvent windowClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
        dispose();
    }
    
    public void quitApp() {
        jbQuitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
