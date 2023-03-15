package www.mywebsite.DAO.impl;

import java.util.List;
import java.util.Map;

import www.mywebsite.BEAN.User;
import www.mywebsite.DAO.SystemDAO;
import www.mywebsite.DAO.UserDAO;

public class UserDAOImpl  extends SystemDAO<User> implements UserDAO{

	@Override
	public User findById(Long id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where o.email = ?0";
		return super.findOne(User.class, sql, new Object[] {email});
	}

	@Override
	public User findByUserNameAndPassowrd(String username, String password) {
		String sql = "select o from User o where o.username = ?0 and o.password = ?1";
		return super.findOne(User.class, sql, new Object[] {username ,password});
	}

	@Override
	public List<User> findAll() {
		return super.FindAll(User.class, true);
	}

	@Override
	public User create(User entity) {

		return super.create(entity);
	}

	@Override
	public User update(User entity) {
		return super.update(entity);
	}

	@Override
	public User delete(User entity) {
		return super.delete(entity);
	}

	@Override
	public User findByUserName(String username) {
		String sql = "select o from User o where o.username = ?0";
		return super.findOne(User.class, sql, new Object[] {username});
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.FindAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUserByVideoHref(Map<String, Object> data) {
		return super.procedureGetMany("findUsersByHref", data);
	}

}
