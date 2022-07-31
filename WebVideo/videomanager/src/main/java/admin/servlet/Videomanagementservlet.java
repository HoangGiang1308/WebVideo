package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.UploadUtils;
import dao.VideoDao;
import model.videos;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet({"/admin/VideoManagement","/admin/VideoManagement/create",
	"/admin/VideoManagement/update","/admin/VideoManagement/delete",
	"/admin/VideoManagement/reset","/admin/VideoManagement/edit"})
@MultipartConfig
public class Videomanagementservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
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
		videos video = new videos();
		findall(req,resp);
		video.setPoster("images/daonhat.jpg");
		req.setAttribute("video", video);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
		}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoid");
		if (id == null) {
			req.setAttribute("error", "video id is required");
			PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			videos video = dao.findById(id);			
			if (video == null) {
				req.setAttribute("error", "video is not found");
				PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			req.setAttribute("message", "video is deleted");
			req.setAttribute("video", new videos());
			findall(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		videos video = new videos();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			VideoDao dao = new VideoDao();
			videos oldvideo = dao.findById(video.getVideoid());
			if (req.getPart("cover").getSize()==0) {
				video.setPoster(oldvideo.getPoster());
			}
			else {
				video.setPoster("uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoid()));
			}
			dao.update(video);
			req.setAttribute("video", video);
			req.setAttribute("message", "video is updated!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);

	}
	private void findall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDao dao = new VideoDao();
			List<videos> list = dao.findAll();
			req.setAttribute("videos", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("videoid");
		if (id == null) {
			req.setAttribute("error", "video id is required");
			PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			videos video = dao.findById(id);
			req.setAttribute("video", video);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "error: "+e.getMessage());
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
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
		videos video = new videos();
		video.setPoster("images/daonhat.jpg");
		req.setAttribute("video", video);
		findall(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		videos video = new videos();
		video.setPoster("images/daonhat.jpg");
		findall(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
	}
	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		videos video= new videos();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			
			video.setPoster("uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoid()));
			
			video.setAcitve(Boolean.valueOf(req.getParameter("active")));
			
			VideoDao dao = new VideoDao();
			dao.insert(video);
			req.setAttribute("video", video);
			System.out.print(req.getParameter("active"));
			System.out.print(video.getActive());
			req.setAttribute("message", "Video is inserted");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error","error" +e.getMessage());
			// TODO: handle exception
		}
		findall(req,resp);
		PageInfo.prepareAndForward(req, resp, PageType.Video_MANAGEMENT_PAGE);
		
	}

}
