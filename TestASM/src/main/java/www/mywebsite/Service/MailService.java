package www.mywebsite.Service;

import javax.servlet.ServletContext;

import www.mywebsite.BEAN.User;

public interface MailService {
	void  SendGmail(ServletContext context , User recipient , String type);
}
