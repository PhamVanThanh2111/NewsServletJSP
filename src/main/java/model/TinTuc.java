package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TINTUC")
public class TinTuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATT")
	private int maTinTuc;
	
	@Column(name = "TIEUDE", columnDefinition = "NVARCHAR(255)")
	@NotNull(message = "Tiêu đề không được để trống!")
	@NotEmpty(message = "Tiêu đề không được để trống!")
	private String tieuDe;
	
	@Column(name = "NOIDUNGTT", columnDefinition = "NVARCHAR(255)")
	@NotNull(message = "Nội dung tin tức không được để trống!")
	@NotEmpty(message = "Nội dung tin tức không được để trống!")
	@Size(max = 255, message = "Nội dung tin tức không được quá 255 ký tự!")
	private String noiDungTinTuc;
	
	@Column(name = "LIENKET", columnDefinition = "NVARCHAR(255)")
	@NotNull(message = "Liên kết không được để trống!")
	@NotEmpty(message = "Liên kết không được để trống!")
	private String lienKet;
	
	@Column(name = "MADM")
	@NotNull
	private int maDanhMuc;

	public TinTuc() {
		super();
	}

	public TinTuc(String tieuDe, String noiDungTinTuc, String lienKet, int maDanhMuc) {
		super();
		this.tieuDe = tieuDe;
		this.noiDungTinTuc = noiDungTinTuc;
		this.lienKet = lienKet;
		this.maDanhMuc = maDanhMuc;
	}

	public TinTuc(int maTinTuc, String tieuDe, String noiDungTinTuc, String lienKet, int maDanhMuc) {
		super();
		this.maTinTuc = maTinTuc;
		this.tieuDe = tieuDe;
		this.noiDungTinTuc = noiDungTinTuc;
		this.lienKet = lienKet;
		this.maDanhMuc = maDanhMuc;
	}

	public int getMaTinTuc() {
		return maTinTuc;
	}

	public void setMaTinTuc(int maTinTuc) {
		this.maTinTuc = maTinTuc;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTinTuc() {
		return noiDungTinTuc;
	}

	public void setNoiDungTinTuc(String noiDungTinTuc) {
		this.noiDungTinTuc = noiDungTinTuc;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
}
