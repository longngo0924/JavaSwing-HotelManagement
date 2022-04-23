package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DichVu extends JFrame{
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel model;
	private JTable table;
	public DichVu() {
		setSize(897,612);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 874, 43);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DỊCH VỤ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(397, 11, 145, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(33, 88, 149, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(291, 88, 149, 27);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại Dịch Vụ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(33, 154, 149, 27);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(291, 154, 149, 27);
		getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(146, 93, 96, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(397, 93, 96, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(397, 159, 96, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 158, 96, 22);
		getContentPane().add(comboBox);
		
		String[] head= {"Mã Dịch Vụ","Tên Dịch Vụ","Loại Dịch Vụ","Giá"};
		model=new DefaultTableModel(head, 0);
		table=new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 333, 854, 220);
		getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 199, 462, 117);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.setBounds(10, 71, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(134, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnNewButton_3 = new JButton("Làm Mới");
		btnNewButton_3.setBounds(134, 71, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\20044761_LyPhiMinh\\demoQuanLyKhachSan\\src\\hinh\\DichVu.jpg"));
		lblNewLabel_2.setBounds(516, 54, 348, 268);
		getContentPane().add(lblNewLabel_2);
	}
}
