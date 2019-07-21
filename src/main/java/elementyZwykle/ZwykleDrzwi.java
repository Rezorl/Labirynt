package elementyZwykle;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Drzwi;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorZwyklychDrzwi;

public class ZwykleDrzwi extends Drzwi{

	public ZwykleDrzwi() {
		super.wzor = 33;
		super.kolor = Color.SADDLEBROWN;
	}

	@Override
	public boolean czyOtwarte() {
		return super.czyOtwarte;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorZwyklychDrzwi) {
			((WizytatorZwyklychDrzwi)pw).visit(c, this);}		
	}


/*	@Override
	public void odwiedz(Wspolrzedne wsp, ZwyklaPostac p) {
		if(super.czyOtwarte) {
			p.setPunkt(wsp);
			return;
		}
		for(Klucz k : p.getKlucze()) {
			if(getNrKluczaOtwierajacego()==k.getNrKlucza()) {
				p.setPunkt(wsp);
				super.czyOtwarte = true;
				return;
			}
		}
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, MagicznaPostac p) {
		p.setPunkt(wsp);
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, CzarujacaPostac p) {
		if(super.czyOtwarte) {
			p.setPunkt(wsp);
			return;
		}
		for(Klucz k : p.getKlucze()) {
			if(getNrKluczaOtwierajacego()==k.getNrKlucza()) {
				p.setPunkt(wsp);
				super.czyOtwarte = true;
				return;
			}
		}
	}*/

	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarBurzacySciany czar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarOtwierajacyDrzwi czar) {
		// TODO Auto-generated method stub
		
	}
}
