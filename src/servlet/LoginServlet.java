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
import model.User;
import model.UserLoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwarded to loginResult

		//utf-8
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User u = new User(name, pass);
		UserLoginLogic ulLogic = new UserLoginLogic();
		boolean isLogin = ulLogic.execute(u);

		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
		}

		RequestDispatcher d =
			request.getRequestDispatcher("/WEB-INF/view/loginResult.jsp");
		d.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwarded to main

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");

		if(u == null) {
			response.sendRedirect("/twitter-like-using-db/");
		}
		else {

			TwitterGetListLogic tglLogic = new TwitterGetListLogic();
			List<Twitter> tList = tglLogic.execute();
			request.setAttribute("tList", tList);

			RequestDispatcher d =
					request.getRequestDispatcher("/WEB-INF/view/main.jsp");
			d.forward(request, response);
		}
	}
}
