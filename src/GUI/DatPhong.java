package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DTO.DTO_KhachHang;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class DatPhong  extends JFrame implements ActionListener{
	private JTextField textTenKhachHang;
	private JTextField textTuoi;
	private JTextField textSDT;
	private JTextField txt_CMND;
	private JTextField txt_SoNguoi;
	private JTextField txt_Ngay;
	private JTextField txtEmail;
	private JButton btnCheckIn;
	private JTextField txt_DiaChi;
	private JComboBox cbx_GioiTinh;
	public DatPhong(String maPhong) {
		getContentPane().setLayout(null);
		setSize(450, 491);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel lblTenPhong = new JLabel("Phòng"+" "+maPhong);
		lblTenPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblTenPhong.setBounds(141, 4, 148, 24);
		getContentPane().add(lblTenPhong);
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblKhachHang.setBounds(41, 64, 111, 37);
		getContentPane().add(lblKhachHang);
		
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTuoi.setBounds(41, 98, 111, 37);
		getContentPane().add(lblTuoi);
		
		JLabel lblGiiTnh = new JLabel("Giơi Tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGiiTnh.setBounds(41, 127, 111, 37);
		getContentPane().add(lblGiiTnh);
		
		JLabel lblSDT = new JLabel("SDT");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSDT.setBounds(41, 159, 111, 37);
		getContentPane().add(lblSDT);
		
		JLabel lblCMND = new JLabel("CCCD/CMND");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCMND.setBounds(41, 188, 111, 37);
		getContentPane().add(lblCMND);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(41, 215, 111, 37);
		getContentPane().add(lblEmail);
		
		JLabel lblNgayThue = new JLabel("Ngày Thuê");
		lblNgayThue.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNgayThue.setBounds(41, 244, 111, 37);
		getContentPane().add(lblNgayThue);
		
		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSoNguoi.setBounds(41, 281, 111, 37);
		getContentPane().add(lblSoNguoi);
		
		textTenKhachHang = new JTextField();
		textTenKhachHang.setBounds(162, 73, 234, 20);
		getContentPane().add(textTenKhachHang);
		textTenKhachHang.setColumns(10);
		
		textTuoi = new JTextField();
		textTuoi.setBounds(162, 107, 237, 20);
		getContentPane().add(textTuoi);
		textTuoi.setColumns(10);
		
		textSDT = new JTextField();
		textSDT.setBounds(162, 168, 234, 20);
		getContentPane().add(textSDT);
		textSDT.setColumns(10);
		
		cbx_GioiTinh = new JComboBox();
		cbx_GioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbx_GioiTinh.setBounds(162, 135, 235, 22);
		getContentPane().add(cbx_GioiTinh);
		
		txt_CMND = new JTextField();
		txt_CMND.setColumns(10);
		txt_CMND.setBounds(161, 197, 235, 20);
		getContentPane().add(txt_CMND);
		
		txt_SoNguoi = new JTextField();
		txt_SoNguoi.setColumns(10);
		txt_SoNguoi.setBounds(161, 290, 235, 20);
		getContentPane().add(txt_SoNguoi);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setBounds(163, 253, 233, 20);
		getContentPane().add(txt_DiaChi);
		txt_DiaChi.setColumns(10);
		
		 btnCheckIn = new JButton("Check In!");
		btnCheckIn.setBackground(Color.GREEN);
		btnCheckIn.setBounds(108, 349, 89, 23);
		getContentPane().add(btnCheckIn);
		
		JButton btnHuy = new JButton("Huỷ");
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(207, 349, 89, 23);
		getContentPane().add(btnHuy);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(162, 224, 234, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		btnCheckIn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj.equals(btnCheckIn)) {
			String maKh=txt_CMND.getText();
			String tenkh=textTenKhachHang.getText();
			String CMND=txt_CMND.getText();
			String diachi=txt_DiaChi.getText();
			String tuoi=textTuoi.getText();
			int tuoii=Integer.parseInt(tuoi);
			String sdt=textSDT.getText();
			boolean gioitinh= cbx_GioiTinh.getSelectedItem().equals("Nam")?true:false;
			String email=txtEmail.getText();
			DTO_KhachHang kh=new DTO_KhachHang(maKh, tenkh, CMND, diachi, sdt, gioitinh, tuoii, email);
			DAO.DAO_KhachHang.themKH(kh, maKh);
		}
			
		
		
	}
}
