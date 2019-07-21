package wizytatorzy;

import elementyMagiczne.MagiczneDrzwi;
import silnikGry.Wspolrzedne;

public interface WizytatorMagicznychDrzwi extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, MagiczneDrzwi md);
}
