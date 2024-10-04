package test;
import dao.TinTucDAO;
import daoimpl.TinTucDAOImpl;
import jakarta.persistence.Persistence;

public class TestMain {
	public static void main(String[] args) {
		TinTucDAO tinTucDAO = new TinTucDAOImpl(Persistence.createEntityManagerFactory("tinTucPU"));
		tinTucDAO.deleteTinTuc(4);
		System.out.println(tinTucDAO.getAllTinTuc());
	}
}
