package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectionDB;
import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;

public class DAO_Phong {
	private static ConnectionDB con=new ConnectionDB();
	public DAO_Phong() {
		
	}
	public static boolean themPhong(DTO_Phong a) {
		int tinhtrang=a.isTrangThai()?1:0;
		String CauTruyVan="insert into Phong(maPhong,tangPhong,maLoaiPhong,trangThai,ghiChu)\r\n"
				+ "values ('"+a.getMaPhong()+"','"+a.getTangPhong()+"',N'"+a.getLoaiphong()+"',"+tinhtrang+",'"+a.getGhiChu()+"')";
		int ketqua=con.ExecuteTruyVan(CauTruyVan);
		 if (ketqua > 0) {
	            JOptionPane.showMessageDialog(null, "Thêm Thành công");
	            return true;
	        } else {
	        	  JOptionPane.showMessageDialog(null, "Thêm Thất bại");
	        	 return false;
	        }
	}
	public static ArrayList<DTO_Phong> getalltPhong() throws SQLException {
		ArrayList<DTO_Phong> list=new ArrayList<DTO_Phong>();
		ConnectionDB con= new ConnectionDB();
		String sql="Select * from Phong";
		ResultSet rs= con.Getdata(sql);
		while(rs.next()) {
			String maPhong=rs.getString(1);
			String tangPhong=rs.getString(2);
			String maLoaiPhong=rs.getString(3);
			int trangthai=rs.getInt(4);
			String ghiChu=rs.getString(5);
			boolean tinhtrang=(trangthai==0)?false:true;
			DTO_Phong phong=new DTO_Phong(maPhong, tangPhong, maLoaiPhong, tinhtrang, ghiChu);
			list.add(phong);
		}
		return list;
		
	}
	public static boolean xoaPHong(String  maPhong) {
        String cautruyvan = "DELETE FROM Phong "
                + "      WHERE maPhong=" + "'"+maPhong+"'";
        int kq = con.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
        	  JOptionPane.showMessageDialog(null, "Xoá Thành công");
        	  return true;
        } else {
        	 JOptionPane.showMessageDialog(null, "Xoá Thất bại");
        	 return false;
        }
    }
}
