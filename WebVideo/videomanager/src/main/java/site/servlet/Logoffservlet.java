package site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CookieUtils;
import common.SessionUtils;

/**
 * Servlet implementation class Logoffservlet
 */
@WebServlet("/Logoff")
public class Logoffservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtils.add("username", null, 0,resp);
		SessionUtils.invalidate(req);
		req.setAttribute("islogin", false);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}
	
}
