package elementyMagiczne;

import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Sciana;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;
import wizytatorzy.WizytatorMagicznejSciany;

public class MagicznaSciana extends Sciana{
	
	public MagicznaSciana() {
		super.wzor = 88;
		super.kolor = Color.GREY;
	}

	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof WizytatorMagicznejSciany) {
			((WizytatorMagicznejSciany)pw).visit(c, this);}
	}

	@Override
	public void zaczaruj(Wspolrzedne c, CzarOtwierajacyDrzwi czar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zaczaruj(Wspolrzedne c, CzarBurzacySciany czar) {
		// TODO Auto-generated method stub
		
	}


}
