package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

public class ThongKe extends JFrame {
	private JTextField txt_TongDoanhThu;
	private JTextField txt_TongKhachHang;
	private JTextField txt_TongHoaDon;
	private JTextField txt_TongDichVu;

	public ThongKe() {
		setSize(830, 573);
		getContentPane().setBackground(Color.LIGHT_GRAY);

		/*
		 * Date: 23/04/2022 Note: set frame display at center window screen
		 * ==============================================================
		 */
		setLocationRelativeTo(null);

		// ===============================================================
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 818, 41);
		panel.setBackground(Color.cyan);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 320, 818, 41);
		panel_1.setBackground(Color.cyan);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("Thống Kê Dịch Vụ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tổng Doanh Thu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(27, 80, 227, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(27, 160, 227, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng Hoá Đơn:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(27, 240, 227, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		txt_TongDoanhThu = new JTextField();
		txt_TongDoanhThu.setBounds(205, 80, 542, 20);
		getContentPane().add(txt_TongDoanhThu);
		txt_TongDoanhThu.setColumns(10);

		txt_TongKhachHang = new JTextField();
		txt_TongKhachHang.setBounds(205, 160, 542, 20);
		getContentPane().add(txt_TongKhachHang);
		txt_TongKhachHang.setColumns(10);

		txt_TongHoaDon = new JTextField();
		txt_TongHoaDon.setBounds(205, 240, 542, 20);
		getContentPane().add(txt_TongHoaDon);
		txt_TongHoaDon.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tổng Doanh Thu Dịch Vụ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(27, 358, 247, 20);
		getContentPane().add(lblNewLabel_3);

		txt_TongDichVu = new JTextField();
		txt_TongDichVu.setBounds(307, 360, 440, 20);
		getContentPane().add(txt_TongDichVu);
		txt_TongDichVu.setColumns(10);
	}

	public static void main(String[] args) {
		ThongKe frm = new ThongKe();
		frm.setVisible(true);
	}
}
