package gui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.FahrkartenController;
import navi.Controller;

public class ZahlenController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		List<Double> preise = FahrkartenController.getInstance().getFinanzen().getPreise();
		return null;
	}

}
