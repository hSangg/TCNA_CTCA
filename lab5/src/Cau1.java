import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Cau1 extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private Connection connection;

    public Cau1() {
        connectToDatabase();
        setTitle("Sign-In Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JLabel confirmPasswordLabel = new JLabel("Confirm");

        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        confirmPasswordField = new JPasswordField(10);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        formPanel.add(usernameLabel, gbc);
        gbc.gridx++;
        formPanel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(passwordLabel, gbc);
        gbc.gridx++;
        formPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(confirmPasswordLabel, gbc);
        gbc.gridx++;
        formPanel.add(confirmPasswordField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);
        buttonPanel.add(cancelButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean signInSuccessful = checkCredentials(username, password);

                if (signInSuccessful) {
                    JOptionPane.showMessageDialog(Cau1.this, "Đăng nhập thành công");
                } else {
                    JOptionPane.showMessageDialog(Cau1.this, "Đăng nhập không thành công. Vui lòng nhập lại");
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword)) {
                    boolean signUpSuccessful = saveUser(username, password);

                    if (signUpSuccessful) {
                        JOptionPane.showMessageDialog(Cau1.this, "Bạn đã đăng ký tài khoản thành công");
                    } else {
                        JOptionPane.showMessageDialog(Cau1.this, "Lỗi khi đăng ký tài khoản. Vui lòng thử lại");
                    }
                } else {
                    JOptionPane.showMessageDialog(Cau1.this, "Mật khẩu và xác nhận mật khẩu không khớp");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        add(mainPanel);

        setVisible(true);
    }
    private boolean saveUser(String username, String password) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO USER1 (Username, Password) VALUES ('" + username + "', '" + password + "')";
            int rowsAffected = statement.executeUpdate(query);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void connectToDatabase() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SINHVIEN01";
        String password = "1";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database");
            System.exit(1);
        }
    }

    private boolean checkCredentials(String username, String password) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM USER1 WHERE Username='" + username + "' AND Password='" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
            Cau1 form = new Cau1();
    }
}