package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import navi.Controller;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String benutzername = request.getParameter("Benutzername");
			String passwort = request.getParameter("Passwort");
			if(benutzername.equals("123") && passwort.equals("123")) {
				request.getSession().setAttribute("eingeloggt", "ja");
				new ServiceController().execute(request, response, message);
				return "/service";
			}
		}
		return null;
	}
}
