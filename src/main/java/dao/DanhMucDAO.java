package dao;

import java.util.List;

import model.DanhMuc;

public interface DanhMucDAO {
	public List<DanhMuc> getAllDanhMuc();
	
	public DanhMuc getDanhMuc(int maDanhMuc);
	
	public DanhMuc addDanhMuc(DanhMuc danhMuc);
	
	public DanhMuc updateDanhMuc(DanhMuc danhMuc);
}
