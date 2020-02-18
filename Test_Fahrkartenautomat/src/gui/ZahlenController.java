package gui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import navi.Controller;

public class ZahlenController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception{
		
		double preis = -1;
		double eingezahlt = -1;

		List<Double> preise = FahrkartenController.getInstance().getFinanzen().getPreise();
		
		int auswahl = Integer.parseInt(request.getParameter("auswahl"));
		
		request.setAttribute("auswahl", auswahl);
		
		String ueberschrift = FahrkartenController.getInstance().getFinanzen().getListeTickets().get(auswahl-1);
		request.setAttribute("ueberschrift", ueberschrift);
		
		preis = preise.get(auswahl-1);
		request.setAttribute("preis", preis + "0");
		
		eingezahlt = FahrkartenController.getInstance().getFinanzen().getEingezahlt(); 
		request.setAttribute("eingezahlt", eingezahlt + "0");
		
		double fehlenderBetrag = FahrkartenController.getInstance().getFinanzen().getFehlendesGeld(preis);
		request.setAttribute("fehlenderBetrag", fehlenderBetrag + "0");
		
		double rueckgeld = FahrkartenController.getInstance().getFinanzen().getRueckgabeGeldAnKunden();
		request.setAttribute("rueckgeld", rueckgeld + "0");
		request.setAttribute("rueckgeldZahl", rueckgeld);
		
		List<Double> zahlungsmittel = FahrkartenController.getInstance().getFinanzen().getAkzeptiertesgeld();
		request.setAttribute("zahlungsmittel", zahlungsmittel);
		
		List<Double> rueckgeldinMuenzen = FahrkartenController.getInstance().getFinanzen().getListeRueckgeld();
		request.setAttribute("rueckgabeInTeilen", rueckgeldinMuenzen);

		return null;
	}
}