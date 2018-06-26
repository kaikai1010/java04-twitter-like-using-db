package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Twitter;
import model.TwitterGetListLogic;
import model.TwitterPostLogic;
import model.User;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwarded to main

		//utf-8
		String text = request.getParameter("text");

		if(text != null && text.length() != 0) {

			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("u");

			Twitter t = new Twitter(u.getName(), text);

			TwitterPostLogic tpLogic = new TwitterPostLogic();
			tpLogic.execute(t);
		}
		else {
			request.setAttribute("errorMsg", "Write Something, Please!");
		}

		TwitterGetListLogic tglLogic = new TwitterGetListLogic();
		List<Twitter> tList = tglLogic.execute();
		request.setAttribute("tList", tList);

		RequestDispatcher d =
			request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		d.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwarded to logout

		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher d =
			request.getRequestDispatcher("/WEB-INF/view/logout.jsp");
		d.forward(request, response);
	}
}
