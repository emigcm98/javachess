package Modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import Auxiliar.Elo.Resultado;

public class Partida {

	private LinkedList<Jugada> jugadas;
	private Usuario blancas;
	private Usuario negras;
	private Resultado resultado;
	
	public Partida(Usuario blancas, Usuario negras) {
		
		jugadas = new LinkedList<Jugada>();
		this.blancas = blancas;
		this.negras = negras;
	}
	
	public boolean addJugada(Jugada j) {
		return jugadas.add(j);
	}
	
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public Resultado getResultado() {
		return resultado;
	}
	
	@Override
	public String toString() {
		int size = jugadas.size();
		
		String res = "";
		for (int i = 0; i < size; i+=2) {
			
			//res += (i/2+1)+". " + jugadas.get(i).toString() + ", "+ jugadas.get(i).toString() +" ";
			res += (i/2+1)+"." + jugadas.get(i).toString();
			try {
				res += " "+ jugadas.get(i+1).toString();
			}
			catch(java.lang.IndexOutOfBoundsException e) {
				
			}
			res += " ";
		}		
		return res;
	}
	
	public String exportToPGN() {
	
		// copy to clipboard??
		if (resultado == null)return null;	
		StringBuilder res = new StringBuilder();
		res.append("[Event \"Informal Game\"]\n");
		res.append("[Site \"Internet, The World COM\"]\n");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println();
		res.append("[Date \""+formatter.format(Calendar.getInstance().getTime())+"\"]\n");
		res.append("[Round \"1\"]\n");
		res.append("[White \""+blancas.getUsername()+"\"]\n");
		res.append("[Black \""+negras.getUsername()+"\"]\n");
		res.append("[WhiteElo \""+blancas.getElo()+"\"]\n");
		res.append("[BlackElo \""+negras.getElo()+"\"]\n");
		res.append("[Annotator \"emigcm98chess\"]\n");
		res.append(toString());
		res.append(resultado.toString());
		return res.toString();
		
	}
}
