package gui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import navi.Controller;

public class MenueController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		List<String> hauptmenue;
		if(request.getParameter("untermenue") != null) {
			hauptmenue = FahrkartenController.getInstance().getMenue().getUntermenue();
//			request.setAttribute("Menue", null);
		}else {
			hauptmenue = FahrkartenController.getInstance().getMenue().getMenue();
		}
		request.setAttribute("menue", hauptmenue);
		
		return null;
	}

}
