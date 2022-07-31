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
import dao.UserDao;
import model.users;

/**
 * Servlet implementation class registServlet
 */
@WebServlet("/registration")
public class registServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_regist_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		users user = new users();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			UserDao dao = new UserDao();
			dao.insert(user);
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_regist_PAGE);
	}

}
