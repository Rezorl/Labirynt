package elementyLabiryntu;

import java.util.Map;
import silnikGry.Wspolrzedne;
public abstract class Czar {
	protected Postac postac;
	public abstract void rzuc(Map<Wspolrzedne,ElementLabiryntu> e);
	public Postac getPostac() {
		return postac;
	}
	public void setPostac(Postac postac) {
		this.postac = postac;
	}

}
