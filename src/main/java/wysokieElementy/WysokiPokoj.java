package wysokieElementy;

import elementyCzarujace.CzarujacaPostac;
import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;
import elementyLabiryntu.Pokoj;
import elementyMagiczne.MagicznaPostac;
import elementyZwykle.ZwyklaPostac;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wizytatorzy.PodstawowyWizytator;

public class WysokiPokoj extends Pokoj{

	private boolean maLampe;
	private boolean lampaWlaczona = false;
	
	public WysokiPokoj() {
		super.wzor = 54;
		super.kolor = Color.STEELBLUE;
	}
	
	@Override
	public void visit(Wspolrzedne c, PodstawowyWizytator pw) {
		if(pw instanceof CzarujacaPostac) {
			((CzarujacaPostac)pw).visit(c, this);}
		else if(pw instanceof ZwyklaPostac) {
			((ZwyklaPostac)pw).visit(c, this);}
		else if(pw instanceof MagicznaPostac) {
			((MagicznaPostac)pw).visit(c, this);}	
	}

	@Override
	public void zaczaruj(Wspolrzedne c, CzarOtwierajacyDrzwi czar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zaczaruj(Wspolrzedne c, CzarBurzacySciany czar) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMaLampe() {
		return maLampe;
	}

	public void setMaLampe(boolean maLampe) {
		this.maLampe = maLampe;
	}

	public boolean isLampaWlaczona() {
		return lampaWlaczona;
	}

	public void setLampaWlaczona(boolean lampaWlaczona) {
		this.lampaWlaczona = lampaWlaczona;
	}

	
}
