package fabryki;

import elementyLabiryntu.*;

public interface FabrykaElementow {
	public Pokoj stworzPokoj();
	public Sciana stworzSciane();
	public Drzwi stworzDrzwi();
	public Postac stworzPostac();
	public Klucz stworzKlucz(int nr);
	public Pokoj stworzWysokiPokoj();
}
