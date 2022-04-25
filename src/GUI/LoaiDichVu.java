package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiDichVuDao;
import DTO.LoaiDichVuDto;

public class LoaiDichVu extends JFrame implements MouseInputListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6891576570898375650L;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private DefaultTableModel model;
	private JTable table;
	private LoaiDichVuDao loaiDichVuDao;
	private List<LoaiDichVuDto> dsLoaiDichVu;
	private JButton btnThem;

	@SuppressWarnings("static-access")
	public LoaiDichVu() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(690, 369);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
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

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 89, 23);
		panel_1.add(btnThem);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(177, 11, 89, 23);
		panel_1.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(10, 61, 89, 23);
		panel_1.add(btnSua);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(177, 61, 89, 23);
		panel_1.add(btnLamMoi);

		String[] head = { "Mã loại dịch vụ", "Tên loại Dịch Vụ" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(325, 51, 340, 270);
		getContentPane().add(scrollPane);
		loadDataFromDB(dsLoaiDichVu, model);
		table.addMouseListener(this);

		txtMaLoai = new JTextField();
		txtMaLoai.setBounds(129, 68, 186, 20);
		getContentPane().add(txtMaLoai);
		txtMaLoai.setColumns(10);
		txtMaLoai.setText(generateId());
		txtMaLoai.setEditable(false);

		txtTenLoai = new JTextField();
		txtTenLoai.setBounds(131, 130, 184, 20);
		getContentPane().add(txtTenLoai);
		txtTenLoai.setColumns(10);

		btnThem.addActionListener(e -> {
			String maLoai = txtMaLoai.getText();
			String tenLoai = txtTenLoai.getText();
			if (tenLoai.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại dịch vụ!");
			} else {
				boolean result = loaiDichVuDao.themLoaiDichVu(maLoai, tenLoai);
				if (result) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					model.setRowCount(0);
					loadDataFromDB(dsLoaiDichVu, model);
					resetInputField();

				} else {
					JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng thử lại!");

				}
			}

		});

		btnSua.addActionListener(e -> {
			String tenLoai = txtTenLoai.getText();
			String maLoai = txtMaLoai.getText();
			if (tenLoai.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại dịch vụ!");
			} else {
				boolean result = loaiDichVuDao.capNhatLoaiDichVu(maLoai, tenLoai);
				if (result) {
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					model.setRowCount(0);
					loadDataFromDB(dsLoaiDichVu, model);
					resetInputField();

				} else {
					JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng thử lại!");

				}
			}
		});

		btnLamMoi.addActionListener(e -> {
			btnThem.setEnabled(true);
			resetInputField();
		});

		btnXoa.addActionListener(e -> {
			String tenLoai = txtTenLoai.getText();
			String maLoai = txtMaLoai.getText();
			if (tenLoai.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
			} else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa loại dịch vụ này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					boolean result = loaiDichVuDao.xoaLoaiDichVu(maLoai);
					if (result) {
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						model.setRowCount(0);
						loadDataFromDB(dsLoaiDichVu, model);
						resetInputField();

					} else {
						JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng thử lại!");

					}
				}

			}
		});
	}

	@SuppressWarnings("static-access")
	private void loadDataFromDB(List<LoaiDichVuDto> dsLoaiDichVu, DefaultTableModel model) {
		dsLoaiDichVu = loaiDichVuDao.layDSLoaiDichVu();
		dsLoaiDichVu.forEach(loaiDichVu -> {
			model.addRow(new Object[] { loaiDichVu.getMaLoai(), loaiDichVu.getTenLoai() });

		});
	}

	private void resetInputField() {
		txtMaLoai.setText(generateId());
		txtMaLoai.setEditable(false);
		txtTenLoai.setText("");
	}

	private String generateId() {
		return "LDV" + (model.getRowCount() + 1);
	}

	public static void main(String[] args) {
		LoaiDichVu loaiDichVu = new LoaiDichVu();
		loaiDichVu.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		@SuppressWarnings("static-access")
		List<LoaiDichVuDto> ds = loaiDichVuDao.layDSLoaiDichVu();
		int index = table.getSelectedRow();
		txtMaLoai.setText(ds.get(index).getMaLoai());
		txtTenLoai.setText(ds.get(index).getTenLoai());
		btnThem.setEnabled(false);

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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
