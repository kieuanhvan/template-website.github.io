package www.mywebsite.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.FetchProfile.Item;

import net.bytebuddy.asm.Advice.Return;
import www.mywebsite.BEAN.User;
import www.mywebsite.DAO.UserDAO;
import www.mywebsite.DAO.impl.UserDAOImpl;
import www.mywebsite.DTO.UserDTO;
import www.mywebsite.Service.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO UserDAO;
	public UserServiceImpl() {
		UserDAO = new UserDAOImpl();
	}
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return UserDAO.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return UserDAO.findByEmail(email);
	}

	@Override
	public User findByUserName(String username) {
		return UserDAO.findByUserName(username);
	}

	@Override
	public User login(String username, String password) {
		return UserDAO.findByUserNameAndPassowrd(username, password);
	}

	@Override
	public User resetPassword(String email) {
		User user = UserDAO.findByEmail(email);
		if(user != null) {
			String newKey = createKey();
			user.setPassword(newKey);
			return UserDAO.update(user);
		}
		return null;
	}
	private String createKey() {
		int b = (int)(Math.random()*(9999-1000+1)+1000);  
		return String.valueOf(b);
	}

	@Override
	public List<User> findAll() {
		return UserDAO.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return UserDAO.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		User entity = new User();
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setEmail(email);
		entity.setIsAdmin(Boolean.FALSE);
		entity.setIsActive(Boolean.TRUE);
		return UserDAO.create(entity);
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return UserDAO.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = findByUserName(username);
		user.setIsActive(Boolean.FALSE);
		return UserDAO.update(user);
	}
	@Override
	public List<UserDTO> findUserByVideoHref(String href) {
		Map<String ,Object>map = new HashMap<>();
		map.put("f_href", href);
		List<User> users =UserDAO.findUserByVideoHref(map);
		System.out.println(users.size());
		List<UserDTO> userDTOs = new ArrayList<>();
		users.forEach(user -> {
			userDTOs.add(new UserDTO(user.getUsername() , user.getPassword()));
		});
		return userDTOs;
	}

}
