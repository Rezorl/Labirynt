package wizytatorzy;

import elementyCzarujace.CzarujaceDrzwi;
import silnikGry.Wspolrzedne;

public interface WizytatorCzarujacychDrzwi extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, CzarujaceDrzwi cd);
}
