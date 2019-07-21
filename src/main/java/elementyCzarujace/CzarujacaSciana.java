package elementyCzarujace;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Sciana;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorCzarujacejSciany;

public class CzarujacaSciana extends Sciana{
	public CzarujacaSciana() {
		super.wzor = 88;
		super.kolor = Color.CORNFLOWERBLUE;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorCzarujacejSciany) {
			((WizytatorCzarujacejSciany)pw).visit(c, this);}
	}


	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarBurzacySciany czar) {
		czar.getPostac().getMapa().getListaElementow().replace(wsp, czar.getPostac().getMapa().getFabryka().stworzPokoj());
	}

	@Override
	public void zaczaruj(Wspolrzedne wsp, CzarOtwierajacyDrzwi czar) {
		// TODO Auto-generated method stub
	}
}
