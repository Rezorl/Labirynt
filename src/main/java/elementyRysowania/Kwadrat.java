package elementyRysowania;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;

public class Kwadrat extends Rectangle{
	
	public Kwadrat(Color c,int x, int y) {
		setWidth(Main.POWIEKSZENIE);
		setHeight(Main.POWIEKSZENIE);
		relocate(x*Main.POWIEKSZENIE, y*Main.POWIEKSZENIE);
		setFill(c);
	}
}
