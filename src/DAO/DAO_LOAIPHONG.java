package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectionDB;
import DTO.DTO_LoaiPhong;
import GUI.LoaiPhong;

public class DAO_LOAIPHONG {
	private static ConnectionDB con=new ConnectionDB();
	public DAO_LOAIPHONG() {
		
	}
	
	public static boolean themLoaiPhong(DTO_LoaiPhong a) {
		String CauTruyVan="insert into LoaiPhong(tenLoaiPhong,gia,mota)\r\n"
				+ "values(N'"+a.getTenLoaiPhong()+"','"+a.getGia()+"',N'"+a.getTienNghi()+"')";
		int ketqua=con.ExecuteTruyVan(CauTruyVan);
		 if (ketqua > 0) {
	            JOptionPane.showMessageDialog(null, "Thành công");
	            return true;
	        } else {
	        	  JOptionPane.showMessageDialog(null, "Thất bại");
	        	 return false;
	        }
	}
	public static ArrayList<DTO_LoaiPhong> getalltLoaiPhong() throws SQLException {
		ArrayList<DTO_LoaiPhong> list=new ArrayList<DTO_LoaiPhong>();
		ConnectionDB con= new ConnectionDB();
		String sql="Select * from LoaiPhong";
		ResultSet rs= con.Getdata(sql);
		while(rs.next()) {
			
			
			String tenLoaiPhong=rs.getString(1);
			float gia=rs.getFloat(2);
			String tienNghi=rs.getString(3);
			DTO_LoaiPhong loaiphong=new DTO_LoaiPhong(tenLoaiPhong, gia, tienNghi);
			list.add(loaiphong);
		}
		return list;
		
	}
	public static boolean xoaLoaiPHong(String  tenLoaiPhong) {
        String cautruyvan = "DELETE FROM LoaiPhong "
                + "      WHERE tenLoaiPhong=" + "'"+tenLoaiPhong+"'";
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
