package fabryki;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import elementyLabiryntu.Czar;
import elementyLabiryntu.CzarBurzacySciany;
import elementyLabiryntu.CzarOtwierajacyDrzwi;

public class FabrykaCzarow {
	@SuppressWarnings("serial")
	private static final Map<String,Czar> mapaFabrykCzarow = 
			 Collections.unmodifiableMap(new HashMap<String,Czar>() {{
				 put("czarOtwierajacyDrzwi", new CzarOtwierajacyDrzwi());
				 put("czarBurzacySciany", new CzarBurzacySciany());
			    }});
	
	public static Czar stworzCzar(String action) {
		Czar factory = mapaFabrykCzarow.get(action);
	    if (factory == null) {
	        throw new RuntimeException();
	    }
	    return factory;
	}
}
