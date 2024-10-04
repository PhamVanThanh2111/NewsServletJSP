package daoimpl;

import java.util.List;

import dao.DanhMucDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.DanhMuc;

public class DanhMucDAOImpl implements DanhMucDAO {

	private EntityManager entityManager;
	
	public DanhMucDAOImpl(EntityManagerFactory emf) {
		entityManager = emf.createEntityManager();
	}
		
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from DanhMuc", DanhMuc.class).getResultList();
	}

	@Override
	public DanhMuc getDanhMuc(int maDanhMuc) {
		// TODO Auto-generated method stub
		return entityManager.find(DanhMuc.class, maDanhMuc);
	}

	@Override
	public DanhMuc addDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(danhMuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
		return danhMuc;
	}

	@Override
	public DanhMuc updateDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(danhMuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
		return danhMuc;
	}

}
