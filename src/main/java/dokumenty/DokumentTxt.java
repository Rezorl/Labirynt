package dokumenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import elementyCzarujace.CzarujacaPostac;
import elementyLabiryntu.*;
import fabryki.FabrykaCzarow;
import fabryki.MenadzerFabryk;
import silnikGry.Wspolrzedne;
import wysokieElementy.WysokiPokoj;

public class DokumentTxt extends Dokument{
	
	public DokumentTxt(String nazwaPliku) {
		super.nazwaPliku = nazwaPliku;
		super.listaScian =  new HashMap<>();
		super.listaPokoi =  new HashMap<>();
		super.listaDrzwi =  new HashMap<>();
		super.listaKluczy =  new HashMap<>();
		super.listaPostaci =  new HashMap<>();
		super.listaElementow = new HashMap<>(); 
		super.menadzerFabryk = new MenadzerFabryk();
		super.listaCzarow = new HashMap<>();
		try {
			wczytajDane();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	

	protected void wczytajDane() throws FileNotFoundException, IOException {
		super.fileReader = new FileReader(nazwaPliku+".txt");
		super.bufferedReader = new BufferedReader(fileReader);
		String textLine;
		int z=0;
		ElementLabiryntu el;
		Wspolrzedne w;
		while((textLine = bufferedReader.readLine()) != null) {
			String[] tab = textLine.split(" ");
			if(z==0) {
				super.fabrykaElementow = menadzerFabryk.stworzFabryke(tab[0]);
				System.out.println(super.fabrykaElementow);
				z++;
			}else if(z==1) {
				super.xMapy = Integer.parseInt(tab[0]);
				System.out.println("X mapy:" + super.xMapy);
				super.yMapy = Integer.parseInt(tab[1]);
				System.out.println("Y mapy:" + super.yMapy);
				z++;
				//dodaj wszedzie sciany
				for(int i=0; i<xMapy; ++i) {
					for(int j=0;j<yMapy;++j) {
						listaElementow.put(new Wspolrzedne(i,j), fabrykaElementow.stworzSciane());
					}
				}
			}else {
				//czy pokoj
				if(tab[0].equals(Dokument.POKOJ)) {
					el = fabrykaElementow.stworzPokoj();
					w =new Wspolrzedne(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					listaPokoi.put(w, el);
				    listaElementow.replace(w, el);
				}
				//czy drzwi
				else if(tab[0].equals(Dokument.DRZWI)) {
					el = fabrykaElementow.stworzDrzwi();
					w =new Wspolrzedne(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					((Drzwi)el).setNrKluczaOtwierajacego(Integer.parseInt(tab[3]));
					listaDrzwi.put(w, el);
					listaElementow.replace(w, el);
				}
				//czy klucz
				else if(tab[0].equals(Dokument.KLUCZ)) {
					el = fabrykaElementow.stworzKlucz(Integer.parseInt(tab[3]));
					w =new Wspolrzedne(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					listaKluczy.put(w, el);
					listaElementow.replace(w, el);
				}
				//czy postac
				else if(tab[0].equals(Dokument.POSTAC)) {
					Postac p = fabrykaElementow.stworzPostac();
					System.out.println("Tworzenie postaci");
					w =new Wspolrzedne(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					listaPostaci.put(w, p);
					p.setPunkt(w);
					postac = p;
				}
				//czy czar
				else if(tab[0].equals(Dokument.CZAR)) {
					Czar c = FabrykaCzarow.stworzCzar(tab[1]);
					c.setPostac(postac);
					((CzarujacaPostac)postac).dodajCzar(Integer.parseInt(tab[2]),c);
					listaCzarow.put(Integer.parseInt(tab[2]),c);
				}
				//wysokiPokoj
				if(tab[0].equals(Dokument.WYSOKI_POKOJ)) {
					System.out.println("wysokiPokoj");
					el = fabrykaElementow.stworzWysokiPokoj();
					((WysokiPokoj)el).setMaLampe(Boolean.parseBoolean(tab[3]));
					w =new Wspolrzedne(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					listaPokoi.put(w, el);
				    listaElementow.replace(w, el);
				}
			}
		}
		bufferedReader.close();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Wspolrzedne wsp : wezELementyLabiryntu().keySet()) {
			s += wsp + "" + wezELementyLabiryntu().get(wsp)+ "" + "\n";
		}
		return s;
	}

}
