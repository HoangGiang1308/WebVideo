package site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import dao.VideoDao;
import model.users;
import model.videos;

/**
 * Servlet implementation class HomepageServlet
 */
@WebServlet({"/Homepage","/LibaryVideoServlet","/SearchServlet"})
public class HomepageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");	
		fillAll(req, resp);
			String uri = req.getRequestURI();
			
			try {
		          if(uri.contains("LibaryVideoServlet")) {
		            	libaryVideo(req, resp);
		            }
		          if(uri.contains("SearchServlet")) {
		            	search(req, resp);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            req.setAttribute("error", e.getMessage());
		        }
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);

	}

	protected static void fillAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title") == null ? "%%" : req.getParameter("title");
		String page = req.getParameter("page") == null ? "1" : req.getParameter("page");
		VideoDao vd = new VideoDao();
		users user = (users) req.getSession().getAttribute("user");
		try {
			List<videos> videos = vd.findAll(title, 12 * (Integer.valueOf(page)) - 11,
					12 * (Integer.valueOf(page)) - 11 + 11);
			req.setAttribute("videos", videos);
			req.setAttribute("size", Math.ceil(vd.findByTitle(title).size() / 12.0));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		VideoDao vd = new VideoDao();
		List<videos> videos = vd.query(
				"select o from videos o where (videoid like :n or title like :n) and cast(o.id as int) >= 1 and cast(o.id as int) <= 10",
				title);

		req.setAttribute("videos", videos);
		req.setAttribute("size", Math.ceil(vd.findAll().size() / 10.0));
		
		PageInfo.prepareAndForward(req, resp, PageType.SITE_HOME_PAGE);
	}
	
    protected void libaryVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("videoid");
        try {
            VideoDao dao = new VideoDao();
            List<videos> list = dao.findByTitleOrId(title);
            request.setAttribute("videos", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }
    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        try {
            VideoDao dao = new VideoDao();
            List<videos> list = dao.findByTitleOrId(keyword);
            request.setAttribute("videos", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }
    }
}
