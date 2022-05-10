import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;

public class RemoveUser extends JFrame {
    
    private JPanel removeUserPanel;
    private JFormattedTextField ftfOlderUserCPF;
    private JLabel jlOldUserCPF;
    private JButton jbRemoveUser;
    private JButton jbReturnToMenu;
    
    private String userCpf;
    
    public RemoveUser() {
        JFrame removeUserFrame = new JFrame("Tela de Remoção de um Usuário");
        removeUserFrame.setContentPane(removeUserPanel);
        removeUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removeUserFrame.pack();
        removeUserFrame.setVisible(true);
    
        maskCpfField();
        returnToMenu();
        removeExistentUser();
    }
    
    public void removeExistentUser() {
        jbRemoveUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    userCpf = ftfOlderUserCPF.getText();
    
                    User oldUser = new User(userCpf);
                    UserAction removeUser = new UserAction();
    
                    validateFormFields(oldUser);
                    if(oldUser.getUserCpf().equals(userCpf)) {
                        removeUser.removeUser(oldUser);
                        JOptionPane.showMessageDialog(removeUserPanel, "Usuário removido com sucesso!");
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(removeUserPanel, "Por favor, preencha os campos corretamente !");
                } finally {
                    clearFormFields();
                }
            }
        });
    }
    
    public void validateFormFields(User user) {
        if (userCpf.isEmpty() || userCpf.length() < 11) {
            JOptionPane.showMessageDialog(removeUserPanel, "Por favor, preencha os campos corretamente !");
        } else if(user.getUserCpf() == null) {
            JOptionPane.showMessageDialog(removeUserPanel, "O CPF indicado não existe!");
        }
    }
    
    public void maskCpfField(){
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
    
            ftfOlderUserCPF.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
        } catch (ParseException error) {
            error.getMessage();
        }
        
    }
    
    public void closeWindow() {
        WindowEvent windowClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
        dispose();
        UserRegistration mainFrame = new UserRegistration();
    }
    
    public void returnToMenu() {
        jbReturnToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                closeWindow();
            }
        });
    }
    
    public void clearFormFields() {
        ftfOlderUserCPF.setText(null);
    }
}
