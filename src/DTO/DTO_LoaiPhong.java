package DTO;

import java.util.Objects;

public class DTO_LoaiPhong {
	
	private String tenLoaiPhong;
	private float Gia;
	private String TienNghi;
	public DTO_LoaiPhong( String tenLoaiPhong, float gia, String tienNghi) {
		super();
		
		this.tenLoaiPhong = tenLoaiPhong;
		Gia = gia;
		TienNghi = tienNghi;
	}
	
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	public String getTienNghi() {
		return TienNghi;
	}
	public void setTienNghi(String tienNghi) {
		TienNghi = tienNghi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenLoaiPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTO_LoaiPhong other = (DTO_LoaiPhong) obj;
		return Objects.equals(tenLoaiPhong, other.tenLoaiPhong);
	}
	
	
}
