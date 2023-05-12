
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

class Sach {
    private final String maSach;
    private String tenSach;
    private String tacGia;
    private String nhaXuatBan;
    private double gia;

    public Sach(String maSach, String tenSach, String tacGia, String nhaXuatBan, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.gia = gia;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Mã sách: " + maSach +
                "\nTên sách: " + tenSach +
                "\nTác giả: " + tacGia +
                "\nNhà xuất bản: " + nhaXuatBan +
                "\nGiá: " + gia;
    }
}

class DSSach {
    private ArrayList<Sach> danhSachSach;

    public DSSach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach sach) {

        for (Sach s : danhSachSach) {
            if (s.getMaSach().equals(sach.getMaSach())) {
                System.out.println("Mã sách đã tồn tại. Không thể thêm sách.");
                return;
            }
        }
        danhSachSach.add(sach);
        System.out.println("Thêm sách thành công.");
    }

    public Sach layThongTinSach(int viTri) {
        if (viTri >= 0 && viTri < danhSachSach.size()) {
            return danhSachSach.get(viTri);
        } else {
            System.out.println("Vị trí không hợp lệ.");
            return null;
        }
    }

    public void xoaSach(String maSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equals(maSach)) {
                danhSachSach.remove(sach);
                System.out.println("Xóa sách thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã sách đã cho.");
    }

    public void timSach(String maSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equals(maSach)) {
                System.out.println(sach.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã sách đã cho.");
    }

    public void capNhatThongTinSach(String maSach, String tenSach, String tacGia, String nhaXuatBan, double gia) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equals(maSach)) {
                sach.setTenSach(tenSach);
                sach.setTacGia(tacGia);
                sach.setNhaXuatBan(nhaXuatBan);
                sach.setGia(gia);
                System.out.println("Cập nhật thông tin sách thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã sách đã cho.");
    }

    public int tongSoSach() {
        return danhSachSach.size();
    }

}

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
