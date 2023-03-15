package www.mywebsite.Controller.Admin;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import www.mywebsite.DTO.UserDTO;
import www.mywebsite.Service.UserService;
import www.mywebsite.Service.Impl.UserServiceImpl;

public class test {
	private UserService userdao = new UserServiceImpl();
	 @Test
	    public void testCong() {
	        List<UserDTO> list=userdao.findUserByVideoHref("CihmFK_vg_I");

	        assertEquals(2, list.size());
	    }
}
