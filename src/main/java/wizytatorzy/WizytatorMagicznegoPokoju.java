package wizytatorzy;

import elementyMagiczne.MagicznyPokoj;
import silnikGry.Wspolrzedne;

public interface WizytatorMagicznegoPokoju extends PodstawowyWizytator{
	public abstract void visit(Wspolrzedne w, MagicznyPokoj mp);
}
