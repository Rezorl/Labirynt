package dokumenty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fabryki.FabrykaDokumentow;

public class MenadzerDokumentow {
	@SuppressWarnings("serial")
	private static final Map<String,FabrykaDokumentow> mapaFabrykDokumentow = 
			 Collections.unmodifiableMap(new HashMap<String,FabrykaDokumentow>() {{
			        put("zwykly", new FabrykaDokumentow() { public Dokument stworz() { return new DokumentTxt("src\\main\\resources\\zwykly"); }});
			        put("magiczny", new FabrykaDokumentow() { public Dokument stworz() { return new DokumentTxt("src\\main\\resources\\magiczny"); }});
			        put("czarujacy", new FabrykaDokumentow() { public Dokument stworz() { return new DokumentTxt("src\\main\\resources\\czarujacy"); }});
			    }});
	
	public Dokument stworzDokument(String action) {
		FabrykaDokumentow factory = mapaFabrykDokumentow.get(action);
	    if (factory == null) {
	        throw new RuntimeException();
	    }
	    return factory.stworz();
	}
	
}
