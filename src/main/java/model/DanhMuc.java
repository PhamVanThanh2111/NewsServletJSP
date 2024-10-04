package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DANHMUC")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MADM")
	private int maDanhMuc;
	@Column(name = "TENDANHMUC", columnDefinition = "NVARCHAR(255)")
	private String tenDanhMuc;
	@Column(name = "NGUOIQUANLY", columnDefinition = "NVARCHAR(255)")
	private String nguoiQuanLy;
	@Column(name = "GHICHU", columnDefinition = "NVARCHAR(255)")
	private String ghiChu;
	public DanhMuc() {
		super();
	}
	
	public DanhMuc(String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		super();
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public DanhMuc(int maDanhMuc, String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "DanhMuc [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + ", nguoiQuanLy=" + nguoiQuanLy
				+ ", ghiChu=" + ghiChu + "]";
	}
}
