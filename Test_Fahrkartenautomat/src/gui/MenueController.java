package gui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import navi.Controller;

public class MenueController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message) throws Exception {
		
		List<String> hauptmenue;
		int auswahl;
		if(request.getParameter("auswahl") == null) {
			auswahl = -1;
		}else {
			auswahl = Integer.parseInt(request.getParameter("auswahl"));
		}

		if(auswahl == 9) {
			hauptmenue = FahrkartenController.getInstance().getMenue().getUntermenue();
		}else{
			request.setAttribute("auswahl", auswahl);
			hauptmenue = FahrkartenController.getInstance().getMenue().getMenue();
		}
		request.setAttribute("menue", hauptmenue);
		
		return null;
	}

}
