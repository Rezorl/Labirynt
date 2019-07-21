package fabryki;

import elementyLabiryntu.*;
import elementyMagiczne.*;
import wysokieElementy.WysokiPokoj;

public class FabrykaMagicznegoPoziomu implements FabrykaElementow{

	public Pokoj stworzPokoj() {
		return new MagicznyPokoj();
	}

	public Sciana stworzSciane() {
		return new MagicznaSciana();
	}

	public Drzwi stworzDrzwi() {
		return new MagiczneDrzwi();
	}

	public Postac stworzPostac() {
		return new MagicznaPostac();
	}

	public Klucz stworzKlucz(int nr) {
		return new Klucz(nr);
	}
	
	@Override
	public Pokoj stworzWysokiPokoj() {
		return new WysokiPokoj();
	}
}
