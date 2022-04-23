package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoaiDichVu  extends JFrame{
	private JTextField txtLoaiDichVu;
	private JTextField txt_TenDichVu;
	private DefaultTableModel model;
	private JTable table;
	public LoaiDichVu() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(690, 369);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 675, 40);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("LOẠI DỊCH VỤ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Mã Loại Dịch Vụ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 128, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTnLoiDch = new JLabel("Tên Loại Dịch Vụ");
		lblTnLoiDch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTnLoiDch.setBounds(10, 123, 128, 32);
		getContentPane().add(lblTnLoiDch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 187, 305, 95);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(10, 11, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xoá");
		btnNewButton_1.setBounds(177, 11, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.setBounds(10, 61, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Làm Mới");
		btnNewButton_3.setBounds(177, 61, 89, 23);
		panel_1.add(btnNewButton_3);
		
		String[] head= {"Mã dịch vụ","Tên Dịch Vụ"};
		model= new DefaultTableModel(head,0);
		table= new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(325, 51, 340, 270);
		getContentPane().add(scrollPane);
		
		txtLoaiDichVu = new JTextField();
		txtLoaiDichVu.setBounds(129, 68, 186, 20);
		getContentPane().add(txtLoaiDichVu);
		txtLoaiDichVu.setColumns(10);
		
		txt_TenDichVu = new JTextField();
		txt_TenDichVu.setBounds(131, 130, 184, 20);
		getContentPane().add(txt_TenDichVu);
		txt_TenDichVu.setColumns(10);
	}
}
