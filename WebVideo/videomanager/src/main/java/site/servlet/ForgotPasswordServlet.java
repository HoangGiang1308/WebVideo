package site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmailUtils;
import common.PageInfo;
import common.PageType;
import dao.UserDao;
import domain.Email;
import model.users;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAdress = req.getParameter("email");
			String username = req.getParameter("username");
			UserDao dao = new UserDao();
			users user = dao.findByUserNameAndEmail(username, emailAdress);
			if (user == null) {
				req.setAttribute("error", "Username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("buitantai2704@gmail.com");
				email.setFrompassword("48288353");
				email.setTo(emailAdress);
				email.setSubject("forgot Passowrd Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear").append(username).append("<br>");
				sb.append("You are used the forgot password function.<br>");
				sb.append("Your Password is <b>").append(user.getPassword()).append("<b><br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				req.setAttribute("message", "Email sent to  the mail Address. Please check and get your password");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_FORGOT_PASSWORD_PAGE);

	}

}
