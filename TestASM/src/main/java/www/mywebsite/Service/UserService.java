package www.mywebsite.Service;

import java.util.List;
import java.util.Map;

import www.mywebsite.BEAN.User;
import www.mywebsite.DTO.UserDTO;

public interface UserService {
	User findById(Long id);
	User findByEmail(String email);
	User findByUserName(String username);
	User login(String username,String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(int pageNumber , int pageSize);
	User create(String username,String passwordString , String email);
	User update(User entity);
	User delete(String username);
	
	List<UserDTO>findUserByVideoHref ( String href);
	
}
