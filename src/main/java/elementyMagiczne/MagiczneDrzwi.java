package elementyMagiczne;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Drzwi;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorMagicznychDrzwi;

public class MagiczneDrzwi extends Drzwi{

	public MagiczneDrzwi() {
		super.wzor = 63;
		super.kolor = Color.CORNFLOWERBLUE;
	}

	@Override
	public boolean czyOtwarte() {
		return true;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorMagicznychDrzwi) {
			((WizytatorMagicznychDrzwi)pw).visit(c, this);}		
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
		if(p.getListaCzarow().size()>0) {
			p.getListaCzarow().remove(0);
			p.setPunkt(wsp);
			super.czyOtwarte = true;
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
