
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTable table;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 691, 472);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Thông tin sách");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(269, 0, 119, 48);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã sách");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(69, 71, 87, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(149, 70, 155, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Tác giả");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(332, 71, 107, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(433, 69, 155, 20);
        frame.getContentPane().add(textField_1);

        table = new JTable();
        table.setBounds(69, 188, 543, 185);
        frame.getContentPane().add(table);

        JLabel lblNewLabel_1_2 = new JLabel("Tên sách");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(69, 98, 87, 14);
        frame.getContentPane().add(lblNewLabel_1_2);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(149, 97, 155, 20);
        frame.getContentPane().add(textField_2);

        JLabel lblNewLabel_1_1_1 = new JLabel("Nhà suất bản");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(332, 98, 107, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(433, 96, 155, 20);
        frame.getContentPane().add(textField_3);

        JLabel lblNewLabel_1_3 = new JLabel("Giá");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(69, 125, 87, 14);
        frame.getContentPane().add(lblNewLabel_1_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(149, 124, 155, 20);
        frame.getContentPane().add(textField_4);

        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setBounds(10, 399, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnXa = new JButton("Xóa");
        btnXa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnXa.setBounds(104, 399, 89, 23);
        frame.getContentPane().add(btnXa);

        JButton btnSa = new JButton("Sửa");
        btnSa.setBounds(199, 399, 89, 23);
        frame.getContentPane().add(btnSa);

        JButton btnLu = new JButton("Lưu");
        btnLu.setBounds(299, 399, 89, 23);
        frame.getContentPane().add(btnLu);

        JButton btnTm = new JButton("Tìm");
        btnTm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnTm.setBounds(398, 399, 89, 23);
        frame.getContentPane().add(btnTm);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(487, 399, 89, 23);
        frame.getContentPane().add(btnClear);

        JButton btnThot = new JButton("Thoát");
        btnThot.setBounds(586, 399, 89, 23);
        frame.getContentPane().add(btnThot);
    }
}
