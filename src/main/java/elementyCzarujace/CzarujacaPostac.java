package elementyCzarujace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import elementyLabiryntu.Czar;
import elementyLabiryntu.ElementLabiryntu;
import elementyLabiryntu.Klucz;
import elementyLabiryntu.Postac;
import elementyMagiczne.MagicznaSciana;
import elementyMagiczne.MagiczneDrzwi;
import elementyMagiczne.MagicznyPokoj;
import elementyZwykle.ZwyklaSciana;
import elementyZwykle.ZwykleDrzwi;
import elementyZwykle.ZwyklyPokoj;
import javafx.scene.paint.Color;
import silnikGry.Wspolrzedne;
import wysokieElementy.WysokiPokoj;

public class CzarujacaPostac extends Postac{

	private Map<Integer,Czar> listaCzarow;
	public CzarujacaPostac() {
		super.wzor = 85;
		super.chodzeWszedzie = false;
		super.klucze = new ArrayList<Klucz>();
		super.kolor = Color.YELLOW;
		this.listaCzarow = new HashMap<>();
	}

	public Map<Integer, Czar> getListaCzarow() {
		return listaCzarow;
	}

	public void setListaCzarow(Map<Integer, Czar> listaCzarow) {
		this.listaCzarow = listaCzarow;
	}

	public void dodajCzar(int nr, Czar c) {
		listaCzarow.put(nr, c);
	}
	
	public void rzucCzar(int nr, Map<Wspolrzedne,ElementLabiryntu> listaElementow) {
		listaCzarow.get(nr).rzuc(listaElementow);
	}

	@Override
	public void visit(Wspolrzedne w, ZwykleDrzwi zd) {
		if(zd.czyOtwarte()) {
			setPunkt(w);
			return;
		}
		for(Klucz k : getKlucze()) {
			if(zd.getNrKluczaOtwierajacego()==k.getNrKlucza()) {
				setPunkt(w);
				zd.setCzyOtwarte(true);
				return;
			}
		}
	}

	@Override
	public void visit(Wspolrzedne w, MagiczneDrzwi md) {
		if(md.czyOtwarte()) {
			this.setPunkt(w);
			return;
		}
		for(Klucz k : getKlucze()) {
			if(md.getNrKluczaOtwierajacego()==k.getNrKlucza()) {
				this.setPunkt(w);
				md.setCzyOtwarte(true);
				return;
			}
		}		
	}

	@Override
	public void visit(Wspolrzedne w, CzarujaceDrzwi cd) {
		if(cd.isCzyOtwarte()) {
			setPunkt(w);
		}
	}

	@Override
	public void visit(Wspolrzedne w, Klucz k) {
		dodajKlucz(k);
		getMapa().getListaElementow().replace(w, getMapa().getFabryka().stworzPokoj());
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
		// TODO Auto-generated method stub
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
