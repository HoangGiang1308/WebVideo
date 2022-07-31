package site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.CookieUtils;
import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.UserDao;
import domain.LoginForm;
import model.users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = CookieUtils.get("username", req);
		if (username == null) {
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);			
			return;
		}
		SessionUtils.add(req, "username", username);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			
			BeanUtils.populate(form, req.getParameterMap());
			
			UserDao dao = new UserDao();
			users users = dao.findById(form.getUsername());
			
			if(users!= null	&& users.getPassword().equals(form.getPassword())) {
				SessionUtils.add(req, "username", users.getUsername());
				
				if (form.isRemmerber()) {
					CookieUtils.add("username", form.getUsername(), 24, resp);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, resp);
				}
				req.setAttribute("islogin", true);
				req.setAttribute("username", users.getFullname());
				if(users.getadmin()) {
					PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);			
					return;
				}
				else {	
					req.getRequestDispatcher("/Homepage").forward(req, resp);
					return;
				}
			}
			System.out.print(users);
			req.setAttribute("error", "invalid username or password");
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);			
	}
}
