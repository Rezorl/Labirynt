package wizytatorzy;

import elementyMagiczne.MagicznaSciana;
import silnikGry.Wspolrzedne;

public interface WizytatorMagicznejSciany extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, MagicznaSciana ms);
}
