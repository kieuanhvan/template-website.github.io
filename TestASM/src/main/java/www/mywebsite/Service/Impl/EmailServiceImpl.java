package www.mywebsite.Service.Impl;

import javax.servlet.ServletContext;

import www.mywebsite.BEAN.User;
import www.mywebsite.Service.MailService;
import www.mywebsite.Utils.SendEmailUtil;

public class EmailServiceImpl implements MailService {

	private static final String EEMAIL_WELCOME_SUBJECT = "Wellcome youtube";
	private static final String EEMAIL_WELCOME_PASSWORD = "Wellcome youtube";

	@Override
	public void SendGmail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");

		try {
			String content = null;
			String subject = null;

			switch (type) {
			case "welcome":
				subject =  EEMAIL_WELCOME_SUBJECT;
				content = "DEAR " + recipient.getUsername() + " hope you a good time !";
				break;
			case "forgot":
				subject =  EEMAIL_WELCOME_PASSWORD;
				content = "DEAR " + recipient.getUsername() + " your password here : "+recipient.getPassword();
				break;
				default:
					subject =  "error";
					content = "DEAR fuck";
					break;
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
