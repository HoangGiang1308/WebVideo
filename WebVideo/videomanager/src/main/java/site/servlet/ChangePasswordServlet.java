package site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.UserDao;
import domain.ChangePasswordForm;
import model.users;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(req);
		if (username ==null) {
			req.getRequestDispatcher("/login").forward(req, resp);
			return;
		}
		req.setAttribute("username", username);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(req);
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, req.getParameterMap());
			req.setAttribute("username", username);
			if (!form.getConfirmPassword().equals(form.getPassword())) {
				req.setAttribute("error", "new password and new confirm password are not identical");
			}else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
				req.setAttribute("message", "Passwoed has been changed");
				System.out.print(form.getConfirmPassword());

			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}
