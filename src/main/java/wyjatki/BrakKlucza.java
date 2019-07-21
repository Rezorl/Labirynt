package wyjatki;

public class BrakKlucza extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	public BrakKlucza(String m) {
		this.message=m;
	}
	public String getMessage() {
		return message;
	}
	
}
