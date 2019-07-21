package silnikGry;

import java.util.HashMap;
import java.util.Map;
import dokumenty.Dokument;
import dokumenty.MenadzerDokumentow;
import elementyCzarujace.CzarujacaPostac;
import elementyLabiryntu.*;
import fabryki.FabrykaElementow;
import fabryki.FabrykaZwyklegoPoziomu;
import wyjatki.ZleWspolrzedne;

public class Mapa {
	
	private int wysokosc;
	private int szerokosc;
	private FabrykaElementow fabryka;
	public Map<Wspolrzedne,ElementLabiryntu> listaElementow;
	private Postac postac;
	private MenadzerDokumentow md;
	private Dokument dokument;
	
	public Mapa(int wysokosc,int szerokosc) {
		this.wysokosc = wysokosc;
		this.szerokosc = szerokosc;
		this.listaElementow = new HashMap<Wspolrzedne, ElementLabiryntu>();
		this.fabryka = new FabrykaZwyklegoPoziomu();
		this.md = new MenadzerDokumentow();
	}
	
	public Mapa() {
		this.listaElementow = new HashMap<Wspolrzedne, ElementLabiryntu>();
		this.md = new MenadzerDokumentow();
		dokument = md.stworzDokument("zwykly");
		setListaElementow(dokument.wezELementyLabiryntu());
		this.fabryka = dokument.getFabrykaElementow();
		this.postac = dokument.getPostac();
		this.postac.setMapa(this);
		this.wysokosc = dokument.getxMapy();
		this.szerokosc = dokument.getyMapy();
		System.out.println("Kolor psotaci:"+ postac.getKolor());
	}
	
	public int getWysokosc() {
		return wysokosc;
	}
	
	public void setWysokosc(int wysokosc) {
		this.wysokosc = wysokosc;
	}
	
	public int getSzerokosc() {
		return szerokosc;
	}
	
	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public FabrykaElementow getFabryka() {
		return fabryka;
	}

	public void setFabryka(String rodzaj) {
		dokument = md.stworzDokument(rodzaj);
		setListaElementow(dokument.wezELementyLabiryntu());
		this.fabryka = dokument.getFabrykaElementow();
		this.postac = dokument.getPostac();
		this.postac.setMapa(this);
		this.wysokosc = dokument.getxMapy();
		this.szerokosc = dokument.getyMapy();
	}

	
	public void idz(int x, int y) {
		if( (postac.getPunkt().getX()+x < 0 || postac.getPunkt().getX()+x > getWysokosc()-1) || (postac.getPunkt().getY()+y < 0 || postac.getPunkt().getY()+y > getSzerokosc()-1)) {
			throw new ZleWspolrzedne("Nie mozna tam przejsc!");
		}
		listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()+x,postac.getPunkt().getY()+y)).visit(new Wspolrzedne(postac.getPunkt().getX()+x,postac.getPunkt().getY()+y), postac);
	}

	public void czaruj(int nr) {
		Map<Wspolrzedne,ElementLabiryntu> el = new HashMap<>();
		//gorne
		if(czyMoge(-1, -1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY()-1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY()-1)));
		}
		if(czyMoge(0, -1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX(), postac.getPunkt().getY()-1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX(), postac.getPunkt().getY()-1)));
		}
		if(czyMoge(1,-1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY()-1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY()-1)));
		}
		//boczne
		if(czyMoge(-1,0)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY()),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY())));
		}
		if(czyMoge(1,0)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY()),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY())));
		}
		//dolne
		if(czyMoge(-1,1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY()+1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()-1, postac.getPunkt().getY()+1)));
		}
		if(czyMoge(0,1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX(), postac.getPunkt().getY()+1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX(), postac.getPunkt().getY()+1)));
		}
		if(czyMoge(1,1)) {
			el.put(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY()+1),listaElementow.get(new Wspolrzedne(postac.getPunkt().getX()+1, postac.getPunkt().getY()+1)));
		}
		((CzarujacaPostac)postac).rzucCzar(nr,el);
	}
	
	private boolean czyMoge(int x, int y) {
		if( (postac.getPunkt().getX()+x < 0 || postac.getPunkt().getX()+x > getWysokosc()-1) || (postac.getPunkt().getY()+y < 0 || postac.getPunkt().getY()+y > getSzerokosc()-1)) {
			return false;
		}
		return true;
	}
	
	public Map<Wspolrzedne, ElementLabiryntu> getListaElementow() {
		return listaElementow;
	}

	private void setListaElementow(Map<Wspolrzedne, ElementLabiryntu> listaElementow) {
		this.listaElementow = listaElementow;
	}

	public Postac getPostac() {
		return postac;
	}

	public void setPostac(Postac postac) {
		this.postac = postac;
	}
	
}
