package fabryki;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MenadzerFabryk {
	@SuppressWarnings("serial")
	private static final Map<String,FabrykaElementow> mapaFabryk = 
			 Collections.unmodifiableMap(new HashMap<String,FabrykaElementow>() {{
			        put("zwykly", new FabrykaZwyklegoPoziomu());
			        put("magiczny", new FabrykaMagicznegoPoziomu());
			        put("czarujacy", new FabrykaCzarujacegoPoziomu());
			    }});
	
	public FabrykaElementow stworzFabryke(String action) {
		FabrykaElementow factory = mapaFabryk.get(action);
	    if (factory == null) {
	        throw new RuntimeException();
	    }
	    return factory;
	}
}
