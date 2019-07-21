package elementyLabiryntu;

import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;

public abstract class ElementLabiryntu {
	protected int wzor;
	protected Color kolor;
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

	public abstract void visit(Wspolrzedne c,PodstawowyWizytator pw);
	public abstract void zaczaruj(Wspolrzedne c,CzarOtwierajacyDrzwi czar);
	public abstract void zaczaruj(Wspolrzedne c,CzarBurzacySciany czar);
/*	public abstract void odwiedz(Wspolrzedne wsp, ZwyklaPostac p);
	public abstract void odwiedz(Wspolrzedne wsp, MagicznaPostac p);
	public abstract void odwiedz(Wspolrzedne wsp, CzarujacaPostac p);
	public abstract void zaczaruj(Wspolrzedne wsp, CzarBurzacySciany czar);
	public abstract void zaczaruj(Wspolrzedne wsp, CzarOtwierajacyDrzwi czar);*/
}
