import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class SearchUser extends JFrame {
    private JPanel searchUserPanel;
    private JTable jtSearchedResult;
    private JButton jbReturnToMenu;
    private JButton jbSearchUser;
    private JLabel jlSearchUserCpf;
    private JFormattedTextField ftfSearchUserCpf;
    private JScrollPane jspSearchedResult;
    private JLabel lbSearchUserName;
    private JTextField tfSearchUserName;
    private JLabel jlUserResidencialNumber;
    private JFormattedTextField ftfSearchUserRecidencialNumber;
    private String userCpf, userName,userRecidencialNumber;
    
    
    public SearchUser() {
        JFrame searchUserFrame = new JFrame("Tela de Pesquisa de um Usuário");
        searchUserFrame.setContentPane(searchUserPanel);
        searchUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchUserFrame.pack();
        searchUserFrame.setVisible(true);
    
        returnToMenu();
        searchExistentUser();
        maskCpfField();
    }
    
    public void searchExistentUser() {
        jbSearchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    userCpf = ftfSearchUserCpf.getText();
                    userName = tfSearchUserName.getText();
                    userRecidencialNumber = ftfSearchUserRecidencialNumber.getText();
        
                    User oldUser = new User(userCpf, userName, userRecidencialNumber);
                    UserAction searchNewUser = new UserAction();
        
                    validateFormFields(oldUser);
                    if(oldUser.getUserCpf().equals(userCpf)) {
                        String[] searchedUser = searchNewUser.searchUser(userCpf);
    
                        jtSearchedResult.setModel(new AbstractTableModel() {
                            final String[] columnNames = {"Nome", "CPF", "Telefone Pessoal"};
                            final Object[][] data = {{searchedUser[0]},{searchedUser[1]},{searchedUser[2]}};
        
                            @Override
                            public int getColumnCount() {
                                return columnNames.length;
            
                            }
        
                            @Override
                            public int getRowCount() {
                                return data.length;
                            }
        
                            @Override
                            public String getColumnName(int col) {
                                return columnNames[col];
            
                            }
        
                            @Override
                            public Object getValueAt(int row, int col) {
                                return data[row][col];
                            }
        
                            @Override
                            public boolean isCellEditable(int row, int col) {
                                return false;
                            }
        
                            @Override
                            public void setValueAt(Object value, int row, int col) {
                                data[row][col] = value;
                                fireTableCellUpdated(row, col);
                            }
        
                        });
                        JOptionPane.showMessageDialog(searchUserPanel, "Usuário foi encontrado na base de dados!");
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(searchUserPanel, "Por favor, preencha os campos corretamente !");
                } finally {
                    clearFormFields();
                }
            }
        });
    }
    
    public void validateFormFields(User user) {
        if (userCpf.isEmpty() || userCpf.length() < 11) {
            JOptionPane.showMessageDialog(searchUserPanel, "Por favor, preencha os campos corretamente !");
        } else if(user.getUserCpf() == null) {
            JOptionPane.showMessageDialog(searchUserPanel, "O CPF indicado não existe!");
        }
    }
    
    public void maskCpfField(){
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            MaskFormatter recidencialNumberMask = new MaskFormatter("####-####");
    
            ftfSearchUserCpf.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
            ftfSearchUserRecidencialNumber.setFormatterFactory(new DefaultFormatterFactory(recidencialNumberMask));
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
        tfSearchUserName.setText(null);
        ftfSearchUserCpf.setText(null);
        ftfSearchUserRecidencialNumber.setText(null);
    }
}
