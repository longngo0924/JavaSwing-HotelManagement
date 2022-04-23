package DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Connect.ConnectionDB;





public class DAO_KhachHang {
	
	private static ConnectionDB con =new ConnectionDB();
	public DAO_KhachHang(){
		
	}
    public static ResultSet laydulieuKH() {
        String cautruyvan = "SELECT [makh] "
                + "      ,[tenkh] "
                + "      ,[CMND] "
                + "      ,[diachi] "
                + "      ,[sdt] "
                + "      ,[gioitinh] "
                + "      ,[tuoi] "
                + "      ,[email] "
                + "  FROM [dbo].[KhachHang]";
        try {
			return con.Getdata(cautruyvan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

    }

    public static void themKH(DTO.DTO_KhachHang kh, String maKH) {
    	String gioitinh= (kh.isGioiTinh()==true)?"1":"0";
        String cautruyvan =  "insert into dbo.KhachHang"
                + "(makh,"
                + "tenkh,"
                + "CMND,"
                + "diachi,"
                + "sdt,"
                + "gioitinh,"
                + "tuoi,"
                + "email)\r\n"
                + "values ('"+kh.getMakh()+"',"
                + " N'"+kh.getTenkh() +" ',"
                + "'"+kh.getCMND()+"',"
                + "'"+kh.getDiaCHi()+"',"
                + "'"+kh.getSdt() +"',"
                + ""+gioitinh+","
                + ""+kh.getTuoi()+","
                + "'"+kh.getEmail()+"'"
                + ") ";
        int kq = con.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            JOptionPane.showMessageDialog(null, "Thành công");
        } else {
        	  JOptionPane.showMessageDialog(null, "Thất bại");
        }
    }

   /* public static void xoaKH(int maKH) {
        String cautruyvan = "DELETE FROM [dbo].[KH] "
                + "      WHERE maKH=" + maKH;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
          //  thongbao.thongbao("xóa thành công", "thông báo");
        } else {
        }
    }
	*/
   /* public static void suaKH(DTO.DTO_KhachHang kh_sua, String maloaiKH, String maKH) {
        String cautruyvan = "UPDATE [dbo].[KH] "
                + "   SET [maloaiKH] =  " + maloaiKH
                + "      ,[tenKH] = N'" + kh_sua.getTenKH() + "' "
                + "      ,[tuoi] =  " + kh_sua.getTuoi()
                + "      ,[gioitinh] = N'" + kh_sua.getGioitinh() + "' "
                + "      ,[sdt] = '" + kh_sua.getSdt() + "' "
                + "      ,[soCMND] =N'" + kh_sua.getCMND() + "' "
                + "      ,[ghichu] = N'' "
                + " WHERE maKH=" + maKH;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("sửa thành công", "thông báo");
        } else {
        }
    }
*/
   /* public static ResultSet timkiemKH(String tukhoa) {
        String cautruyvan = "SELECT [maKH] "
                + "      ,[maloaiKH] "
                + "      ,[tenKH] "
                + "      ,[tuoi] "
                + "      ,[gioitinh] "
                + "      ,[sdt] "
                + "      ,[soCMND] "
                + "      ,[ghichu] "
                + "  FROM [dbo].[KH] "
                + "  where tenKH like N'%" + tukhoa + "%'";
        return connection.Getdata(cautruyvan);
    }
//    ----------------------------------------------------------

    public static ResultSet LoaiKH() {
        String cautruyvan = "SELECT *FROM [dbo].[loaiKH]";
        return connection.Getdata(cautruyvan);
    }

    public static void themLOaiKH(String tenLoai, String mota) {
        String cautruyvan = "INSERT INTO [dbo].[loaiKH] "
                + "           ([tenloaiKH] "
                + "           ,[mota]) "
                + "     VALUES "
                + "           (N'" + tenLoai + "', "
                + "           N'" + mota + "')";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("thêm thành công", "thông báo");
        } else {
        }
    }

    public static void xoaLoaiKH(int maLOai) {
        String cautruyvan = "DELETE FROM [dbo].[loaiKH] "
                + "      WHERE maloaiKH=" + maLOai;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("xóa thành công", "thông báo");
        } else {
        }
    }

    public static void updateLoai(int malOai, String tenLoai, String mota) {
        String cautruyvan = "UPDATE [dbo].[loaiKH] "
                + "   SET [tenloaiKH] = N'"+tenLoai+"' "
                + "      ,[mota] =N'"+mota+"' "
                + " WHERE maloaiKH="+malOai;
        int kq=connection.ExecuteTruyVan(cautruyvan);
        if (kq>0) {
            thongbao.thongbao("Sửa thành công", "thông báo");
        }else{
        
        }
    }*/
}
