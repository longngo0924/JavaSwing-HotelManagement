package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import DAO.DAO_Phong;
import DTO.DTO_Phong;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

@SuppressWarnings({ "unused", "serial" })
public class Main extends JFrame implements ActionListener, MouseListener {
	private JPanel pMenu;
	private JButton btn_Home;
	private JButton btn_QuanLyPhong;
	private JButton btn_LoaiPhong;
	private JButton btn_DichVu;
	private JButton btnNewButton;
	private JButton btn_KhachHang;
	private JButton btnLoaiDichVu;
	private JButton DangXuat;
	private JPanel pCenter;
	private DefaultTableModel model;
	private DefaultTableModel modeltang1;
	private JScrollPane scrollPanetang1;
	private DefaultTableModel modeltang2;
	private DefaultTableModel modeltang3;
	private JTable table2;
	private JTable table3;
	private JScrollPane JS_tang2;
	private JScrollPane JS_tang3;
	private JComboBox comboBox;
	private JScrollPane JS;
	private JScrollPane scrollPane;
	private JPanel panelTinhTrang;
	private JTable table1;
	private JScrollPane js1;
	private JScrollPane js2;
	private JScrollPane js3;
	private JPopupMenu popupMenu;
	private JMenuItem datPhong;
	private DefaultTableModel modelPhong;
	private JTable table;
	private JScrollPane js;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JMenuItem xemThongTinChiTiet;
	private JLabel lblNewLabel_2;
	private JMenuBar menuBar;
	private JMenu File;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JButton btnThongKe;

	public Main() {
		setTitle("main");
		setSize(1223, 600);
		getContentPane().add(pMenu = new JPanel(), BorderLayout.WEST);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pMenu.setBackground(new Color(0, 128, 128));

		pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(null);

		JPanel panelHead = new JPanel();
		panelHead.setBackground(new Color(192, 192, 192));
		panelHead.setBounds(10, 23, 658, 44);
		pCenter.add(panelHead);
		panelHead.setLayout(null);
		panelHead.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JButton btnConTrong = new JButton("Còn Trống\r\n");
		btnConTrong.setBackground(Color.RED);
		btnConTrong.setBounds(33, 11, 89, 23);
		panelHead.add(btnConTrong);

		JButton btn_Thue = new JButton("Đã Thuê");
		btn_Thue.setBackground(Color.GREEN);
		btn_Thue.setBounds(146, 11, 89, 23);
		panelHead.add(btn_Thue);

		JLabel lblNewLabel = new JLabel("Hướng dẫn: Click chuột phải vào phòng đã chọn để đặt phòng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel.setBounds(10, 78, 502, 23);
		pCenter.add(lblNewLabel);

		/*
		 * comboBox = new JComboBox(); comboBox.setBounds(92, 79, 112, 22);
		 * comboBox.addItem("Tầng 1"); comboBox.addItem("Tầng 2");
		 * comboBox.addItem("Tầng 3"); comboBox.setSelectedIndex(0);
		 * pCenter.add(comboBox);
		 */

		panelTinhTrang = new JPanel();
		panelTinhTrang.setBackground(new Color(192, 192, 192));
		panelTinhTrang.setBounds(10, 123, 658, 389);
		pCenter.add(panelTinhTrang);
		panelTinhTrang.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		String[] headTang = { "mã Phòng", "Loại Phòng", "Tầng", "Tình trạng", "Mô tả" };
		model = new DefaultTableModel(headTang, 0);

		table = new JTable(model);
		js = new JScrollPane(table);
		panelTinhTrang.add(js);
		js.setPreferredSize(new Dimension(600, 300));

		pMenu.setLayout(new GridLayout(10, 1));
		JLabel label = new JLabel("QUẢN LÝ KHÁCH SẠN");
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(30, 144, 255));
		pMenu.add(label);
		pMenu.add(btn_Home = new JButton("Home"));
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pMenu.add(btn_QuanLyPhong = new JButton("Quản Lý Phòng"));

		btn_LoaiPhong = new JButton("Loại Phòng");
		pMenu.add(btn_LoaiPhong);

		btn_DichVu = new JButton("Dịch Vụ");
		pMenu.add(btn_DichVu);

		btnLoaiDichVu = new JButton("Loại Dịch Vụ");
		pMenu.add(btnLoaiDichVu);

		btnThongKe = new JButton("Thống Kê");
		pMenu.add(btnThongKe);

		btn_KhachHang = new JButton("Khách Hàng");
		pMenu.add(btn_KhachHang);

		DangXuat = new JButton("Đăng Xuất");
		pMenu.add(DangXuat);

		popupMenu = new JPopupMenu();
		datPhong = new JMenuItem("Đặt Phòng");
		xemThongTinChiTiet = new JMenuItem("Quản lý đặt trả phòng");
		popupMenu.add(datPhong);
		popupMenu.add(xemThongTinChiTiet);
		table.setComponentPopupMenu(popupMenu);

		panel = new JPanel();
		panel.setBounds(678, 11, 413, 541);
		pCenter.add(panel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src\\hinh\\5098385.jpg"));
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Lọc:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 0, 49, 23);
		pCenter.add(lblNewLabel_2);

		menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		File = new JMenu("File");
		menuBar.add(File);

		mntmNewMenuItem = new JMenuItem("Cài đặt tài khoản");
		File.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Cài dặt CSDL");
		File.add(mntmNewMenuItem_1);

		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hướng Dẫn Sử Dụng Chương Trình");
		mnNewMenu.add(mntmNewMenuItem_2);
		table.addMouseListener(this);
		datPhong.addActionListener(this);
		xemThongTinChiTiet.addActionListener(this);
		btn_QuanLyPhong.addActionListener(this);
		btn_LoaiPhong.addActionListener(this);
		btn_DichVu.addActionListener(this);
		btnLoaiDichVu.addActionListener(this);
		btn_KhachHang.addActionListener(this);
		btnThongKe.addActionListener(this);
		try {
			doDuLieuTuCollection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void doDuLieuTuCollection() throws SQLException {

		ArrayList<DTO_Phong> list = DAO_Phong.getalltPhong();
		for (DTO_Phong dto_Phong : list) {
			model.addRow(new Object[] { dto_Phong.getMaPhong(), dto_Phong.getLoaiphong(), dto_Phong.getTangPhong(),
					dto_Phong.isTrangThai() ? "Còn Trống" : "Được Thuê", dto_Phong.getGhiChu() });
		}
	}

	public static void main(String[] args) {
		new Main().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(datPhong)) {
			int vitri = table.getSelectedRow();
			String soPhong = model.getValueAt(vitri, 0).toString();
			if (model.getValueAt(vitri, 3).equals("Được Thuê")) {
				JOptionPane.showMessageDialog(null, "Phòng đã có người đặt");
			} else {
				new DatPhong(soPhong).setVisible(true);
			}

		} else if (obj.equals(xemThongTinChiTiet)) {
			int vitri = table.getSelectedRow();
			String soPhong = model.getValueAt(vitri, 0).toString();
			if (model.getValueAt(vitri, 3).equals("Được Thuê")) {
				new ThongTinChiTiet(soPhong).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Phòng chưa có người đặt");
			}
		} else if (obj.equals(btn_QuanLyPhong)) {
			new QUANLYPHONG().setVisible(true);
		} else if (obj.equals(btn_LoaiPhong)) {
			new LoaiPhong().setVisible(true);
		} else if (obj.equals(btn_DichVu)) {
			new DichVu().setVisible(true);
		} else if (obj.equals(btnLoaiDichVu)) {
			new LoaiDichVu().setVisible(true);
		} else if (obj.equals(btnThongKe)) {
			// Thống kê từ ngày đã chọn đến ngày hiện tại
			String date = JOptionPane.showInputDialog(null, "Thống kê từ ngày:", "2022-01-01");
			if (!date.isEmpty()) {
				Date currentDate = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String currentDateString = formatter.format(currentDate);
				new ThongKe(date, currentDateString).setVisible(true);

			}
		} else if (obj.equals(btn_KhachHang)) {
			new KhachHang().setVisible(true);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
