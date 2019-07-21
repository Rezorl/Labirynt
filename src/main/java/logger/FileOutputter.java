package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter {
	private BufferedWriter zapis = null;
	private String fileName;
	
	public FileOutputter(String fileName) {
		try {
			this.fileName = fileName;
			FileWriter file = new FileWriter(fileName+".txt", true);
			zapis = new BufferedWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void log(String message) throws IOException {
		zapis.write(message);
		zapis.newLine();
		zapis.flush();
	}

	public void close() {
		try {
			zapis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}
	
}
