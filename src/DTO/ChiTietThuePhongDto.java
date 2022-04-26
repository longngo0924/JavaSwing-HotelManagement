package DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class ChiTietThuePhongDto {
	private String maCTTP;
	private String maPhong;
	private String maKhachHang;
	private Date ngayDen;
	private Date ngayDi;
	private float tongTien;
	private float tienDichVu;

	public ChiTietThuePhongDto(String maCTTP, String maPhong, String maKhachHang, Date ngayDen, Date ngayDi,
			float tongTien, float tienDichVu) {
		super();
		this.maCTTP = maCTTP;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
		this.tongTien = tongTien;
		this.tienDichVu = tienDichVu;
	}

	public ChiTietThuePhongDto() {
		super();
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaCTTP() {
		return maCTTP;
	}

	public void setMaCTTP(String maCTTP) {
		this.maCTTP = maCTTP;
	}

	public float getTienDichVu() {
		return tienDichVu;
	}

	public void setTienDichVu(float tienDichVu) {
		this.tienDichVu = tienDichVu;
	}

	@Override
	public String toString() {
		return "ChiTietThuePhongDto [maCTTP=" + maCTTP + ", maPhong=" + maPhong + ", maKhachHang=" + maKhachHang
				+ ", ngayDen=" + ngayDen + ", ngayDi=" + ngayDi + ", tongTien=" + tongTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCTTP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietThuePhongDto other = (ChiTietThuePhongDto) obj;
		return Objects.equals(maCTTP, other.maCTTP);
	}

}
