package www.mywebsite.Utils;


import java.io.File;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class SendEmailUtil {
	 public static void sendEmail(String host, String port,
	            final String userName, final String password, String toAddress,
	            String subject, String message) throws AddressException,
	            MessagingException {
	 
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");

	        properties.setProperty("mail.transport.protocol", "smtp");

	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.starttls.port", "587");

	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        msg.setText(message);
	 
	        // sends the e-mail
	        Transport.send(msg);
	 
	    }
	 
		public static boolean uploadFile(HttpServletRequest request , HttpServletResponse response ) {
			try {
				File file = new File(request.getServletContext().getRealPath("/assets"));
				if(!file.exists()) {
					file.mkdir();
				}
				Part image = request.getPart("image");
				
				File imageFile = new File(file,image.getSubmittedFileName());
				
				image.write(imageFile.getAbsolutePath());
				System.out.println(request.getServletContext().getRealPath("/assets") + imageFile.getName());

				return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
			}
		}
}
