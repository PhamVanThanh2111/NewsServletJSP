package dao;

import java.util.List;

import model.TinTuc;

public interface TinTucDAO {
	public List<TinTuc> getAllTinTuc();
	
	public TinTuc getTinTuc(int maTinTuc);
	
	public TinTuc addTinTuc(TinTuc tinTuc);
	
	public TinTuc updateTinTuc(TinTuc tinTuc);
	
	public void deleteTinTuc(int maTinTuc);
}
