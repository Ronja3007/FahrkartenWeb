package gui;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import logik.GeldSachen;
import logik.ValidierungsException;
import navi.Controller;

public class ServiceController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		List<Double> faecher = FahrkartenController.getInstance().getFinanzen().getAkzeptiertesgeld();
		request.setAttribute("faecher", faecher);
		
		int maxScheine = GeldSachen.getMaxanzahlscheine();
		int maxMuenzen = GeldSachen.getMaxanzahlmuenzen();
		request.setAttribute("maxzahlScheine", maxScheine);
		request.setAttribute("maxzahlMuenzen", maxMuenzen);
		
		String addOderSub = request.getParameter("auffuellenOderLeeren");
		String anzahl = request.getParameter("anzahl");
		String fach = request.getParameter("welchesFach");
		Map<Double, Integer> fuellstand = getFuellstand();
		request.setAttribute("fuellstand", fuellstand);
		if(anzahl != null) {
			FahrkartenController.getInstance().getService().pruefen(fach, anzahl, addOderSub);
			fuellstand = getFuellstand();
			request.setAttribute("fuellstand", fuellstand);
		}
		return null;
	}

	private Map<Double, Integer> getFuellstand() throws ValidierungsException {
		return FahrkartenController.getInstance().getFinanzen().getFuellstand();
	}
}