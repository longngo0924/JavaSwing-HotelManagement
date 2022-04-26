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

	public ThongKe(String dateFrom, String dateTo) {
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

		JLabel lblNewLabel_1 = new JLabel("Tổng Doanh Thu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(27, 120, 227, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(27, 160, 227, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng Hoá Đơn:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(27, 200, 227, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng Tiền Dịch Vụ:");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(27, 240, 227, 14);
		getContentPane().add(lblNewLabel_1_1_2);

		JLabel fromDate = new JLabel("Từ ngày:");
		fromDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		fromDate.setBounds(27, 80, 227, 14);
		getContentPane().add(fromDate);

		JTextField txtFromDate = new JTextField(20);
		txtFromDate.setBounds(120, 80, 150, 20);
		getContentPane().add(txtFromDate);
		txtFromDate.setText(dateFrom);
		txtFromDate.setEditable(false);
		txtFromDate.setColumns(10);

		JLabel toDate = new JLabel("Đến ngày:");
		toDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		toDate.setBounds(300, 80, 227, 14);
		getContentPane().add(toDate);

		JTextField txtToDate = new JTextField(20);
		txtToDate.setBounds(400, 80, 150, 20);
		getContentPane().add(txtToDate);
		txtToDate.setText(dateTo);
		txtToDate.setEditable(false);
		txtToDate.setColumns(10);

		txt_TongDoanhThu = new JTextField();
		txt_TongDoanhThu.setBounds(205, 120, 542, 20);
		getContentPane().add(txt_TongDoanhThu);
		txt_TongDoanhThu.setColumns(10);

		txt_TongKhachHang = new JTextField();
		txt_TongKhachHang.setBounds(205, 160, 542, 20);
		getContentPane().add(txt_TongKhachHang);
		txt_TongKhachHang.setColumns(10);

		txt_TongHoaDon = new JTextField();
		txt_TongHoaDon.setBounds(205, 200, 542, 20);
		getContentPane().add(txt_TongHoaDon);
		txt_TongHoaDon.setColumns(10);

		txt_TongDichVu = new JTextField();
		txt_TongDichVu.setBounds(205, 240, 542, 20);
		getContentPane().add(txt_TongDichVu);
		txt_TongDichVu.setColumns(10);

		pieChart = ChartFactory.createPieChart("", createDataset(dateFrom, dateTo), true, true, false);
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(120, 300, 600, 220);
		pane.add(chartPanel);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PieDataset createDataset(String from, String to) {

		List<ChiTietThuePhongDto> dsData = chiTietThuePhongDao.getDataByTimeFrame(from, to);
		float tongTien = 0;
		float tienDichVu = 0;
		int tongDon = 0;
		int tongKhach = chiTietThuePhongDao.getTotalCustomer();
		for (int i = 0; i < dsData.size(); i++) {
			tongTien = tongTien + dsData.get(i).getTongTien() - dsData.get(i).getTienDichVu();
			tienDichVu = tienDichVu + dsData.get(i).getTienDichVu();
			tongDon += 1;
		}

		txt_TongDoanhThu.setText(String.valueOf(tongTien));
		txt_TongDichVu.setText(String.valueOf(tienDichVu));
		txt_TongKhachHang.setText(String.valueOf(tongKhach));
		txt_TongHoaDon.setText(String.valueOf(tongDon));

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Tiền phòng", tongTien);
		dataset.setValue("Tiền dịch vụ", tienDichVu);

		return dataset;
	}

}
