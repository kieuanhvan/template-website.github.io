package www.mywebsite.DAO;


import java.util.List;
import java.util.Map;

import www.mywebsite.BEAN.User;

public interface UserDAO {
	User findById(Long id);
	User findByEmail(String email);
	User findByUserName(String username);
	User findByUserNameAndPassowrd(String username,String password);
	
	List<User> findAll();
	List<User> findAll(int pageNumber , int pageSize);
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	
	List<User>findUserByVideoHref ( Map<String,Object> data);
}
