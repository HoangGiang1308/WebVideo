package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import common.UploadUtils;
import dao.UserDao;
import dao.VideoDao;
import model.users;
import model.videos;

/**
 * Servlet implementation class UsersMangementServlet
 */
@WebServlet({"/admin/UsersMangement","/admin/UsersMangement/create",
	"/admin/UsersMangement/update","/admin/UsersMangement/delete",
	"/admin/UsersMangement/reset","/admin/UsersMangement/edit"})
public class UsersMangementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("edit")){
			edit(req,resp);
			return;
		}
		if(url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		users user = new users();
		findall(req,resp);
		req.setAttribute("user", user);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void findall(HttpServletRequest req, HttpServletResponse resp) {
		try {
			UserDao dao = new UserDao();
			List<users> list = dao.findAll();
			req.setAttribute("users", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		users video = new users();
		findall(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if (username == null) {
			req.setAttribute("error", "user id is required");
			PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			users user = dao.findById(username);			
			if (user == null) {
				req.setAttribute("error", "user is not found");
				PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(username);
			req.setAttribute("message", "user is deleted");
			req.setAttribute("user", new users());
			findall(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if (username == null) {
			req.setAttribute("error", "username id is required");
			PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			users user = dao.findById(username);
			req.setAttribute("user", user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("create")){
			create(req,resp);
			return;
		}
		
		if(url.contains("update")){
			update(req, resp);
			return;
		}
		if(url.contains("delete")) {
			create(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		users user = new users();
		req.setAttribute("user", user);
		findall(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		users user = new users();
		try {
			
			
			BeanUtils.populate(user, req.getParameterMap());
			
			UserDao dao = new UserDao();
			
			users olduser = dao.findById(user.getUsername());
			user.setUsername(olduser.getUsername());
			dao.update(user);
			System.out.print(user.getadmin());

			req.setAttribute("message", "User profile updated");
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		users user= new users();
		try {
			BeanUtils.populate(user, req.getParameterMap());
						
			user.setAdmin(Boolean.valueOf(req.getParameter("admin")));
			
			UserDao dao = new UserDao();
			dao.insert(user);
			req.setAttribute("user", user);
			req.setAttribute("message", "User is inserted");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error","error" +e.getMessage());
			// TODO: handle exception
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
		
	}

}
