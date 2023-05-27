import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
class datePicker extends JPanel {
    public JSpinner spinner;
    public JDateChooser dateChooser;

    public datePicker() {
        // Create a JSpinner and set its bounds
        spinner = new JSpinner();
        spinner.setBounds(0, 0, 150, 30);

        // Create a JDateChooser and set its bounds
        dateChooser = new JDateChooser();
        dateChooser.setBounds(30, 0, 150, 30);

        // Create a layered pane to position the components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(225, 30));

        // Add the components to the layered pane
        layeredPane.add(spinner, Integer.valueOf(1));
        layeredPane.add(dateChooser, Integer.valueOf(0));
        // Add the layered pane to the panel
        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);

        // Set the initial date for the date chooser
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1); // Initial date
        Date initialDate = calendar.getTime();
        dateChooser.setDate(initialDate);
        dateChooser.remove(1);
        // Synchronize the spinner and date chooser
        spinner.setModel(new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH));
        spinner.setEditor(new JSpinner.DateEditor(spinner, "dd/MM/yyyy"));
        spinner.addChangeListener(e -> {
            Date selectedDate = (Date) spinner.getValue();
            dateChooser.setDate(selectedDate);
        });
        dateChooser.getDateEditor().addPropertyChangeListener("date", e -> {
            Date selectedDate = dateChooser.getDate();
            spinner.setValue(selectedDate);
        });
    }
}
public class Cau2 extends JFrame {
    private Connection connection;
    private JTextField maBNField;
    private JTextField tenBNField;
    private datePicker ngaySinhPicker;
    private JTextField diaChiField;
    private JTextField dienThoaiField;
    private JComboBox<String> gioiTinhComboBox;
    private int  maKB =0;
    public Cau2() {

        connectToDatabase();
        setTitle("Patient Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel maBNLabel = new JLabel("Mã bệnh nhân:");
        JLabel tenBNLabel = new JLabel("Tên bệnh nhân:");
        JLabel ngaySinhLabel = new JLabel("Ngày sinh:");
        JLabel diaChiLabel = new JLabel("Địa chỉ:");
        JLabel dienThoaiLabel = new JLabel("Điện thoại:");
        JLabel gioiTinhLabel = new JLabel("Giới tính:");

        maBNField = new JTextField(10);
        tenBNField = new JTextField(10);
        ngaySinhPicker = new datePicker();
        diaChiField = new JTextField(10);
        dienThoaiField = new JTextField(10);
        gioiTinhComboBox = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(maBNLabel, gbc);
        gbc.gridx++;
        panel.add(maBNField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(tenBNLabel, gbc);
        gbc.gridx++;
        panel.add(tenBNField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(ngaySinhLabel, gbc);
        gbc.gridx++;
        panel.add(ngaySinhPicker, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(diaChiLabel, gbc);
        gbc.gridx++;
        panel.add(diaChiField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(dienThoaiLabel, gbc);
        gbc.gridx++;
        panel.add(dienThoaiField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(gioiTinhLabel, gbc);
        gbc.gridx++;
        panel.add(gioiTinhComboBox, gbc);

        JButton submitButton = new JButton("Thêm");
        submitButton.setPreferredSize(new Dimension(100, submitButton.getPreferredSize().height));

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth =2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(submitButton, gbc);
        ngaySinhPicker.dateChooser.setDateFormatString(String.valueOf(DateTimeFormatter.ofPattern("dd-MM-yyy")));
        submitButton.addActionListener(e -> {
            String maBN = maBNField.getText();
            String tenBN = tenBNField.getText();
            String ngaySinh = String.valueOf(ngaySinhPicker.dateChooser.getJCalendar().getDate().getDay())+"-"+
                    String.valueOf(ngaySinhPicker.dateChooser.getJCalendar().getDate().getMonth())+"-"+
                    String.valueOf((ngaySinhPicker.dateChooser.getJCalendar().getDate().getYear()/10)%10)+
                    String.valueOf(ngaySinhPicker.dateChooser.getJCalendar().getDate().getYear()%10);
             String diaChi = diaChiField.getText();
            String dienThoai = dienThoaiField.getText();
            String gioiTinh = gioiTinhComboBox.getSelectedItem().toString();
            System.out.println(String.valueOf(ngaySinhPicker.dateChooser.getJCalendar().getDate().getYear()));
            // Perform operations with the form data
            // e.g., save to database or display information
          addPatient(maBN,tenBN,ngaySinh,diaChi,dienThoai,gioiTinh);
        });

        add(panel);
        setVisible(true);
    }
    private void connectToDatabase() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SINHVIEN02";
        String password = "1";

        try {
            String dateFormat = "dd-MM-yyyy";
            connection = DriverManager.getConnection(url, username, password);
            java.sql.Statement statement = connection.createStatement();
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = '" + dateFormat + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database");
            System.exit(1);
        }
    }
    private boolean addPatient(String maBN, String tenBN, String ngaySinh, String diaChi, String dienThoai, String gioiTinh) {

        if (maBN.isEmpty() || tenBN.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || dienThoai.isEmpty() || gioiTinh.isEmpty()) {
            return false;
        } else {
            try {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO BENHNHAN(MABN, TENBN,NGSINH,DCHI,DTHOAI,GIOITINH) VALUES ('" + maBN + "', '" + tenBN + "','" + ngaySinh + "','"+ diaChi + "','" + dienThoai + "','" + gioiTinh +"')";
                int rowsAffected = statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Thêm bệnh nhân thành công");
                return rowsAffected > 0;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Thêm bệnh nhân không thành công");
                e.printStackTrace();
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            PatientForm form = new PatientForm();
//            Reservation r=new Reservation();
//            ReserveDetail r=new ReserveDetail();
            payMent p=new payMent();
        });
    }
}
class Reservation extends JFrame{
    public static int MaKB;
    private Connection connection;
    private JTextField maBNField;
    private JTextField TenBN;
    private datePicker ngayKhamPicker;
    private JTextField yeuCauKhamField;
    private JComboBox<String> BsKham;

    public Reservation() {
        connectToDatabase();
        setTitle("Kham Benh Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel maBNLabel = new JLabel("Mã bệnh nhân:");
        JLabel maBSLabel = new JLabel("Tên Bệnh nhân:");
        JLabel ngayKhamLabel = new JLabel("Ngày khám:");
        JLabel yeuCauKhamLabel = new JLabel("Yêu cầu khám:");
        JLabel ketLuanLabel = new JLabel("Bác sĩ:");


        maBNField = new JTextField(15);
        TenBN = new JTextField(15);
        ngayKhamPicker = new datePicker();
        yeuCauKhamField = new JTextField(15);
        BsKham =new JComboBox<>(new String[]{"Tên Bác sĩ                "});
        BsKham.setSize(100,100);
        JButton submitButton = new JButton("Thêm");


        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(maBNLabel, gbc);
        gbc.gridx++;
        panel.add(maBNField, gbc);


        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(maBSLabel, gbc);
        gbc.gridx++;
        panel.add(TenBN, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(ngayKhamLabel, gbc);
        gbc.gridx++;
        panel.add(ngayKhamPicker, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(yeuCauKhamLabel, gbc);
        gbc.gridx++;
        panel.add(yeuCauKhamField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(ketLuanLabel, gbc);
        gbc.gridx++;
        panel.add(BsKham, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);
        TenBN.setEditable(false);
        Bskham();
        maBNField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    TenBN.setText(TenBN(maBNField.getText()));
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maBN = maBNField.getText();
              String ngayKham = String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getDay())+"-"+
                      String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getMonth())+"-"+
                      String.valueOf((ngayKhamPicker.dateChooser.getJCalendar().getDate().getYear()/10)%10)+
                      String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getYear()%10);
                String yeuCauKham = yeuCauKhamField.getText();
                String bskham= BsKham.getSelectedItem().toString();
                addKhamBenh(maBN,bskham,ngayKham,yeuCauKham);
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean addKhamBenh(String maBN,String bsKham, String ngayKham, String yeuCauKham ) {
        if (maBN.isEmpty() || ngayKham.isEmpty()|| yeuCauKham.isEmpty() || bsKham.isEmpty()) {
            return false; // Validation failed, return false
        } else {
            try {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO KHAMBENH (MAKB,MABN,MABS,NGAYKHAM,YEUCAUKHAM,KETLUAN,THANHTOAN) VALUES ('" + MaKB + "', '" + maBN + "','" +Mabs(bsKham) + "','"+ ngayKham+ "','" + yeuCauKham + "','" +"khong" +"','" +"khong"+ "')";
                int rowsAffected = statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Đặt lịch khám thành công");
                return rowsAffected > 0;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Đặt lịch khám không thành công");
                e.printStackTrace();

            }
            MaKB++;
            return true;
        }
    }
    private String Mabs(String tenbs){
        String mabs=" ";
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT MABS FROM BACSI WHRERE TENBS='"+tenbs+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                mabs=resultSet.getString("MABS");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mabs;
    }
    private void Bskham(){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT TENBS FROM BACSI";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
               String tenbs= resultSet.getString("TENBS");
               BsKham.addItem(tenbs);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private String TenBN(String maBN){
        try {
            String mabn=" ";
            Statement statement = connection.createStatement();
            String query="SELECT TENBN FROM BENHNHAN WHERE MABN='"+maBN+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                 mabn = resultSet.getString("TENBN");
            }
            resultSet.close();
            statement.close();
            return mabn;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Không có tên bệnh nhân này");
            e.printStackTrace();
        }
        return " ";
    }
    private void connectToDatabase() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SINHVIEN02";
        String password = "1";

        try {
            String dateFormat = "dd-MM-yyyy";
            connection = DriverManager.getConnection(url, username, password);
            java.sql.Statement statement = connection.createStatement();
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = '" + dateFormat + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database");
            System.exit(1);
        }
    }
}
class ReserveDetail extends JFrame {
    public static int MaKB;
    private Connection connection;
    private JComboBox<String> Bskham;
    private datePicker ngayKhamPicker;
    private JComboBox<String> TenBN;
    private JTextField yeucaukham;
    private JTextField ketluan;
    private JTable Dsdv;
    private JTable Dsdv_BsChon;
    private DefaultTableModel Dsdv_D;
    private DefaultTableModel  Dsdv_bschon;

    ReserveDetail() {

        super("Khám bệnh");
        connectToDatabase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(5, 5, 5, 5);


        setVisible(true);

        JLabel BskhamLabel=new JLabel("Bác sĩ khám");
        JLabel ngaykhamLabel=new JLabel("Ngày Khám");
        JLabel TenBNLabel=new JLabel("Tên Bệnh Nhân");
        JLabel yeuCauKhamLabel=new JLabel("Yêu cầu khám");
        JLabel ketLuanLabel=new JLabel("Kết luận");
        JLabel DsdvLabel=new JLabel("Danh sách dịch vụ");
        JLabel Dsdv_BsChonLabel=new JLabel("Danh sách dịch vụ bác sĩ chọn");

        Bskham=new JComboBox<>(new String[]{"Tên Bác sĩ         "});
        ngayKhamPicker=new datePicker();
        TenBN=new JComboBox<>(new String[]{"Tên bệnh nhân       "});
        yeucaukham=new JTextField(15);
        yeucaukham.setEditable(false);
        ketluan=new JTextField(15);
        ketluan.setPreferredSize(new Dimension(120,20));
        JButton submitButton = new JButton("Thêm");
        Dsdv_D=new DefaultTableModel(new String[][]{
                {"Dịch vụ A"},
                {"Dịch vụ B"},
                {"Dịch vụ C"},
                {"Dịch vụ D"}
        },new String[]{"Tên dịch vụ"});
        Dsdv=new JTable(Dsdv_D);
        JScrollPane DsDv=new JScrollPane(Dsdv);
     DsDv.setPreferredSize(new Dimension(200,100));
       Dsdv_bschon=new DefaultTableModel(new String[][]{
        },new String[]{"Tên dịch vụ","Số lượng"});
        Dsdv_BsChon=new JTable(Dsdv_bschon);
        JScrollPane DsDv_BsChon=new JScrollPane(Dsdv_BsChon);
        DsDv_BsChon.setPreferredSize(new Dimension(150,100));
        Bskham();
        Ds();
        YeuCauKham((String) TenBN.getSelectedItem());
        gbc.gridy++;
        gbc.gridx=0;
        panel.add(BskhamLabel,gbc);
        gbc.gridx++;
        panel.add(Bskham,gbc);


        gbc.gridx=2;
        panel.add(ngaykhamLabel,gbc);
        gbc.gridx++;
        panel.add(ngayKhamPicker,gbc);


        gbc.gridy++;
        gbc.gridx=0;
        panel.add(TenBNLabel,gbc);
        gbc.gridx++;
        panel.add(TenBN,gbc);



        gbc.gridx=2;
        panel.add(yeuCauKhamLabel,gbc);
        gbc.gridx++;
        panel.add(yeucaukham,gbc);

        gbc.gridy++;
        gbc.gridx=0;
        panel.add(ketLuanLabel,gbc);
        gbc.gridx++;
        panel.add(ketluan,gbc);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx=0;
        gbc1.gridy=3;
        gbc1.insets=new Insets(5,5,5,5);
        gbc1.anchor=GridBagConstraints.WEST;

        gbc1.gridy++;
        gbc1.gridx=1;
        panel.add(DsdvLabel,gbc1);
        gbc1.gridy++;
        panel.add(DsDv,gbc1);

        gbc1.gridy--;
        gbc1.gridx=3;
        panel.add(Dsdv_BsChonLabel,gbc1);
        gbc1.gridy++;
        panel.add(DsDv_BsChon,gbc1);

        submitButton.setPreferredSize(new Dimension(100,30));
        gbc1.gridy++;
        gbc1.gridx=2;
        panel.add(submitButton,gbc1);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKhamBenh(yeucaukham.getText(),ketluan.getText(),maBN((String) TenBN.getSelectedItem()),maBskham((String) Bskham.getSelectedItem()));
            }
        });

        add(panel);
        ListSelectionModel selectionModel=Dsdv.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {// This check is necessary to prevent multiple events on a single selection
                    int selectedRow = Dsdv.getSelectedRow();
                    if (selectedRow != -1) {

                        // Do something with the selected row
                       putItem((String) Dsdv.getValueAt(selectedRow,0));

                        }

                    }
                }

        });
        ngayKhamPicker.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String ngayKham = String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getDay())+"-"+
                            String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getMonth())+"-"+
                            String.valueOf((ngayKhamPicker.dateChooser.getJCalendar().getDate().getYear()/10)%10)+
                            String.valueOf(ngayKhamPicker.dateChooser.getJCalendar().getDate().getYear()%10);
                    TenBN(Bskham.getSelectedItem().toString(),ngayKham);
                }
            }
        });

    }
    private void Ds(){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT TENDV FROM DICHVU";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String tenDV= resultSet.getString("TENDV");
                Dsdv_D.addRow(new String[]{tenDV});
                System.out.println(tenDV);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void YeuCauKham(String tenBN){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT Y.YEUCAUKHAM FROM BENHNHAN B INNER JOIN KHAMBENH Y ON B.MABN=Y.MABN WHERE TENBN='"+tenBN+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String yeucaukham1= resultSet.getString("YEUCAUKHAM");
                yeucaukham.setText(yeucaukham1);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void TenBN(String Bs,String ngay){
        try {
            String tenbn;
            Statement statement = connection.createStatement();
            String query="SELECT B.TENBN,B.MABN FROM KHAMBENH K INNER JOIN BENHNHAN B ON K.MABN=B.MABN" +
                    " INNER JOIN BACSI A ON K.MABS=A.MABS WHERE TENBS='"+Bs+"' AND NGAYKHAM='"+ngay+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                tenbn = resultSet.getString("TENBN");
                TenBN.addItem(tenbn);

            }
            resultSet.close();
            statement.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Không có tên bệnh nhân này");
            e.printStackTrace();
        }
    }
    private void Bskham(){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT TENBS FROM BACSI";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String tenbs= resultSet.getString("TENBS");
                Bskham.addItem(tenbs);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private String maBskham(String TenBS){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT MABS FROM BACSI WHERE TENBS='"+TenBS+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String mabs= resultSet.getString("MABS");
                return mabs;
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private String maBN(String TenBN){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT MABN FROM BENHNHAN WHERE TENBN ='"+TenBN+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String mabn= resultSet.getString("MABN");
                return mabn;
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private void putItem(String item) {
        boolean hasRow=false;
        if (Dsdv_BsChon.getRowCount() != 0) {
            for (int i = 0; i < Dsdv_BsChon.getRowCount(); i++) {
                if (Dsdv_BsChon.getValueAt(i, 0).toString() == item) {
                    int y=Integer.parseInt(Dsdv_BsChon.getValueAt(i,1).toString());
                    Dsdv_BsChon.setValueAt(y+1,i,1);
                    hasRow=true;
                }
            }
            if(hasRow==false){
                Dsdv_bschon.addRow(new String[]{item, String.valueOf(1)});
            }

        }
        else {
            Dsdv_bschon.addRow(new String[]{item, String.valueOf(1)});
        }

    }

    private boolean addKhamBenh(String yeuCauKham,String Ketluan,String mabn,String mabs) {
        if ( Ketluan.isEmpty()) {
            return false; // Validation failed, return false
        } else {
            try {
                Statement statement = connection.createStatement();
                String query = "UPDATE KHAMBENH SET YEUCAUKHAM='"+yeuCauKham+"', KETLUAN='"+Ketluan+"' WHERE MABN='"+mabn+"' AND MABS='"+mabs+"'";
                int rowsAffected = statement.executeUpdate(query);
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            MaKB++;
            return true;
        }
    }

    private void connectToDatabase() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SINHVIEN02";
        String password = "1";

        try {
            String dateFormat = "dd-MM-yyyy";
            connection = DriverManager.getConnection(url, username, password);
            java.sql.Statement statement = connection.createStatement();
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = '" + dateFormat + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database");
            System.exit(1);
        }
    }

}
class payMent extends JFrame{
    private Connection connection;
   private JTextField maBN;
    private datePicker ngayKham;
    private JTextField tenBn;
    private JTextField yeuCauKham;
    private JTextField ketLuan;
    private JTextField tongTien;
    private JTable dsDv;
    private DefaultTableModel dsDv_model;
    private JCheckBox thanhToan;
    payMent(){
        super("Khám bệnh");
        connectToDatabase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(5, 5, 5, 5);


        setVisible(true);

        JLabel maBnLabel=new JLabel("Mã bệnh nhân");
        JLabel ngayKhamLabel=new JLabel("Ngày khám");
        JLabel tenBnLabel=new JLabel("Tên bệnh nhân");
        JLabel yeuCauKhamLabel=new JLabel("Yêu cầu khám");
        JLabel ketLuanLabel=new JLabel("Kết luận");
        JLabel tongTienLabel=new JLabel("Tổng tiền");
        JLabel dsDvLabel=new JLabel("Danh sách dịch vụ đã khám");

        maBN=new JTextField(15);
        ngayKham=new datePicker();
        tenBn=new JTextField("ABC",15);
        yeuCauKham=new JTextField(15);
        ketLuan=new JTextField(15);
        tongTien=new JTextField(15);
        dsDv_model =new DefaultTableModel(new String[][]{{}},
                new String[]{"Tên dịch vụ","Số lượng","Thành tiền"});
        dsDv=new JTable(dsDv_model);
        JScrollPane dsDv_scroll=new JScrollPane(dsDv);
        dsDv_scroll.setPreferredSize(new Dimension(500,100));
        thanhToan=new JCheckBox("Đã thanh toán");
        JButton submitButton=new JButton("Thanh toán");

        tenBn.setEnabled(false);
        yeuCauKham.setEditable(false);
        ketLuan.setEditable(false);
        tongTien.setEditable(false);



        gbc.gridy++;
        gbc.gridx=0;
        panel.add(maBnLabel,gbc);
        gbc.gridx++;
        panel.add(maBN,gbc);


        gbc.gridx=2;
        panel.add(ngayKhamLabel,gbc);
        gbc.gridx++;
        panel.add(ngayKham,gbc);


        gbc.gridy++;
        gbc.gridx=0;
        panel.add(tenBnLabel,gbc);
        gbc.gridx++;
        panel.add(tenBn,gbc);

        gbc.gridx=2;
        panel.add(yeuCauKhamLabel,gbc);
        gbc.gridx++;
        panel.add(yeuCauKham,gbc);

        gbc.gridy++;
        gbc.gridx=0;
        panel.add(ketLuanLabel,gbc);
        gbc.gridx++;
        panel.add(ketLuan,gbc);

        gbc.gridx=2;
        panel.add(tongTienLabel,gbc);
        gbc.gridx++;
        panel.add(tongTien,gbc);

        GridBagConstraints gbc1 = new GridBagConstraints();

        gbc1.gridy=3;
        gbc1.insets=new Insets(5,5,5,5);
        gbc1.anchor=GridBagConstraints.WEST;

        gbc1.gridy++;
        gbc1.gridx=0;
        panel.add(dsDvLabel,gbc1);
        gbc1.gridy++;
        gbc1.gridwidth=100;
        panel.add(dsDv_scroll,gbc1);

        gbc1.gridy--;
        gbc1.gridx=3;
        panel.add(thanhToan,gbc1);



        maBN.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    tenBn.setText(TenBN(maBN.getText()));
                }
            }
        });

        thanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(thanhToan.isSelected()){
                    submitButton.setEnabled(false);
                }
                else {
                    submitButton.setEnabled(true);
                }
            }
        });
        ngayKham.spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String ngaykham = String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getDay())+"-"+
                        String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getMonth())+"-"+
                        String.valueOf((ngayKham.dateChooser.getJCalendar().getDate().getYear()/10)%10)+
                        String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getYear()%10);
                yeuCauKham(ngaykham);
                dichVu(ngaykham);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ngaykham = String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getDay())+"-"+
                        String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getMonth())+"-"+
                        String.valueOf((ngayKham.dateChooser.getJCalendar().getDate().getYear()/10)%10)+
                        String.valueOf(ngayKham.dateChooser.getJCalendar().getDate().getYear()%10);
            xacNhan(ngaykham);
            }
        });
        submitButton.setPreferredSize(new Dimension(100,30));
        gbc1.gridy++;
        gbc1.gridy++;
        gbc1.gridx=2;

        panel.add(submitButton,gbc1);
        add(panel);
        setVisible(true);

    }
    private void connectToDatabase() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SINHVIEN02";
        String password = "1";

        try {
            String dateFormat = "dd-MM-yyyy";
            connection = DriverManager.getConnection(url, username, password);
            java.sql.Statement statement = connection.createStatement();
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = '" + dateFormat + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database");
            System.exit(1);
        }
    }
    private void yeuCauKham(String ngaykham){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT YEUCAUKHAM,KETLUAN FROM KHAMBENH WHERE NGAYKHAM ='"+ngaykham+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String yeucaukham= resultSet.getString("YEUCAUKHAM");
                String ketluan= resultSet.getString("KETLUAN");
                yeuCauKham.setText(yeucaukham);
                ketLuan.setText(ketluan);

            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void dichVu(String ngaykham){
        int Sum=0;
        try {
            Statement statement = connection.createStatement();
            String query="SELECT TENDV, SOLUONG,THANHTIEN FROM DICHVU D INNER JOIN THUPHI T ON D.MADV=T.MADV INNER JOIN KHAMBENH K ON T.MAKB=K.MAKB WHERE NGAYKHAM ='"+ngaykham+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String tendv=resultSet.getString("TENDV");
                String soluong=resultSet.getString("SOLUONG");
                String thanhtien=resultSet.getString("THANHTIEN");
                int thanhTien=Integer.parseInt(thanhtien);
                Sum+=thanhTien;
                dsDv_model.addRow(new String[]{tendv,soluong,thanhtien});
            }
            tongTien.setText(String.valueOf(Sum));
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private String TenBN(String maBN){
        try {
            Statement statement = connection.createStatement();
            String query="SELECT TENBN FROM BENHNHAN WHERE MABN ='"+maBN+"'";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                String tenbn= resultSet.getString("TENBN");
                return tenbn;
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private void xacNhan(String ngaykham){
        try {
            Statement statement = connection.createStatement();
            String query="UPDATE KHAMBENH SET THANHTOAN='TRUE' WHERE MABN ='"+maBN.getText()+"' AND NGAYKHAM='"+ngaykham+"'";
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}