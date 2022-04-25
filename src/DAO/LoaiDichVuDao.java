package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectionDB;
import DTO.LoaiDichVuDto;

public class LoaiDichVuDao {
	private static ConnectionDB connection = new ConnectionDB();

	public static List<LoaiDichVuDto> layDSLoaiDichVu() {
		List<LoaiDichVuDto> dsLoaiDichVu = new ArrayList<>();
		try {
			String query = "select * from [dbo].[LoaiDichVu]";
			ResultSet result = connection.Getdata(query);
			while (result.next()) {
				LoaiDichVuDto dto = new LoaiDichVuDto(result.getString(1), result.getString(2));
				dsLoaiDichVu.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLoaiDichVu;

	}

	public static boolean themLoaiDichVu(String maLoai, String tenLoai) {
		boolean result = false;
		try {
			String query = "insert into [dbo].[LoaiDichVu] (maLoaiDichVu, tenLoaiDichVu) values ('" + maLoai + "', N'"
					+ tenLoai + "')";
			int sum = connection.ExecuteTruyVan(query);
			if (sum > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean capNhatLoaiDichVu(String maLoai, String tenLoai) {
		boolean result = false;
		try {
			String query = "UPDATE [dbo].[LoaiDichVu]\r\n" + "SET tenLoaiDichVu = N'" + tenLoai + "'\r\n"
					+ "WHERE maLoaiDichVu like '" + maLoai + "'";
			int sum = connection.ExecuteTruyVan(query);
			if (sum > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean xoaLoaiDichVu(String maLoai) {
		boolean result = false;
		try {
			String query = "\r\n" + "DELETE FROM [dbo].[LoaiDichVu] WHERE maLoaiDichVu like '" + maLoai + "';";
			int sum = connection.ExecuteTruyVan(query);
			if (sum > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
