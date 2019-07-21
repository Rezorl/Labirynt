package logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {
	private StringBuilder message;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public MyLogger(String message, LogLevel l) {
		this.message = new StringBuilder(dateFormat.format(new Date()));
		this.message.append(" " +l.toString()+": " + message);
	}

	public StringBuilder getMessage() {
		return message;
	}
}
