package main;

import java.io.IOException;
import java.util.Map;
import elementyLabiryntu.ElementLabiryntu;
import elementyRysowania.Kwadrat;
import fabryki.FabrykaCzarujacegoPoziomu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logger.FileOutputter;
import logger.LogLevel;
import logger.MyLogger;
import silnikGry.Mapa;
import silnikGry.Wspolrzedne;
import wyjatki.BrakKlucza;
import wyjatki.ZleWspolrzedne;

public class Main extends Application{
	public static int POWIEKSZENIE = 25;
	private static Mapa m = new Mapa();//15,30
	private Group elementyGrupy = new Group();
	private Scene scene = new Scene(createContent(),m.getSzerokosc()*POWIEKSZENIE,m.getWysokosc()*POWIEKSZENIE);
	private static FileOutputter fo = new FileOutputter("logi");
	private static int zmiana=0;
	public static void main(String[] args) {
		try {
			fo.log(new MyLogger("W³¹czenie gry.", LogLevel.INFO).getMessage().toString());
			System.out.println("W³¹czenie gry.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		launch(args);
	}
	
	@Override
	public void stop() {
		try {
			fo.log(new MyLogger("Wyjœcie z gry.", LogLevel.DEBUG).getMessage().toString());
			System.out.println("Wyjœcie z gry.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		fo.close();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert a =new Alert(Alert.AlertType.INFORMATION, "Gora - strzalka do gory.\nDol - strzalka do gory.\nLewo - strzalka w lewo.\nPrawo - strzalka w prawo.\nz-zmiana mapy.\nq - zamknij gre.\nJEZELI CZARUJACY POZIOM:\nx-otworz drzwi czarem\nc-wyburz sciany(tworzac pokoje) kolo postaci",ButtonType.OK);
		a.setTitle("Informaje");
		a.setHeaderText("Informacje o aplikacji.");
		a.setAlertType(Alert.AlertType.INFORMATION);
		a.showAndWait();
		scene.setOnKeyPressed(e -> {
			try {
				if(e.getCode() ==  KeyCode.LEFT) {
					fo.log(new MyLogger("Lewo.", LogLevel.INFO).getMessage().toString());
					System.out.println("Lewo.");
					m.idz(0, -1);
					scene.setRoot(createContent());
				}else if(e.getCode() == KeyCode.RIGHT) {
					fo.log(new MyLogger("Prawo.", LogLevel.INFO).getMessage().toString());
					System.out.println("Prawo.");
					m.idz(0, 1);
					scene.setRoot(createContent());
				}else if(e.getCode() == KeyCode.DOWN) {
					fo.log(new MyLogger("Dol.", LogLevel.INFO).getMessage().toString());
					System.out.println("Dol.");
					m.idz(1, 0);
					scene.setRoot(createContent());
				}else if(e.getCode() == KeyCode.UP) {
					fo.log(new MyLogger("Gora.", LogLevel.INFO).getMessage().toString());
					System.out.println("Gora.");
					m.idz(-1, 0);
					scene.setRoot(createContent());
				}else if(e.getCode() == KeyCode.Q) {
					primaryStage.close();
				}else if(e.getCode() == KeyCode.Z) {
					fo.log(new MyLogger("Wciœnieto Z.", LogLevel.INFO).getMessage().toString());
					System.out.println("Wciœnieto Z.");
					if((zmiana+=1)>2){
						zmiana=0;
					}
					if(zmiana==0) {				
						m.setFabryka("zwykly");
						scene.setRoot(createContent());
						System.out.println("Zmieniono na zwyk³¹ mape.");
						fo.log(new MyLogger("Zmieniono na zwyk³¹ mape.", LogLevel.INFO).getMessage().toString());
					}else if(zmiana==1){
						m.setFabryka("magiczny");
						scene.setRoot(createContent());
						System.out.println("Zmieniono na magiczn¹ mape.");
						fo.log(new MyLogger("Zmieniono na magiczn¹ mape.", LogLevel.INFO).getMessage().toString());
					}else if(zmiana==2) {
						m.setFabryka("czarujacy");
						scene.setRoot(createContent());
						System.out.println("Zmieniono na zwyk³¹ mape.");
						fo.log(new MyLogger("Zmieniono na zwyk³¹ mape.", LogLevel.INFO).getMessage().toString());
					}
				}
				else if(e.getCode() == KeyCode.X) {
					if(m.getFabryka() instanceof FabrykaCzarujacegoPoziomu) {
						m.czaruj(0);
						scene.setRoot(createContent());
					}
				}
				else if(e.getCode() == KeyCode.C) {
					if(m.getFabryka() instanceof FabrykaCzarujacegoPoziomu) {
						m.czaruj(1);
						scene.setRoot(createContent());
					}
				}
			}catch(BrakKlucza | ZleWspolrzedne | IOException m) {
				try {
					fo.log(new MyLogger(m.getClass()+ ": " + m.getMessage(), LogLevel.WARNING).getMessage().toString());
					System.out.println(m.getMessage());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		primaryStage.setTitle("Labirynt");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.show();
	}

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(m.getSzerokosc()*POWIEKSZENIE,m.getWysokosc()*POWIEKSZENIE);
		root.getChildren().add(elementyGrupy);
		Map<Wspolrzedne,ElementLabiryntu> mapa = m.getListaElementow();
		for(Wspolrzedne wsp : mapa.keySet()) {
			elementyGrupy.getChildren().add(new Kwadrat(mapa.get(wsp).getKolor(), wsp.getY(),wsp.getX()));
		}
		elementyGrupy.getChildren().add(new Kwadrat(m.getPostac().getKolor(), m.getPostac().getPunkt().getY(), m.getPostac().getPunkt().getX()));
		return root;
	}

}
