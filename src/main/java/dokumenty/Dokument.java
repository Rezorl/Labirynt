package dokumenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import elementyLabiryntu.Czar;
import elementyLabiryntu.ElementLabiryntu;
import elementyLabiryntu.Postac;
import fabryki.FabrykaElementow;
import fabryki.MenadzerFabryk;
import silnikGry.Wspolrzedne;

public abstract class Dokument {
	public final static String POKOJ= "pokoj";
	public final static String WYSOKI_POKOJ= "wysokiPokoj";
	public final static String KLUCZ= "klucz";
	public final static String DRZWI= "drzwi";
	public final static String POSTAC= "postac";
	public final static String CZAR= "czar";
	protected int xMapy;
	protected int yMapy;
	protected String rodzajFabrykiElementow;
	protected FabrykaElementow fabrykaElementow;
	protected MenadzerFabryk menadzerFabryk;
	protected String nazwaPliku;
	protected FileReader fileReader;
	protected BufferedReader bufferedReader;
	protected Map<Wspolrzedne,ElementLabiryntu> listaElementow;
	protected Map<Wspolrzedne,ElementLabiryntu> listaScian;
	protected Map<Wspolrzedne,ElementLabiryntu> listaPokoi;
	protected Map<Wspolrzedne,ElementLabiryntu> listaDrzwi;
	protected Map<Wspolrzedne,ElementLabiryntu> listaKluczy;
	protected Map<Wspolrzedne,Postac> listaPostaci;
	protected Postac postac;
	protected Map<Integer,Czar> listaCzarow;
	
	public Map<Wspolrzedne, ElementLabiryntu> getListaScian() {
		return listaScian;
	}
	public void setListaScian(Map<Wspolrzedne, ElementLabiryntu> listaScian) {
		this.listaScian = listaScian;
	}
	public Map<Wspolrzedne, ElementLabiryntu> getListaPokoi() {
		return listaPokoi;
	}
	public void setListaPokoi(Map<Wspolrzedne, ElementLabiryntu> listaPokoi) {
		this.listaPokoi = listaPokoi;
	}
	public Map<Wspolrzedne, ElementLabiryntu> getListaDrzwi() {
		return listaDrzwi;
	}
	public void setListaDrzwi(Map<Wspolrzedne, ElementLabiryntu> listaDrzwi) {
		this.listaDrzwi = listaDrzwi;
	}
	public Map<Wspolrzedne, ElementLabiryntu> getListaKluczy() {
		return listaKluczy;
	}
	public void setListaKluczy(Map<Wspolrzedne, ElementLabiryntu> listaKluczy) {
		this.listaKluczy = listaKluczy;
	}
	public Map<Wspolrzedne, Postac> getListaPostaci() {
		return listaPostaci;
	}
	public void setListaPostaci(Map<Wspolrzedne, Postac> listaPostaci) {
		this.listaPostaci = listaPostaci;
	}
	public String getRodzajFabrykiElementow() {
		return rodzajFabrykiElementow;
	}
	public void setRodzajFabrykiElementow(String rodzajFabrykiElementow) {
		this.rodzajFabrykiElementow = rodzajFabrykiElementow;
	}
	public int getxMapy() {
		return xMapy;
	}
	public void setxMapy(int xMapy) {
		this.xMapy = xMapy;
	}
	public int getyMapy() {
		return yMapy;
	}
	public void setyMapy(int yMapy) {
		this.yMapy = yMapy;
	}
	public String getNazwaPliku() {
		return nazwaPliku;
	}
	public void setNazwaPliku(String nazwaPliku) {
		this.nazwaPliku = nazwaPliku;
	}
	public FabrykaElementow getFabrykaElementow() {
		return fabrykaElementow;
	}
	public void setFabrykaElementow(FabrykaElementow fabrykaElementow) {
		this.fabrykaElementow = fabrykaElementow;
	}
	public MenadzerFabryk getMenadzerFabryk() {
		return menadzerFabryk;
	}
	public void setMenadzerFabryk(MenadzerFabryk menadzerFabryk) {
		this.menadzerFabryk = menadzerFabryk;
	}
	public Map<Wspolrzedne, ElementLabiryntu> wezELementyLabiryntu() {
		return listaElementow;
	}
	public Postac getPostac() {
		return postac;
	}
	public void setPostac(Postac postac) {
		this.postac = postac;
	}
	protected abstract void wczytajDane() throws FileNotFoundException, IOException;
}
