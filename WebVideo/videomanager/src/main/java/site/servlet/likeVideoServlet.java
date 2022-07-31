package site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.FavoriteDao;
import model.favorite;
import model.users;
import model.videos;

/**
 * Servlet implementation class likeVideoServlet
 */
@WebServlet("/LikeVideo")
public class likeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!SessionUtils.islogin(req)) {
			resp.sendRedirect("Login");
			return;
		}
		String page = req.getParameter("page");
		String videoId = req.getParameter("videoid");
		if (videoId ==null) {
			resp.sendRedirect("/Homepage");
			return;
		}
		try {
			FavoriteDao dao = new FavoriteDao();
			favorite favorite = new favorite();
			videos video = new videos();
			video.setVideoid(videoId);
			favorite.setVideo(video);
			String username = SessionUtils.getLoginedUsername(req);
			users user = new users();
			user.setUsername(username);
			favorite.setUser(user);
			favorite.setLikedate(new Date());
			dao.insert(favorite);
			req.setAttribute("message", "Video is add to favorites");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}if (page ==null) {
			page="/Homepage";
		}
		
		req.getRequestDispatcher(page).forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
