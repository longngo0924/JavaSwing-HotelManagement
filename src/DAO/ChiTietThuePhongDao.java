package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectionDB;
import DTO.ChiTietThuePhongDto;

public class ChiTietThuePhongDao {
	private static ConnectionDB connection = new ConnectionDB();

	public List<ChiTietThuePhongDto> getDataByTimeFrame(String from, String to) {
		List<ChiTietThuePhongDto> dataList = new ArrayList<>();
		try {
			String query = "select * from ChiTietThuePhong where ngayDen >= '" + from + "' and ngayDen <= '" + to + "'";
			ResultSet result = connection.Getdata(query);
			while (result.next()) {
				ChiTietThuePhongDto dto = new ChiTietThuePhongDto(result.getString(6), result.getString(1),
						result.getString(2), result.getDate(3), result.getDate(4), result.getFloat(5),
						result.getFloat(7));
				dataList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public int getTotalCustomer() {
		int total = 0;
		try {
			String query = "select distinct maKhachHang from ChiTietThuePhong";
			ResultSet result = connection.Getdata(query);
			while (result.next()) {
				total += 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
