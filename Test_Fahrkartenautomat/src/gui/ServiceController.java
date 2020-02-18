package gui;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import navi.Controller;

public class ServiceController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		Map<Double, Integer> fuellstand = FahrkartenController.getInstance().getFinanzen().getFuellstand();
		request.setAttribute("fuellstand", fuellstand);
		List<Double> faecher = FahrkartenController.getInstance().getFinanzen().getAkzeptiertesgeld();
		request.setAttribute("faecher", faecher);
		String addOderSub = request.getParameter("auffuellenOderLeeren");
		String anzahl = request.getParameter("anzahl");
		String fach = request.getParameter("welchesFach");
//		FahrkartenController.getInstance().getService().pruefen(fach, anzahl, addOderSub);
		return null;
	}

}
