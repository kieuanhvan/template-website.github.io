package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BEAN.User;
import JpaDB.JpaUtils;


public class ManagerUserDAO  implements SystemInterface<User, Long>{
	EntityManager em =JpaUtils.getManagerFactory();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	
	@Override
	public boolean insert(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		try {
			TypedQuery<User> query= em.createNamedQuery("User.findUserById", User.class);
			query.setParameter("idInput", id);
			return query.getSingleResult();
		} catch (Exception e) {	
			return null;
		}

	}

}
