package DTO;



public class DTO_Phong {
	 private String maPhong;
	 private String tangPhong;
	 private String loaiphong;
	 private boolean trangThai;
	 private String ghiChu;
	 
	public DTO_Phong(String maPhong, String tangPhong, String loaiphong, boolean trangThai, String ghiChu) {
		super();
		this.maPhong = maPhong;
		this.tangPhong = tangPhong;
		this.loaiphong = loaiphong;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTangPhong() {
		return tangPhong;
	}
	public void setTangPhong(String tangPhong) {
		this.tangPhong = tangPhong;
	}
	public String getLoaiphong() {
		return loaiphong;
	}
	public void setLoaiphong(String loaiphong) {
		this.loaiphong = loaiphong;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	 
	 
}
