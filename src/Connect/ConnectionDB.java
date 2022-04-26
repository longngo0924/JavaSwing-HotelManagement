package Connect;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

//class connection để
//kết nối csdl 
//thực hiện các lệnh truy vấn 
//insert update delete
//select
public class ConnectionDB {
//    tạo chuỗi hết nối

	private String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyKhachSan";
	private String user = "sa";
	private String password = "sapassword";
	static Connection conn = null;

	static PreparedStatement preparedStatement(String cauTruyVan) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public ConnectionDB() {
		try {

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connect successfully(kết nối thành công)");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("lỗi kết nối csdl");
		}

	}

	// hàm thực thi câu lệnh select
	public static ResultSet Getdata(String cauTruyVan) {
		try {
			Statement stm = conn.createStatement();
			// thực thicaau truy vấn select dc truyền vào từ
			// tham số cautruyvan
			// trả về kết quả là ResultSet
			ResultSet rs = stm.executeQuery(cauTruyVan);
			return rs;// trả về resultset nếu thành công
		} catch (SQLException ex) {
			System.out.println("Lỗi truy vấn");
			return null;
		}

	}

	// hàm thực thi 3 câu lệnh insert delete update
	public static int ExecuteTruyVan(String cauTruyVan) {
		try {
			Statement stm = conn.createStatement();
			return stm.executeUpdate(cauTruyVan);

		} catch (SQLException ex) {
			System.out.println("lỗi thực thi truy vấn");
			ex.printStackTrace();
			return -1;
		}
	}
}
