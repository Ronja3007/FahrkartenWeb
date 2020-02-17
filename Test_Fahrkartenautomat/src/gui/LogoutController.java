package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import navi.Controller;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		request.getSession().invalidate();
		request.getSession().setAttribute("eingeloggt", null);
		new LoginController().execute(request, response, message);
		return "/login";
	}
}
