package fabryki;

import elementyCzarujace.CzarujacaPostac;
import elementyCzarujace.CzarujacaSciana;
import elementyCzarujace.CzarujaceDrzwi;
import elementyCzarujace.CzarujacyPokoj;
import elementyLabiryntu.Drzwi;
import elementyLabiryntu.Klucz;
import elementyLabiryntu.Pokoj;
import elementyLabiryntu.Postac;
import elementyLabiryntu.Sciana;
import wysokieElementy.WysokiPokoj;

public class FabrykaCzarujacegoPoziomu implements FabrykaElementow{

	@Override
	public Pokoj stworzPokoj() {
		return new CzarujacyPokoj();
	}

	@Override
	public Sciana stworzSciane() {
		return new CzarujacaSciana();
	}

	@Override
	public Drzwi stworzDrzwi() {
		return new CzarujaceDrzwi();
	}

	@Override
	public Postac stworzPostac() {
		return new CzarujacaPostac();
	}

	@Override
	public Klucz stworzKlucz(int nr) {
		return new Klucz(nr);
	}

	@Override
	public Pokoj stworzWysokiPokoj() {
		return new WysokiPokoj();
	}

}
