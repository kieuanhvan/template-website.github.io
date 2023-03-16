package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import BEAN.Favourite;
import JpaDB.JpaUtils;

public class ManagerFavouriteDAO implements SystemInterface<Favourite, Integer>{
	EntityManager em =JpaUtils.getManagerFactory();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	@Override
	public boolean insert(Favourite entity) {

		return false;
	}

	@Override
	public boolean update(Favourite entity) {

		return false;
	}

	@Override
	public boolean delete(Favourite entity) {

		return false;
	}

	@Override
	public List<Favourite> getAll() {

		return null;
	}

	@Override
	public Favourite findById(Integer key) {

		return null;
	}

}
