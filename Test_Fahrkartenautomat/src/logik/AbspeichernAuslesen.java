package logik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AbspeichernAuslesen {
	
	private static final String dateiPfad = "C:/Things/fahrkartenautomat.txt";
	
	public static void main(String[] args) {
		
	}

	void datenSpeichern(Integer[] geldVorrat) throws ValidierungsException {
		String txt = InStringUmwandeln(geldVorrat);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dateiPfad));
            out.write(txt);
            out.close();
        } catch (IOException e) {
            throw new ValidierungsException("Fehler beim Speichern der Datei!");
        }
	}

	private String InStringUmwandeln(Integer[] geldVorrat) {
		String txt = "";
		for(int i = 0; i< 9; i++) {
			txt += geldVorrat[i].toString() + "%";
		}
		return txt;
	}

	private Integer[] umwandeln(String txt) {
		String[] aufgeteilt = txt.split("%");
		Integer[] neu = new Integer[9];
		for(int i = 0; i<9; i++) {
			neu[i] = Integer.parseInt(aufgeteilt[i]);
		}
		return neu;
	}
	
	Integer[] datenAuslesen() throws ValidierungsException  {
		String txt = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(dateiPfad));
            txt =in.readLine();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ValidierungsException("Fehler beim Auslesen der Datei!");
        }
		Integer[] rueckgabe = umwandeln(txt);
		return rueckgabe;
	}
}
