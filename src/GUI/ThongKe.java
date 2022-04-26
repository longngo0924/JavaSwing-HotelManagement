package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import DAO.ChiTietThuePhongDao;
import DTO.ChiTietThuePhongDto;

public class ThongKe extends JFrame {
	private JTextField txt_TongDoanhThu;
	private JTextField txt_TongKhachHang;
	private JTextField txt_TongHoaDon;
	private JTextField txt_TongDichVu;
	private ChiTietThuePhongDao chiTietThuePhongDao = new ChiTietThuePhongDao();
	private Container pane;
	private JFreeChart pieChart;

	public ThongKe() {
		setSize(830, 590);
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

		pane = getContentPane();

		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JLabel fromDate = new JLabel("Từ ngày:");
		fromDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		fromDate.setBounds(27, 80, 227, 14);
		getContentPane().add(fromDate);

		JTextField txtFromDate = new JTextField(20);
		txtFromDate.setBounds(120, 80, 150, 20);
		getContentPane().add(txtFromDate);
		txtFromDate.setColumns(10);

		JLabel toDate = new JLabel("Đến ngày:");
		toDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		toDate.setBounds(300, 80, 227, 14);
		getContentPane().add(toDate);

		JTextField txtToDate = new JTextField(20);
		txtToDate.setBounds(400, 80, 150, 20);
		getContentPane().add(txtToDate);
		txtToDate.setColumns(10);

		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBounds(580, 80, 120, 20);
		getContentPane().add(btnThongKe);

		JLabel lblNewLabel_1 = new JLabel("Tổng Doanh Thu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(27, 160, 227, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(27, 200, 227, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng Hoá Đơn:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(27, 240, 227, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		txt_TongDoanhThu = new JTextField();
		txt_TongDoanhThu.setBounds(205, 160, 542, 20);
		getContentPane().add(txt_TongDoanhThu);
		txt_TongDoanhThu.setColumns(10);

		txt_TongKhachHang = new JTextField();
		txt_TongKhachHang.setBounds(205, 200, 542, 20);
		getContentPane().add(txt_TongKhachHang);
		txt_TongKhachHang.setColumns(10);

		txt_TongHoaDon = new JTextField();
		txt_TongHoaDon.setBounds(205, 240, 542, 20);
		getContentPane().add(txt_TongHoaDon);
		txt_TongHoaDon.setColumns(10);

		pieChart = ChartFactory.createPieChart("", null);
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(120, 300, 600, 220);
		pane.add(chartPanel);

		chartPanel.setVisible(false);

		btnThongKe.addActionListener(e -> {
			String from = txtFromDate.getText();
			String to = txtToDate.getText();

			if (from.isEmpty() || to.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
			} else {
				try {
					List<ChiTietThuePhongDto> dsData = chiTietThuePhongDao.getDataByTimeFrame(from, to);
					float tongTien = 0;
					int tongKhachHang = chiTietThuePhongDao.getTotalCustomer();
					int tongHoaDon = dsData.size();
					for (int i = 0; i < dsData.size(); i++) {
						tongTien = tongTien + dsData.get(i).getTongTien();
					}

					txt_TongDoanhThu.setText(String.valueOf(tongTien));
					txt_TongHoaDon.setText(String.valueOf(tongHoaDon));
					txt_TongKhachHang.setText(String.valueOf(tongKhachHang));
					pieChart = ChartFactory.createPieChart("", createDataset(from, to), true, true, false);

					chartPanel.setVisible(true);

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Định dạng ngày tháng theo YYYY-MM-DD");
				}
			}
		});

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PieDataset createDataset(String from, String to) {

		List<ChiTietThuePhongDto> dsData = chiTietThuePhongDao.getDataByTimeFrame(from, to);
		float tongTien = 0;
		float tienDichVu = 0;
		for (int i = 0; i < dsData.size(); i++) {
			tongTien = tongTien + dsData.get(i).getTongTien() - dsData.get(i).getTienDichVu();
			tienDichVu = tienDichVu + dsData.get(i).getTienDichVu();
		}

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Tiền phòng", tongTien);
		dataset.setValue("Tiền dịch vụ", tienDichVu);

		return dataset;
	}

	public static void main(String[] args) {
		ThongKe frm = new ThongKe();
		frm.setVisible(true);
	}
}
