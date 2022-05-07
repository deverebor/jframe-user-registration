import Utils.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class UpdateUser extends JFrame {
    private JPanel updataUserPanel;
    private JButton jbReturnButton;
    private JButton jbChangeUser;
    
    public UpdateUser() {
        JFrame updataUserFrame = new JFrame("Tela de Atualização de Usuário");
        updataUserFrame.setContentPane(updataUserPanel);
        updataUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updataUserFrame.pack();
        updataUserFrame.setVisible(true);
        returnToMenu();
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
}
