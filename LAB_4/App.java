import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.IllegalFormatException;
import java.util.Vector;

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


        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setBounds(10, 399, 89, 23);


        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(433, 69, 155, 20);
        frame.getContentPane().add(textField_1);

        DefaultTableModel model=new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Mã sách");
        model.addColumn("Tên sách");
        model.addColumn("Nhà xuất bản");
        model.addColumn("Tác giả");
        model.addColumn("Giá");
        DSSach ds=new DSSach();
        Vector<Vector<String>> data=new Vector<>();
        JScrollPane j=new JScrollPane(table);
        j.setBounds(69, 188, 543, 185);
        frame.getContentPane().add(j);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Vector<String> data1 = new Vector<>();
                    data1.add(textField.getText());
                    data1.add(textField_1.getText());
                    data1.add(textField_2.getText());
                    data1.add(textField_3.getText());
                    data1.add(textField_4.getText());
                    Sach sach=new Sach(data1.get(0),data1.get(1),data1.get(2),data1.get(3),Double.parseDouble(data1.get(4)));
                    for (int i = 0; i < 5; i++) {
                        if (data1.get(i).isEmpty()) {
                            Exception NumberFormatException = new Exception("chua nhap du thong tin");
                            JOptionPane.showMessageDialog(frame, "Chưa nhập đử thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
                            throw NumberFormatException;
                        }
                    }
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                for(int i=0;i<data.size();i++){
                        if(data.get(i).get(0).equals(data1.get(0))){
                            Exception IllegalStateException = new Exception("Trung ma so");
                            JOptionPane.showMessageDialog(frame, "Trung ma so", "Error", JOptionPane.ERROR_MESSAGE);
                            throw IllegalStateException;
                        }
                }

                for(int i=0;i<data1.get(4).length();i++){
                    char c=data1.get(4).charAt(i);
                    if((int)c<48 || (int)c>57){
                        Exception IllegalFormatException = new Exception("nhap sai gia");
                        JOptionPane.showMessageDialog(frame, "Gia phai la so", "Error", JOptionPane.ERROR_MESSAGE);
                        throw IllegalFormatException;
                    }
                }

                model.addRow(data1);
                data.add(data1);
                ds.themSach(sach);
                    System.out.println(data);
            }
                catch (IllegalFormatException ex0){
                    System.out.println("Nhap lai");
                }
                catch (IllegalStateException ex1){
                    System.out.println("Nhap lai");
                }
                catch (NumberFormatException ex2){
                    System.out.println("nhap lai");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //- Khi chọn một dòng trên bảng thì sẽ hiện thông tin sách lên các ô nhập liệu
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String Masach=table.getValueAt(selectedRow,0).toString();
                        String Tensach=table.getValueAt(selectedRow,1).toString();
                        String Nxb=table.getValueAt(selectedRow,2).toString();
                        String Tacgia=table.getValueAt(selectedRow,3).toString();
                        String Gia=table.getValueAt(selectedRow,4).toString();

                        // Hiển thị thông tin sách lên các ô nhập liệu
                      textField.setText(Masach);
                      textField_1.setText(Tensach);
                        textField_2.setText(Nxb);
                        textField_3.setText(Tacgia);
                        textField_4.setText(Gia);
                    }
                }
            }
        });


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


        frame.getContentPane().add(btnNewButton);

        JButton btnXa = new JButton("Xóa");
        btnXa.setBounds(104, 399, 89, 23);
        frame.getContentPane().add(btnXa);
        btnXa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        if (table.isRowSelected(selectedRow)) {
                            int result = JOptionPane.showConfirmDialog(null, "Co chac chan la muon xoa");
                            if (result == JOptionPane.YES_OPTION) {
                               ds.xoaSach(model.getValueAt(selectedRow,0).toString());
                                model.removeRow(selectedRow);
                                data.remove(selectedRow);

                            }
                        }
                    }
                    else {
                            String Masach = textField.getText();
                           for(int i=0;i<data.size();i++){
                               if(data.get(i).get(0).equals(Masach)){
                                   ds.xoaSach(model.getValueAt(i,0).toString());
                                   model.removeRow(i);
                                   data.remove(i);
                               }
                           }

                        }
                    }


        });


        JButton btnSa = new JButton("Sửa");
        btnSa.setBounds(199, 399, 89, 23);
        frame.getContentPane().add(btnSa);

        JButton btnLu = new JButton("Lưu");
        btnLu.setBounds(299, 399, 89, 23);
        frame.getContentPane().add(btnLu);

        JButton btnTm = new JButton("Tìm");
        btnTm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                String Masach = textField.getText();
                for(int i=0;i<data.size();i++){
                    if(data.get(i).get(0).equals(Masach)){
                        textField.setText(Masach);
                        textField_1.setText(data.get(i).get(1));
                        textField_2.setText(data.get(i).get(2));
                        textField_3.setText(data.get(i).get(3));
                        textField_4.setText(data.get(i).get(4));
                        flag++;
                    }
                }
                if(flag==0) {
                    JOptionPane.showMessageDialog(frame, "Khong tim thay", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
