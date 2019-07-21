package elementyMagiczne;

import java.util.ArrayList;
import elementyCzarujace.CzarujacaSciana;
import elementyCzarujace.CzarujaceDrzwi;
import elementyCzarujace.CzarujacyPokoj;
import elementyLabiryntu.ElementLabiryntu;
import elementyLabiryntu.Klucz;
import elementyLabiryntu.Postac;
import elementyZwykle.ZwyklaSciana;
import elementyZwykle.ZwykleDrzwi;
import elementyZwykle.ZwyklyPokoj;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wysokieElementy.WysokiPokoj;

public class MagicznaPostac extends Postac{
	
	public MagicznaPostac() {
		super.wzor = 80;
		super.chodzeWszedzie = true;
		super.klucze = new ArrayList<Klucz>();
		super.kolor = Color.CRIMSON;
	}

	@Override
	public void visit(Wspolrzedne w, ZwykleDrzwi zd) {
		setPunkt(w);	
	}

	@Override
	public void visit(Wspolrzedne w, MagiczneDrzwi md) {
		setPunkt(w);	
	}

	@Override
	public void visit(Wspolrzedne w, CzarujaceDrzwi cd) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, Klucz k) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, ZwyklyPokoj zp) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, MagicznyPokoj mp) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, CzarujacyPokoj cp) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, ZwyklaSciana zs) {
		setPunkt(w);
	}

	@Override
	public void visit(Wspolrzedne w, MagicznaSciana ms) {
		setPunkt(w);	
	}

	@Override
	public void visit(Wspolrzedne w, CzarujacaSciana cs) {
		setPunkt(w);	
	}

	@Override
	public void visit(Wspolrzedne w, WysokiPokoj wp) {
		setPunkt(w);
		if(wp.isMaLampe()) {
			if(wp.isLampaWlaczona()) {
				//zgas lampe
				wp.setLampaWlaczona(!wp.isLampaWlaczona());
				//przyciemnij kolory
				for(ElementLabiryntu e : this.getMapa().getListaElementow().values()) {
					e.setKolor(e.getKolor().darker());
				}
			}else {
				//wlacz lampe
				wp.setLampaWlaczona(!wp.isLampaWlaczona());
				//rozjasnij kolory
				for(ElementLabiryntu e : this.getMapa().getListaElementow().values()) {
					e.setKolor(e.getKolor().brighter());
				}
			}
		}
	}
}
