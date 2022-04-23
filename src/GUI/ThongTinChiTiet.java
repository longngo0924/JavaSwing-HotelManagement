package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongTinChiTiet extends JFrame {
	private JTextField txtTenKH;
	private JTextField txt_Gioitinh;
	private JTextField txtCMND;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	private JTextField txtQuequan;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txt_TienNghi;
	private JTextField txtGiaPhong;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane js;
	private JTextField txt_SoLuongDichVu;
	private JTextField textField;
	private JTextField txt_Thenganhang;
	private JTextField txt_TienKhachDua;
	private JTextField txt_TraLai;
	private DefaultTableModel modeldv;
	private JTable table_dv;
	public ThongTinChiTiet(String maphong) {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		setSize(1142, 678);
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(-99, 0, 1231, 29);
		getContentPane().add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Phòng: "+maphong);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(887, 39, 235, 549);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 20, 60));
		panel_2.setBounds(0, 0, 235, 40);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_18 = new JLabel("Thanh Toán");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Tổng Tiền:");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_19.setForeground(Color.RED);
		lblNewLabel_19.setBounds(10, 51, 99, 21);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblTongTien = new JLabel("New label");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTongTien.setBounds(104, 51, 121, 19);
		panel_1.add(lblTongTien);
		
		JLabel lblNewLabel_20 = new JLabel("Hình Thức thanh toán");
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(0, 99, 131, 14);
		panel_1.add(lblNewLabel_20);
		
		JComboBox cbx_ThanhToan = new JComboBox();
		cbx_ThanhToan.setModel(new DefaultComboBoxModel(new String[] {"Tiền Mặt", "Ngân Hàng"}));
		cbx_ThanhToan.setBounds(141, 96, 84, 22);
		panel_1.add(cbx_ThanhToan);
		
		JLabel lblNewLabel_21 = new JLabel("Thẻ ngân hàng");
		lblNewLabel_21.setBounds(0, 124, 121, 14);
		panel_1.add(lblNewLabel_21);
		
		txt_Thenganhang = new JTextField();
		txt_Thenganhang.setBounds(131, 121, 96, 20);
		panel_1.add(txt_Thenganhang);
		txt_Thenganhang.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Tiền Khách Đưa");
		lblNewLabel_22.setBounds(0, 149, 89, 14);
		panel_1.add(lblNewLabel_22);
		
		txt_TienKhachDua = new JTextField();
		txt_TienKhachDua.setBounds(129, 147, 96, 17);
		panel_1.add(txt_TienKhachDua);
		txt_TienKhachDua.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("trả lại");
		lblNewLabel_23.setBounds(0, 174, 89, 14);
		panel_1.add(lblNewLabel_23);
		
		txt_TraLai = new JTextField();
		txt_TraLai.setBounds(129, 171, 96, 20);
		panel_1.add(txt_TraLai);
		txt_TraLai.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 216, 215, 206);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_24 = new JLabel("Ghi chú");
		lblNewLabel_24.setBounds(0, 199, 49, 14);
		panel_1.add(lblNewLabel_24);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setBackground(Color.GREEN);
		btnThanhToan.setForeground(Color.DARK_GRAY);
		btnThanhToan.setBounds(10, 471, 121, 23);
		panel_1.add(btnThanhToan);
		
		JPanel pChiTietThuePhong = new JPanel();
		pChiTietThuePhong.setBackground(Color.LIGHT_GRAY);
		pChiTietThuePhong.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pChiTietThuePhong.setBounds(10, 40, 867, 311);
		getContentPane().add(pChiTietThuePhong);
		pChiTietThuePhong.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 20, 60));
		panel_4.setBounds(0, 0, 867, 40);
		pChiTietThuePhong.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chi Tiết Thuê Phòng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 5, 448, 24);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 51, 451, 134);
		pChiTietThuePhong.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 22, 92, 14);
		panel_5.add(lblNewLabel_2);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(100, 19, 138, 20);
		panel_5.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Giới Tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(253, 22, 68, 14);
		panel_5.add(lblNewLabel_3);
		
		txt_Gioitinh = new JTextField();
		txt_Gioitinh.setBounds(310, 19, 48, 20);
		panel_5.add(txt_Gioitinh);
		txt_Gioitinh.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CMND/CCCD");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(20, 48, 68, 14);
		panel_5.add(lblNewLabel_4);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(100, 47, 138, 20);
		panel_5.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tuổi");
		lblNewLabel_5.setBounds(253, 47, 49, 14);
		panel_5.add(lblNewLabel_5);
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(310, 47, 48, 20);
		panel_5.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(24, 73, 78, 14);
		panel_5.add(lblNewLabel_6);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(100, 70, 138, 20);
		panel_5.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quê Quán");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(20, 98, 49, 14);
		panel_5.add(lblNewLabel_8);
		
		txtQuequan = new JTextField();
		txtQuequan.setBounds(100, 98, 138, 20);
		panel_5.add(txtQuequan);
		txtQuequan.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(471, 61, 386, 124);
		pChiTietThuePhong.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Số Phòng");
		lblNewLabel_10.setBounds(20, 25, 49, 14);
		panel_6.add(lblNewLabel_10);
		
		txtSoPhong = new JTextField();
		txtSoPhong.setBounds(100, 23, 70, 17);
		panel_6.add(txtSoPhong);
		txtSoPhong.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Loại Phòng");
		lblNewLabel_11.setBounds(184, 25, 79, 14);
		panel_6.add(lblNewLabel_11);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBounds(259, 23, 89, 17);
		panel_6.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);
		
		txt_TienNghi = new JTextField();
		txt_TienNghi.setBounds(100, 51, 70, 20);
		panel_6.add(txt_TienNghi);
		txt_TienNghi.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Tiện Nghi");
		lblNewLabel_12.setBounds(20, 60, 49, 14);
		panel_6.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Giá Phòng\r\n");
		lblNewLabel_13.setBounds(184, 60, 49, 14);
		panel_6.add(lblNewLabel_13);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setBounds(259, 57, 96, 20);
		panel_6.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		String[] head= {"Mã hoá đơn","Mã phòng","Ngày Thuê","Ngày trả","Tổng Thời Gian","Tiền Phòng","Giảm Giá"};
		model=new DefaultTableModel(head, 0);
		table=new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 196, 847, 77);
		pChiTietThuePhong.add(scrollPane);
		
		JLabel lblNewLabel_14 = new JLabel("Tổng Tiền Phòng:");
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14.setBounds(10, 284, 162, 14);
		pChiTietThuePhong.add(lblNewLabel_14);
		
		JLabel lbTongTien = new JLabel("....");
		lbTongTien.setForeground(Color.RED);
		lbTongTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbTongTien.setBounds(402, 284, 107, 14);
		pChiTietThuePhong.add(lbTongTien);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_3.setBounds(10, 362, 865, 226);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(220, 20, 60));
		panel_7.setBounds(0, 5, 865, 33);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Chi Tiết Dịch Vụ");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBackground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_17.setBounds(10, 5, 447, 14);
		panel_7.add(lblNewLabel_17);
		String[] headDv= {"Loại dịch vụ","Tên Dịch vụ","Đơn giá","Số lượng","Thành tiền"};
		modeldv=new DefaultTableModel(headDv, 0);
		table_dv=new JTable(modeldv);
		
		JScrollPane jsDV = new JScrollPane(table_dv);
		jsDV.setBounds(10, 49, 473, 140);
		
		panel_3.add(jsDV);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Th\u00EAm D\u1ECBch V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(493, 49, 362, 166);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lbl_ChonloaiDichVu = new JLabel("Chọn Loại Dịch Vụ");
		lbl_ChonloaiDichVu.setBounds(10, 35, 101, 14);
		panel_8.add(lbl_ChonloaiDichVu);
		
		JComboBox cbx_DichVu = new JComboBox();
		cbx_DichVu.setBounds(137, 31, 174, 22);
		panel_8.add(cbx_DichVu);
		
		JLabel lblNewLabel_15 = new JLabel("Số Lượng");
		lblNewLabel_15.setBounds(10, 83, 83, 14);
		panel_8.add(lblNewLabel_15);
		
		txt_SoLuongDichVu = new JTextField();
		txt_SoLuongDichVu.setBounds(137, 78, 174, 22);
		panel_8.add(txt_SoLuongDichVu);
		txt_SoLuongDichVu.setColumns(10);
		
		JLabel lbl_ThanhTien = new JLabel("Thành Tiền");
		lbl_ThanhTien.setBounds(10, 109, 101, 14);
		panel_8.add(lbl_ThanhTien);
		
		textField = new JTextField();
		textField.setBounds(137, 103, 174, 20);
		panel_8.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Chọn Dịch Vụ");
		lblNewLabel_16.setBounds(10, 58, 83, 14);
		panel_8.add(lblNewLabel_16);
		
		JComboBox cbx_DichVu_1 = new JComboBox();
		cbx_DichVu_1.setBounds(137, 54, 174, 22);
		panel_8.add(cbx_DichVu_1);
		
		JButton btnThemDichVu = new JButton("Thêm");
		btnThemDichVu.setBackground(new Color(50, 205, 50));
		btnThemDichVu.setBounds(137, 132, 89, 23);
		panel_8.add(btnThemDichVu);
		
		JButton btn_XoaDichVu = new JButton("Xoá Dịch Vụ");
		btn_XoaDichVu.setBackground(new Color(153, 50, 204));
		btn_XoaDichVu.setBounds(354, 192, 129, 23);
		panel_3.add(btn_XoaDichVu);
		
		JLabel lblNewLabel_25 = new JLabel("Tổng Tiền DV:");
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_25.setForeground(Color.RED);
		lblNewLabel_25.setBounds(20, 200, 151, 15);
		panel_3.add(lblNewLabel_25);
	}
}
