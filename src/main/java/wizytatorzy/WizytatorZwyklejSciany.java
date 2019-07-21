package wizytatorzy;

import elementyZwykle.ZwyklaSciana;
import silnikGry.Wspolrzedne;

public interface WizytatorZwyklejSciany extends PodstawowyWizytator {
	public abstract void visit(Wspolrzedne w, ZwyklaSciana zs);
}
