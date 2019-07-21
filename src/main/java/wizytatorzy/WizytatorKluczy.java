package wizytatorzy;

import elementyLabiryntu.Klucz;
import silnikGry.Wspolrzedne;

public interface WizytatorKluczy {
	public abstract void visit(Wspolrzedne w, Klucz k);
}
