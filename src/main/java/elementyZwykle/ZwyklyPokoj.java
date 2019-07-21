package elementyZwykle;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Pokoj;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorZwyklegoPokoju;

public class ZwyklyPokoj extends Pokoj{

	public ZwyklyPokoj() {
		super.wzor= 0;
		super.kolor = Color.GRAY;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorZwyklegoPokoju) {
			((WizytatorZwyklegoPokoju)pw).visit(c, this);}
	}


/*	@Override
	public void odwiedz(Wspolrzedne wsp, ZwyklaPostac p) {
		p.setPunkt(wsp);
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, MagicznaPostac p) {
		p.setPunkt(wsp);
	}

	@Override
	public void odwiedz(Wspolrzedne wsp, CzarujacaPostac p) {
		p.setPunkt(wsp);	
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
