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
import model.videos;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoId = req.getParameter("videoid");
		int tai=5;
			try {
				VideoDao dao = new VideoDao();
				videos video = dao.findById(videoId);
				List<videos> list = dao.findAll();
				
				req.setAttribute("videos", list);
				req.setAttribute("video", video);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", e.getMessage());
			}
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_VIDEO_DETAIL_PAGE);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
