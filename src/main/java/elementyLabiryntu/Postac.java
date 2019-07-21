package elementyLabiryntu;

import java.util.Iterator;
import java.util.List;
import javafx.scene.paint.Color;
import silnikGry.Mapa;
import silnikGry.Wspolrzedne;
import wizytatorzy.WizytatorCzarujacegoPokoju;
import wizytatorzy.WizytatorCzarujacejSciany;
import wizytatorzy.WizytatorCzarujacychDrzwi;
import wizytatorzy.WizytatorKluczy;
import wizytatorzy.WizytatorMagicznegoPokoju;
import wizytatorzy.WizytatorMagicznejSciany;
import wizytatorzy.WizytatorMagicznychDrzwi;
import wizytatorzy.WizytatorWysokiegoPokoju;
import wizytatorzy.WizytatorZwyklegoPokoju;
import wizytatorzy.WizytatorZwyklejSciany;
import wizytatorzy.WizytatorZwyklychDrzwi;

public abstract class Postac implements WizytatorCzarujacegoPokoju, WizytatorCzarujacejSciany, WizytatorCzarujacychDrzwi, WizytatorMagicznegoPokoju, WizytatorKluczy, WizytatorMagicznejSciany,WizytatorMagicznychDrzwi,WizytatorWysokiegoPokoju, WizytatorZwyklegoPokoju, WizytatorZwyklejSciany, WizytatorZwyklychDrzwi{
	
	protected int wzor;
	protected Color kolor;
	protected boolean chodzeWszedzie;
	protected Wspolrzedne punkt;
	protected List<Klucz> klucze;
	protected Mapa mapa;
	
	public boolean czyChodzeWszedzie() {
		return chodzeWszedzie;
	}
	public Wspolrzedne getPunkt() {
		return punkt;
	}
	public void setPunkt(Wspolrzedne punkt) {
		this.punkt = punkt;
	}
	public List<Klucz> getKlucze() {
		return klucze;
	}
	public void setKlucze(List<Klucz> klucze) {
		this.klucze = klucze;
	}
	
	public void dodajKlucz(Klucz c){
		klucze.add(c);
	}
	
	public void usunKlucz(Klucz c) {
		for (Iterator<Klucz> iterator = klucze.iterator(); iterator.hasNext(); ) {
			Klucz k = iterator.next();
		    if (c.equals(k)) {
		        iterator.remove();
		    }
		}
	}
	public int getWzor() {
		return wzor;
	}

	public void setWzor(int wzor) {
		this.wzor = wzor;
	}

	public Color getKolor() {
		return kolor;
	}

	public void setKolor(Color kolor) {
		this.kolor = kolor;
	}
	public Mapa getMapa() {
		return mapa;
	}
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
