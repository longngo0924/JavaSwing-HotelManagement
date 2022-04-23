package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class KhachHang extends JFrame {
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txt_DiaChi;
	private DefaultTableModel model;
	private JTable table;
	public KhachHang() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(new Dimension(915, 495));
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 898, 45);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 76, 175, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(43, 130, 175, 23);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tuổi");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(43, 181, 109, 23);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel txt_CMND = new JLabel("CMND");
		txt_CMND.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt_CMND.setBounds(382, 76, 175, 23);
		getContentPane().add(txt_CMND);
		
		JLabel txt_SDT = new JLabel("SDT");
		txt_SDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt_SDT.setBounds(382, 130, 175, 23);
		getContentPane().add(txt_SDT);
		
		JLabel TXTemail = new JLabel("Email");
		TXTemail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TXTemail.setBounds(382, 181, 175, 23);
		getContentPane().add(TXTemail);
		
		JLabel lblNewLabel_1_6 = new JLabel("Địa Chỉ");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(595, 81, 175, 23);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Giới Tính");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(595, 135, 175, 23);
		getContentPane().add(lblNewLabel_1_7);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(173, 78, 147, 20);
		getContentPane().add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(173, 132, 147, 20);
		getContentPane().add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 183, 147, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(439, 78, 118, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(437, 132, 118, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(436, 183, 121, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setBounds(685, 78, 138, 20);
		getContentPane().add(txt_DiaChi);
		txt_DiaChi.setColumns(10);
		
		JComboBox cbx_gioitinh = new JComboBox();
		cbx_gioitinh.setModel(new DefaultComboBoxModel(new String[] {"nam", "nữ"}));
		cbx_gioitinh.setBounds(685, 136, 138, 22);
		getContentPane().add(cbx_gioitinh);
		
		String[] head= {"Mã Khách Hàng","Tên Khách Hàng","Tên Khách Hàng","CMND","SDT","Email","Địa Chỉ","Giới Tính"};
		model=new DefaultTableModel(head, 0);
		table=new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 283, 878, 164);
		getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 220, 878, 51);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.setBounds(150, 11, 110, 23);
		panel_1.add(btn_Them);
		
		JButton btn_Xoa = new JButton("Xoá");
		btn_Xoa.setBounds(291, 11, 110, 23);
		panel_1.add(btn_Xoa);
		
		JButton btn_Sua = new JButton("Sửa");
		btn_Sua.setBounds(431, 11, 110, 23);
		panel_1.add(btn_Sua);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBounds(581, 11, 110, 23);
		panel_1.add(btnLmMi);
	}
}
