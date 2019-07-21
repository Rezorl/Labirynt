package wizytatorzy;

import elementyZwykle.ZwykleDrzwi;
import silnikGry.Wspolrzedne;

public interface WizytatorZwyklychDrzwi extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, ZwykleDrzwi zd);
}
