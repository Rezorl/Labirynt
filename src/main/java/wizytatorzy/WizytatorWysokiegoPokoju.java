package wizytatorzy;

import silnikGry.Wspolrzedne;
import wysokieElementy.WysokiPokoj;

public interface WizytatorWysokiegoPokoju extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, WysokiPokoj wp);
}
