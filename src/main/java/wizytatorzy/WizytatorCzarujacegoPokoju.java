package wizytatorzy;

import elementyCzarujace.CzarujacyPokoj;
import silnikGry.Wspolrzedne;

public interface WizytatorCzarujacegoPokoju extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, CzarujacyPokoj cp);
}
