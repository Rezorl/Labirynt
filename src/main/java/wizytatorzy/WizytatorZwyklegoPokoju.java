package wizytatorzy;

import elementyZwykle.ZwyklyPokoj;
import silnikGry.Wspolrzedne;

public interface WizytatorZwyklegoPokoju extends PodstawowyWizytator{
	public abstract void visit(Wspolrzedne w, ZwyklyPokoj zp);
}
