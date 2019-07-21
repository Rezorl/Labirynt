package elementyZwykle;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Sciana;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorZwyklejSciany;

public class ZwyklaSciana extends Sciana{

	public ZwyklaSciana() {
		super.wzor = 35;
		super.kolor = Color.BLACK;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorZwyklejSciany) {
			((WizytatorZwyklejSciany)pw).visit(c, this);}			
	}


/*	@Override
	public void odwiedz(Wspolrzedne wsp, ZwyklaPostac p) {

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
