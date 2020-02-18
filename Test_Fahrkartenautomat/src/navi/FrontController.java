package navi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gui.EinZahlenController;
import gui.LoginController;
import gui.LogoutController;
import gui.MenueController;
import gui.ServiceController;
import gui.ZahlenController;
import logik.FahrkartenController;

@WebServlet(value="*.do", loadOnStartup=1)
public class FrontController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private static final String LAYOUT_SEITE = "/WEB-INF/jsp/template.jsp";
	private Map<String, Controller> controller;
	
	@Override
	public void init() throws ServletException {
		controller = new HashMap<String, Controller>();
		controller.put("/menue", new MenueController());
		controller.put("/zahlen", new ZahlenController());
		controller.put("/einzahlen", new EinZahlenController());
		controller.put("/service", new ServiceController());
		controller.put("/login", new LoginController());
		controller.put("/logout", new LogoutController());

		System.out.println("Frontcontroller initialisiert");
		System.out.println(LAYOUT_SEITE);
	}
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuffer meldung = new StringBuffer();
		// /mvc/test/eins.do ohne /mvc und .do ==> /test/eins
		String navi = request.getRequestURI().substring( // /mvc/test/eins.do
				request.getContextPath().length(),		// /mvc
				request.getRequestURI().length() -3);	// .do
		
		System.out.println("REQUESTED: " + navi + "----------------------******************------------------------");
		
		if(navi.equals("/service") && request.getSession().getAttribute("eingeloggt") == null) {
			navi = "/login";
		}
		
		try
		{
			Controller c = controller.get(navi);
			if (c != null)
			{
				String neueNavi = c.execute(request, response, meldung);
				if (neueNavi != null) {
					navi = neueNavi;
					System.out.println("NEU: " + navi + "----------------------******************------------------------");
				}
			}
			if(navi.equals("/menue")) {
				FahrkartenController.getInstance().zuruecksetzen();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			meldung.append(e.getMessage());
//				e.printStackTrace();
		}

		request.setAttribute("notifications", meldung.toString());
		String requestedUrl = "/WEB-INF/jsp" + navi + ".jsp";
		
		if (isValidUrl(navi)) {
			request.setAttribute("url", requestedUrl);
		} else {
			request.setAttribute("url", "/WEB-INF/jsp/error/error.jsp");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(LAYOUT_SEITE);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
	private boolean isValidUrl(String url) {
		if (controller.get(url) != null) {
			return true;
		}
		return false;
	}
}