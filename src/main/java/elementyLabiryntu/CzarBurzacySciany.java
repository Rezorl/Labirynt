package elementyLabiryntu;


import java.util.Map;
import silnikGry.Wspolrzedne;

public class CzarBurzacySciany extends Czar{


	@Override
	public void rzuc(Map<Wspolrzedne, ElementLabiryntu> el) {
		for (Map.Entry<Wspolrzedne, ElementLabiryntu> entry : el.entrySet()){
			entry.getValue().zaczaruj(entry.getKey(), this);
		}
	}
}
