package logik;

public class Service {

	public void pruefen(String fach, String anzahl, String addOderSub) throws Exception {
		int anzahlINT = pruefen(anzahl);
		if(addOderSub.equals("auffuellen")) {
			geldAuffuellenLeeren(anzahlINT, fach);
		}
		if(addOderSub.equals("leeren")) {
			geldAuffuellenLeeren(-anzahlINT, fach);
		}
	}

	private int pruefen(String anzahl) throws Exception {
		int anzahlINT = -1;
		try {
			anzahlINT = Integer.parseInt(anzahl);
		}catch(Exception e) {
			throw new Exception("Das ist keine Zahl!");
		}
		if(anzahlINT > 300 || anzahlINT < 0) {
			throw new Exception("Diese Zahl ist zu gross oder negativ!");
		}
		return anzahlINT;
	}

	private void geldAuffuellenLeeren(int anzahl, String fach) throws ValidierungsException{
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(fach, anzahl);
	}
}
