package logik;

import java.util.ArrayList;
import java.util.List;

public class MenuesEingaben {
	
	public static final String HAUPTMENUE = "hauptmenue";
	public static final String UNTERMENUEZEITKARTE = "untermenue";
	public static final String ZAHLEN = "zahlen";
	
	public List<String> getMenue() {
		List<String> menue = new ArrayList<String>();
		menue.add("Einzelfahrkarte kaufen");
		menue.add("10er Streifenkarte kaufen");
		menue.add("TagesTicket Plus kaufen");
		menue.add("4er Ticket kaufen");
		menue.add("Zeitkarte kaufen");
		menue.add("Ferienticket kaufen");
		return menue;
	}

	public List<String> getUntermenue() {
		List<String> menue = new ArrayList<String>();
		menue.add("Wochenkarte");
		menue.add("Monatskarte");
		menue.add("Jahreskarte");
		return menue;
	}
}