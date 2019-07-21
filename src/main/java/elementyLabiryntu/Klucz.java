package elementyLabiryntu;

import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorKluczy;

public class Klucz extends ElementLabiryntu{
	private int nrKlucza;
	
	public Klucz(int nr) {
		this.nrKlucza = nr;
		super.wzor = 75;
		super.kolor = Color.SANDYBROWN;
	}

	public int getNrKlucza() {
		return nrKlucza;
	}

	public void setNrKlucza(int nrKlucza) {
		this.nrKlucza = nrKlucza;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klucz other = (Klucz) obj;
		if (nrKlucza != other.nrKlucza)
			return false;
		return true;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorKluczy) {
			((WizytatorKluczy)pw).visit(c, this);}	
	}


	
/*	@Override
	public void odwiedz(Wspolrzedne wsp,ZwyklaPostac p) {
		p.dodajKlucz(this);
		p.mapa.listaElementow.replace(wsp, p.getMapa().getFabryka().stworzPokoj());
		p.setPunkt(wsp);
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, MagicznaPostac p) {
		p.setPunkt(wsp);
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, CzarujacaPostac p) {
		p.dodajKlucz(this);
		p.mapa.listaElementow.replace(wsp, p.getMapa().getFabryka().stworzPokoj());
		p.setPunkt(wsp);	
	}
*/
	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarBurzacySciany czar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarOtwierajacyDrzwi czar) {
		// TODO Auto-generated method stub
		
	}
}
