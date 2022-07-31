package site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmailUtils;
import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.ShareDao;
import dao.UserDao;
import domain.Email;
import model.shares;
import model.users;
import model.videos;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!SessionUtils.islogin(req)) {
			resp.sendRedirect("Login");
			return;
		}
		String videoId = req.getParameter("videoid");
		if (videoId ==null) {
			resp.sendRedirect("/Homepage");
			return;
		}
		req.setAttribute("videoid", videoId);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_SHARE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAdress = req.getParameter("email");
			String videoId = req.getParameter("videoid");
			if (videoId == null) {
				req.setAttribute("error", "Username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("buitantai2704@gmail.com");
				email.setFrompassword("48288353");
				email.setTo(emailAdress);
				email.setSubject("Share Favorite Video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Ms/Mr. <br>");
				sb.append("The video is more interesting and I want to share with you <br>");
				sb.append("Please click the link").append(String.format("<a href=''>View Video</a><br>", videoId));
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				ShareDao dao = new ShareDao();
				shares share = new shares();
				share.setEmail(emailAdress);
				share.setSharedate(new Date());
				String username = SessionUtils.getLoginedUsername(req);
				users user = new users();
				user.setUsername(username);
				share.setUser(user);
				videos video = new videos();
				video.setVideoid(videoId);
				share.setVideo(video);
				dao.insert(share);
				req.setAttribute("message", "Email sent to  the mail Address. Please check and get your password");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_SHARE_PAGE);

	}

	}

