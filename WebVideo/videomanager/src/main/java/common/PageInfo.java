package common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE,new PageInfo("User Management", "/admin/user/user.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE,new PageInfo("Reports", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.Video_MANAGEMENT_PAGE,new PageInfo("Videos", "/admin/videos/video.jsp", null));
	
		pageRoute.put(PageType.SITE_HOME_PAGE,new PageInfo("HOME PAGE", "/site/home/home.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE,new PageInfo("Login", "/site/user/login.jsp", null));
		pageRoute.put(PageType.SITE_regist_PAGE,new PageInfo("Registrion", "/site/user/registration.jsp", null));
		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE,new PageInfo("Change Password", "/site/user/change-password.jsp", null));
		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE,new PageInfo("Edit Profile", "/site/user/edit-profile.jsp", null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE,new PageInfo("Forgot Password", "/site/user/forgot-password.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE,new PageInfo("Favorite", "/site/videos/favorite.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE,new PageInfo("Video Detail", "/site/videos/detail.jsp", null));
		pageRoute.put(PageType.SITE_SHARE_PAGE,new PageInfo("Share", "/site/videos/share.jsp", null));
	}
	public static void prepareAndForward(HttpServletRequest req, HttpServletResponse resp, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
	public static void prepareAndForwardSite(HttpServletRequest req, HttpServletResponse resp, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/site/layout.jsp").forward(req, resp);
	}
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
}
