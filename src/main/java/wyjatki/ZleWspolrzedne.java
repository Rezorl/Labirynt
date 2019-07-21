package wyjatki;

public class ZleWspolrzedne extends RuntimeException{

	private String message;
	private static final long serialVersionUID = 1L;

	public ZleWspolrzedne(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
