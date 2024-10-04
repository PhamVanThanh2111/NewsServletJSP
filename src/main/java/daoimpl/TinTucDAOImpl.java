package daoimpl;

import java.util.List;

import dao.TinTucDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.TinTuc;

public class TinTucDAOImpl implements TinTucDAO {

	private EntityManager entityManager;
	
	public TinTucDAOImpl(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		entityManager = emf.createEntityManager();
	}
	@Override
	public List<TinTuc> getAllTinTuc() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from TinTuc", TinTuc.class).getResultList();
	}

	@Override
	public TinTuc getTinTuc(int maTinTuc) {
		// TODO Auto-generated method stub
		return entityManager.find(TinTuc.class, maTinTuc);
	}

	@Override
	public TinTuc addTinTuc(TinTuc tinTuc) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(tinTuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
		return tinTuc;
	}

	@Override
	public TinTuc updateTinTuc(TinTuc tinTuc) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(tinTuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
		return tinTuc;
	}
	@Override
	public void deleteTinTuc(int maTinTuc) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			TinTuc tinTuc = entityManager.find(TinTuc.class, maTinTuc);
			entityManager.remove(tinTuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
	}

}
