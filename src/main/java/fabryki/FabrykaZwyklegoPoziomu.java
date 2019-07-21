package fabryki;

import elementyLabiryntu.*;
import elementyZwykle.*;
import wysokieElementy.WysokiPokoj;

public class FabrykaZwyklegoPoziomu implements FabrykaElementow{

	public Pokoj stworzPokoj() {
		return new ZwyklyPokoj();
	}

	public Sciana stworzSciane() {
		return new ZwyklaSciana();
	}

	public Drzwi stworzDrzwi() {
		return new ZwykleDrzwi();
	}

	public Postac stworzPostac() {
		return new ZwyklaPostac();
	}

	public Klucz stworzKlucz(int nr) {
		return new Klucz(nr);
	}

	@Override
	public Pokoj stworzWysokiPokoj() {
		return new WysokiPokoj();
	}
}
