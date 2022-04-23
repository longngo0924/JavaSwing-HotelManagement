package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_LOAIPHONG;
import DAO.DAO_Phong;
import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class QUANLYPHONG extends JFrame implements ActionListener {
	private JTextField textField_4;
	private DefaultTableModel model;

	private JComboBox cbx_LoaiPhong;
	private JLabel lblNewLabel_1_2_2;
	private JTextArea txt_GhiChu;
	private JTextField txtMaPHong;
	private JTextField txtTang;
	private JComboBox cbx_TrangThai;
	private JButton btnMoi;
	private JButton btnTim;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnXoa;
	private JTable table;
	
	public QUANLYPHONG() {
		setSize(910,620);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 25));
		getContentPane().setBackground(new Color(169, 169, 169));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 897, 57);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHÒNG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(358, 5, 529, 41);
		panel.add(lblNewLabel);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(192, 192, 192));
		panelCenter.setBounds(10, 68, 877, 186);
		getContentPane().add(panelCenter);
		panelCenter.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phòng");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(22, 33, 90, 21);
		panelCenter.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại Phòng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(381, 33, 90, 21);
		panelCenter.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2_1.setBounds(22, 89, 90, 21);
		panelCenter.add(lblNewLabel_1_2_1);
		
		txtMaPHong = new JTextField();
		txtMaPHong.setBackground(Color.WHITE);
		txtMaPHong.setBounds(134, 35, 96, 21);
		panelCenter.add(txtMaPHong);
		txtMaPHong.setColumns(10);
		
		 lblNewLabel_1_2_2 = new JLabel("Ghi Chú");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2_2.setBounds(22, 154, 90, 21);
		panelCenter.add(lblNewLabel_1_2_2);
		
		 txt_GhiChu = new JTextArea();
		txt_GhiChu.setBounds(134, 131, 216, 44);
		panelCenter.add(txt_GhiChu);
		
		 cbx_LoaiPhong = new JComboBox();
		cbx_LoaiPhong.setBackground(Color.WHITE);
		cbx_LoaiPhong.setBounds(507, 34, 96, 22);
		panelCenter.add(cbx_LoaiPhong);
		
		
		cbx_TrangThai = new JComboBox();
		cbx_TrangThai.setFont(new Font("Times New Roman", Font.BOLD, 11));
	   cbx_TrangThai.setBounds(134, 90, 95, 22);
		panelCenter.add(cbx_TrangThai);
		cbx_TrangThai.addItem("Còn Trống");
		cbx_TrangThai.addItem("Đã Thuê");
		
		JLabel lblNewLabel_1_1 = new JLabel("Tầng");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(381, 89, 90, 21);
		panelCenter.add(lblNewLabel_1_1);
		
		txtTang = new JTextField();
		txtTang.setBounds(507, 91, 96, 20);
		panelCenter.add(txtTang);
		txtTang.setColumns(10);
		
		String[] head= {"Mã phòng","Loại Phòng","Tang","Trạng Thái","Ghi Chú"};
		model=new DefaultTableModel(head, 0);
		 table = new JTable(model);

		
		JScrollPane js = new JScrollPane(table);
		js.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		js.setBounds(13, 277, 855, 195);
		getContentPane().add(js);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 468, 877, 99);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 255, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(620, 12, 89, 23);
		panel_3.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(153, 50, 204));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(753, 12, 89, 23);
		panel_3.add(btnSua);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(620, 65, 89, 23);
		panel_3.add(btnXoa);
		
		btnMoi = new JButton("Mới");
		btnMoi.setBackground(new Color(255, 255, 0));
		btnMoi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMoi.setBounds(753, 66, 89, 23);
		panel_3.add(btnMoi);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập mã phòng cần tìm");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(20, 39, 161, 14);
		panel_3.add(lblNewLabel_2);
		
		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(30, 144, 255));
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTim.setBounds(285, 36, 89, 23);
		panel_3.add(btnTim);
		
		textField_4 = new JTextField();
		textField_4.setBounds(179, 37, 96, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		duyetComboBox();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnMoi.addActionListener(this);
		btnTim.addActionListener(this);
		try {
			doDuLieuTuCollection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void doDuLieuTuCollection() throws SQLException {
		
		ArrayList<DTO_Phong> list =DAO_Phong.getalltPhong();
		for (DTO_Phong dto_Phong : list) {
			model.addRow(new Object[] {dto_Phong.getMaPhong(),dto_Phong.getLoaiphong(),dto_Phong.getTangPhong(),dto_Phong.isTrangThai()?"Còn Trống":"Được Thuê",dto_Phong.getGhiChu()});
		}
	}
	private boolean validData() {
		String maPhong=txtMaPHong.getText().trim();
		String loaiPhong=cbx_LoaiPhong.getSelectedItem().toString().trim();
		String ghichu=txt_GhiChu.getText();
		String tang=txtTang.getText();
		String trangThai=cbx_TrangThai.getSelectedItem().toString();
		
		if(maPhong.equals("")) {
			JOptionPane.showMessageDialog(null, "Mã  Phòng không được rỗng");
			return false;
		
		}
		else if(tang.equals("")) {
			JOptionPane.showMessageDialog(null,"Tầng Không được rỗng");
			return false;
		}
		
		return true;
	}
	 private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void duyetComboBox() {
		try {
			ArrayList<DTO_LoaiPhong> list=DAO_LOAIPHONG.getalltLoaiPhong();
			for (DTO_LoaiPhong dto_LoaiPhong : list) {
				cbx_LoaiPhong.addItem(dto_LoaiPhong.getTenLoaiPhong().toString().trim());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maPhong=txtMaPHong.getText().trim();
				String loaiPhong=cbx_LoaiPhong.getSelectedItem().toString().trim();
				String ghichu=txt_GhiChu.getText();
				String tang=txtTang.getText();
				String trangThai=cbx_TrangThai.getSelectedItem().toString();
				boolean tinhTrang=trangThai.equals("Còn Trống")?true:false;
				DTO_Phong phong=new DTO_Phong(maPhong, tang, loaiPhong, tinhTrang, ghichu);
				ArrayList<DTO_Phong> list;
				try {
					list= DAO_Phong.getalltPhong();
					if(list.contains(phong)) {
						JOptionPane.showMessageDialog(null, "Trung");
					}else {
						DAO_Phong.themPhong(phong);
						xoaHetDuLieuTrenModel();
						doDuLieuTuCollection();
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}else if(obj.equals(btnXoa)) {
			try {
				ArrayList<DTO_Phong> list=DAO_Phong.getalltPhong();
				int row=table.getSelectedRow();
				String maPhong=model.getValueAt(row, 0).toString().trim();
				if(DAO_Phong.xoaPHong(maPhong)) {
					xoaHetDuLieuTrenModel();
					doDuLieuTuCollection();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
