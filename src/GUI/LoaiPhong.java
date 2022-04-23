package GUI;

import javax.swing.JFrame;
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
import DTO.DTO_KhachHang;
import DTO.DTO_LoaiPhong;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class LoaiPhong extends JFrame implements ActionListener {
	private JTextField txt_TenLoaiPhong;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JTextField txt_Gia;
	private JTextField txt_TienNghi;

	public LoaiPhong() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(883, 481);

		JLabel lblTnLoiPhng = new JLabel("Tên Loại Phòng");
		lblTnLoiPhng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTnLoiPhng.setBounds(65, 45, 136, 25);
		getContentPane().add(lblTnLoiPhng);

		txt_TenLoaiPhong = new JTextField();
		txt_TenLoaiPhong.setBounds(65, 78, 222, 20);
		getContentPane().add(txt_TenLoaiPhong);
		txt_TenLoaiPhong.setColumns(10);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGi.setBounds(320, 45, 136, 25);
		getContentPane().add(lblGi);

		txt_Gia = new JTextField();
		txt_Gia.setColumns(10);
		txt_Gia.setBounds(320, 78, 222, 20);
		getContentPane().add(txt_Gia);

		JLabel lblTinNghi = new JLabel("Tiện Nghi");
		lblTinNghi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTinNghi.setBounds(65, 123, 136, 25);
		getContentPane().add(lblTinNghi);

		txt_TienNghi = new JTextField();
		txt_TienNghi.setColumns(10);
		txt_TienNghi.setBounds(65, 160, 222, 20);
		getContentPane().add(txt_TienNghi);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 866, 34);
		getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("LOẠI PHÒNG");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(lblNewLabel_1);

		String[] head = { "Tên loại", "Giá", "Tiện Nghi" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 206, 846, 210);
		getContentPane().add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(632, 45, 224, 135);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 250, 154));
		btnThem.setBounds(10, 11, 89, 52);
		panel_1.add(btnThem);

		btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(255, 99, 71));
		btnXoa.setBounds(125, 11, 89, 52);
		panel_1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(147, 112, 219));
		btnSua.setBounds(10, 74, 89, 50);
		panel_1.add(btnSua);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBackground(new Color(255, 255, 0));
		btnLamMoi.setBounds(125, 74, 89, 50);
		panel_1.add(btnLamMoi);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		doDuLieuTuCollection();
	}

	private void doDuLieuTuCollection() {
		
		try {
			ArrayList<DTO_LoaiPhong> list = DAO_LOAIPHONG.getalltLoaiPhong();
			for (DTO_LoaiPhong dto_LoaiPhong : list) {
				model.addRow(new Object[] { dto_LoaiPhong.getTenLoaiPhong(), dto_LoaiPhong.getGia(),
						dto_LoaiPhong.getTienNghi()});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean validData() {

		String tenLoaiPhong = txt_TenLoaiPhong.getText();
		String gia = txt_Gia.getText();
		String tiennghi = txt_TienNghi.getText();

		if (tenLoaiPhong.equals("")) {
			JOptionPane.showMessageDialog(null, "Tên loại phòng không được rỗng");
			return false;
		} else if (gia.equals("")) {
			JOptionPane.showMessageDialog(null, "Giá không được rỗng");
			return false;
		} else if (tiennghi.equals("")) {
			JOptionPane.showMessageDialog(null, "Tiện Nghi Không được rỗng");
			return false;
		} else {
			try {
				double giaa = Double.parseDouble(gia);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Giá phải nhập số");
				return false;
			}
		}
		return true;
	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			if (validData()) {
				ArrayList<DTO_LoaiPhong> list;
				try {
					list = DAO_LOAIPHONG.getalltLoaiPhong();

					String tenLoaiPhong = txt_TenLoaiPhong.getText();
					float gia = (float) Double.parseDouble(txt_Gia.getText());
					String tiennghi = txt_TienNghi.getText();
					DTO_LoaiPhong loaiphong = new DTO_LoaiPhong(tenLoaiPhong, gia, tiennghi);
					if (list.contains(loaiphong)) {
						JOptionPane.showMessageDialog(null, "Trùng");
					} else {
						if (DAO_LOAIPHONG.themLoaiPhong(loaiphong)) {
							xoaHetDuLieuTrenModel();
							doDuLieuTuCollection();
						}
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();

				}
			}
		}else if (obj.equals(btnLamMoi)) {
				txt_Gia.setText("");

				txt_TenLoaiPhong.setText("");
				txt_TienNghi.setText("");
		} else if (obj.equals(btnXoa)) {
				int row = table.getSelectedRow();
				String LoaiPhong = table.getValueAt(row, 0).toString();
				if (DAO_LOAIPHONG.xoaLoaiPHong(LoaiPhong)==true) {
					xoaHetDuLieuTrenModel();
					doDuLieuTuCollection();
				}
		}
	}
}
