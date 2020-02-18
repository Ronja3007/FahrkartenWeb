package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import logik.ValidierungsException;
import navi.Controller;

public class EinZahlenController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message) throws Exception {
	
		try {
			double eingezahltBetrag = Double.parseDouble(request.getParameter("eingezahltBetrag"));
			
			FahrkartenController.getInstance().getFinanzen().betragPruefen(eingezahltBetrag, Double.parseDouble(request.getParameter("preisEinzahlen")));
			int auswahl = Integer.parseInt(request.getParameter("auswahl"));
			request.setAttribute("auswahl", auswahl);
			
			request.setAttribute("einzahlen", true);
			
			new ZahlenController().execute(request, response, message);
			return "/zahlen";
		}catch (ValidierungsException v) {
			throw new Exception(v.getMessage());
		}
	}
}