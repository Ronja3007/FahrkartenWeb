package logik;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

 public class GeldSachen {
	
	private static final List<Integer> preiseKlasse = new ArrayList<> (){
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(4440);      //Wochenkarte    1
		add(17610);   //Monatskarte      2 
		add(13970);   //Jahreskarte      3
		add(740);   //Einzelfahrkarte    4
		add(1230);   //10er Steifenkarte 5
		add(1680);   //Tagesticket plus  6
		add(680);   //4er karte          7
		add(3420);   //Ferienkarte       8
	}};
	private static final List<Integer> akzeptiertesGeld = new ArrayList<> (){
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(10);
		add(20);
		add(50);
		add(100);
		add(200);
		add(500); 
		add(1000); 
		add(2000); 
		add(5000);      		
	}};	
	private Integer[] geldVorrat = new Integer[9];
	private static int fehlendesGeld;
	private static int rueckgabeGeldAnKunden;
	private List<Integer> listeRueckgeld = new ArrayList<>();
	private static int eingezahlt = 0;
	private static final int MAXANZAHLSCHEINE = 300;
	private static final int MAXANZAHLMUENZEN = 50;
	
	public GeldSachen() throws ValidierungsException {
		rueckgabeGeldAnKunden = 0;
		eingezahlt = 0;
		AbspeichernAuslesen daten = new AbspeichernAuslesen();
		geldVorrat = daten.datenAuslesen();
	}
//		anzahl10CentMuenzen = geldVorrat 0
//		anzahl20CentMuenzen = geldVorrat 1
//		anzahl50CentMuenzen = geldVorrat 2
//		anzahl1EuroMuenzen = geldVorrat.get(3);
//		anzahl2EuroMuenzen = geldVorrat.get(4);
//		anzahl5EuroScheine = geldVorrat.get(5);
//		anzahl10EuroScheine = geldVorrat.get(6);
//		anzahl20EuroScheine = geldVorrat.get(7);
//		anzahl50EuroScheine = geldVorrat.get(8);

	public double getEingezahlt() {
		return CentInEuro(eingezahlt);
	}
	private void datenSpeichern(Integer[] geldVorrat) throws ValidierungsException {
		AbspeichernAuslesen daten = new AbspeichernAuslesen();
		daten.datenSpeichern(geldVorrat);
		geldVorrat = daten.datenAuslesen();
	}

	private void geldAusEinzahlen(int betrag) throws ValidierungsException{
		for(int i = 0; i< 9; i++) {
			if(betrag == akzeptiertesGeld.get(i) || -betrag == akzeptiertesGeld.get(i)) {
				if(betrag < 0) {
					if(geldVorrat[i] > 0) {
						geldVorrat[i] -= 1;
						break;
					}else {
						System.out.println(CentInEuro(betrag*-1) + "-Fach ist leer!");
//						throw new ValidierungsException(betrag*-1 + "-Fach ist leer!");
					}
				}
				if(betrag > 0) {
					if(betrag < 500) {
						if(geldVorrat[i] < MAXANZAHLMUENZEN) {
							geldVorrat[i] += 1;
							eingezahlt += betrag;
							break;
						}else {
							System.out.println("Leider ist der " + CentInEuro(betrag) + " Euro-Maximalmuenzstand erreicht!");
//							throw new ValidierungsException("Leider ist dieser Maximalmuenzstand erreicht!");
						}
					}else{
						if(geldVorrat[i] < MAXANZAHLSCHEINE) {
							geldVorrat[i] += 1;
							eingezahlt += betrag;
							break;
						}else {
							System.out.println("Leider ist der " + CentInEuro(betrag) + " Euro-Maximalscheinstand erreicht!");
//							throw new ValidierungsException("Leider ist dieser Maximalscheinstand erreicht!");
						}
					}
				}
			}
		}
		datenSpeichern(geldVorrat);
	}
	
	private void wechselgeldBerechnen(int betrag, int preis) throws ValidierungsException {
		rueckgabeGeldAnKunden = eingezahlt - preis;
		inGeldstueckeUmrechenen(rueckgabeGeldAnKunden);
	}

	private void inGeldstueckeUmrechenen(int betrag) throws ValidierungsException {
		for (int i = akzeptiertesGeld.size()-1; i >= 0; i--) {
			while(betrag >= akzeptiertesGeld.get(i)) {
				betrag -= akzeptiertesGeld.get(i);
				geldAusEinzahlen(-akzeptiertesGeld.get(i));
				listeRueckgeld.add(akzeptiertesGeld.get(i));
			}
		}
	}

	public List<Double> getPreise() {
		List<Double> rueckgabe = new ArrayList<>();
		for (int i : preiseKlasse) {
			rueckgabe.add(CentInEuro(i));
		}
		return rueckgabe;
	}

	public List<Double> getAkzeptiertesgeld() {
		List<Double> rueckgabe = new ArrayList<Double>();
		for (int i : akzeptiertesGeld) {
			rueckgabe.add(CentInEuro(i));
		}
		return rueckgabe;
	}

	public void betragPruefen(double einzahlung, double preis) throws ValidierungsException {
		int einzahlungInCent = EuroInCent(einzahlung);
		int preisInCent = EuroInCent(preis);
		if(akzeptiertesGeld.contains(einzahlungInCent)) {
			geldAusEinzahlen(einzahlungInCent);
			if(eingezahlt < preisInCent) {
				fehlendesGeld = preisInCent - eingezahlt;
			}
			if(eingezahlt > preisInCent) {
				fehlendesGeld = 0;
				wechselgeldBerechnen(einzahlungInCent, preisInCent);
			}
		}else {
			fehlendesGeld = preisInCent - eingezahlt;
			System.out.println("Dieser Betrag entspricht keinen der aufgefuehrten einzahlbaren Betraege!");
			throw new ValidierungsException("Dieser Betrag entspricht keinen der aufgefuehrten einzahlbaren Betraege!");
		}
	}

	public static int getMaxanzahlscheine() {
		return MAXANZAHLSCHEINE;
	}

	public static int getMaxanzahlmuenzen() {
		return MAXANZAHLMUENZEN;
	}

	public double getFehlendesGeld(double preis) {
		fehlendesGeld = EuroInCent(preis) - eingezahlt;
		if(fehlendesGeld < 0) {
			return 0;
		}
		return CentInEuro(fehlendesGeld);
	}

	public double getRueckgabeGeldAnKunden() {
		return CentInEuro(rueckgabeGeldAnKunden);
	}
	
	public List<Double> getListeRueckgeld() {
		List<Double> rueckgabe = new ArrayList<>();
		for (int i : listeRueckgeld) {
			rueckgabe.add(CentInEuro(i));
		}
		listeRueckgeld.clear();
		return rueckgabe;
	}
	
	private double CentInEuro(int betrag) {
		return Math.round(betrag) / 100.0;
	}
	
	private int EuroInCent(Double betrag) {
		return (int) (betrag*100);
	}

	public List<String> getListeTickets() {
		List<String> sachen = new ArrayList<>(); 
		sachen.add("Wochenkarte");
		sachen.add("Monatskarte");
		sachen.add("Jahreskarte");
		sachen.add("Einzelfahrkarte");
		sachen.add("10er Streifenkarte");
		sachen.add("Tagesticket Plus");
		sachen.add("4er Ticket");
		sachen.add("Ferienticket");
		return sachen;
	}

	public void zuruecksetzen() throws ValidierungsException {
		eingezahlt = 0;
		rueckgabeGeldAnKunden = 0;
		fehlendesGeld = 0;
		datenSpeichern(geldVorrat);
	}
	
	void geldAuffuellenOderLeeren(String fachSTR, int anzahl) throws ValidierungsException {
		int fach = pruefen(fachSTR);
		if(fach < 5) {
			if(geldVorrat[fach]+anzahl > 0 && geldVorrat[fach]+ anzahl < MAXANZAHLMUENZEN)
				geldVorrat[fach]+= anzahl;
		}
		if(fach >= 5) {
			if(geldVorrat[fach] + anzahl > 0 && geldVorrat[fach] < MAXANZAHLSCHEINE) {
				geldVorrat[fach]+= anzahl;
			}
		}
		datenSpeichern(geldVorrat);
	}
	private int pruefen(String fachSTR) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<Double, Integer> getFuellstand() {
		TreeMap<Double, Integer> rueckgabe = new TreeMap<>();
		for(int i = 0; i< akzeptiertesGeld.size(); i++) {
			rueckgabe.put(CentInEuro(akzeptiertesGeld.get(i)), geldVorrat[i]);
		}
		return rueckgabe;
	}
}