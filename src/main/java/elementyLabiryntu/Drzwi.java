package elementyLabiryntu;

public abstract class Drzwi extends ElementLabiryntu{
	protected boolean czyOtwarte = false;
	protected int nrKluczaOtwierajacego;
	
	public abstract boolean czyOtwarte();

	public void setCzyOtwarte(boolean czyOtwarte) {
		this.czyOtwarte = czyOtwarte;
	}

	public int getNrKluczaOtwierajacego() {
		return nrKluczaOtwierajacego;
	}

	public void setNrKluczaOtwierajacego(int nrKluczaOtwierajacego) {
		this.nrKluczaOtwierajacego = nrKluczaOtwierajacego;
	}

	public boolean isCzyOtwarte() {
		return czyOtwarte;
	}
	
}
