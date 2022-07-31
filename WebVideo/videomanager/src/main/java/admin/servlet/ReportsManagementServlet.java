package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import dao.FavoriteDao;
import dao.ShareDao;
import dao.VideoDao;
import domain.FavoriteReport;
import domain.FavoriteUserReport;
import domain.reportsharebyvideos;
import model.videos;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/admin/ReportsManagement")
@MultipartConfig
public class ReportsManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reportFavoritesByVideos(req, resp);
		reportFavoriteUsersByVideos(req, resp);
		reportsharessByVideos(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.REPORT_MANAGEMENT_PAGE);
		}


	protected void reportFavoritesByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			req.setAttribute("favlist", list);
			System.out.print(list);
		} catch (Exception e) {
			req.setAttribute("error", "error: "+ e.getMessage());
		}
	}
	protected void reportFavoriteUsersByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String videoUserid =req.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<videos> vlist = vdao.findAll();
			if (videoUserid ==null && vlist.size()>0) {
				videoUserid = vlist.get(0).getVideoid();
			}
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideos(videoUserid);
			req.setAttribute("videoUserId", videoUserid);
			req.setAttribute("vidlist", vlist);
			req.setAttribute("favUsers", list);

			System.out.print(list);
		} catch (Exception e) {
			req.setAttribute("error", "error: "+ e.getMessage());
		}
	}
	protected void reportsharessByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String videoUserid =req.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<videos> vlist = vdao.findAll();
			if (videoUserid ==null && vlist.size()>0) {
				videoUserid = vlist.get(0).getVideoid();
			}
			ShareDao dao = new ShareDao();
			List<reportsharebyvideos> list = dao.reportsharebyvideos(videoUserid);
			req.setAttribute("videoUserId", videoUserid);
			req.setAttribute("vidlist", vlist);
			req.setAttribute("shavUsers", list);
			System.out.print(list);
		} catch (Exception e) {
			req.setAttribute("error", "error: "+ e.getMessage());
		}
	}
}
