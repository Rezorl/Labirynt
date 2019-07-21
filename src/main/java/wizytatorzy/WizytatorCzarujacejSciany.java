package wizytatorzy;

import elementyCzarujace.CzarujacaSciana;
import silnikGry.Wspolrzedne;

public interface WizytatorCzarujacejSciany extends PodstawowyWizytator{
	public abstract void visit(Wspolrzedne w, CzarujacaSciana cs);
}
