package Controlador;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DAO.AbsFactoriaDAO;
import DAO.DAOException;
import DAO.FactoriaDAO;
import Modelo.Usuario;

public class ControladorPartida extends Thread{

	private Usuario blancas;
	private Usuario negras;
	private boolean is_blancas; // indica si el jugador de este controlador es blancas o negras
	
	private ServerSocket ss;
	private Socket s; // al que acepta
	private DataInputStream is;
	private DataOutputStream os;
	BufferedReader in;
	
	private static ControladorPartida controlador;
	private AbsFactoriaDAO factoria;
	
	private ControladorPartida() {
		blancas = null;
		negras = null;
		
		
		try {
			factoria = FactoriaDAO.getInstancia();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static ControladorPartida getUnicaInstancia() {
		if (controlador == null) controlador = new ControladorPartida();
		return controlador;
	}
	/*
	// si se hace esto, este controlador hará de servidor
	public Boolean hostear(Usuario user, int puerto) {
		
		// el host hace el sorteo
		// si null es que ha fallado la conexión
		// si true es que ha tocado blancas y false negras
		
		try {
			ss = new ServerSocket(puerto);
			
			s = ss.accept(); // bloqueamos hasta encontrar pareja
			is = new DataInputStream(s.getInputStream());
			os = new DataOutputStream(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(is));
			hostMandaUsuario();
			
		} catch (IOException e) {
			System.err.println("No se ha podido hostear en ese puerto");
			return null;
		}
		int n = (int) Math.floor(Math.random()*9+1);
		
		if (n%2 == 0) {
			blancas = user;
			return true;
		}
		else {
			negras = user;
			return false;
		}
		
	}
	
	// si se hace esto, este controlador hará de cliente
	public Boolean conectar(Usuario user, InetAddress address, int puerto) {
		
		try {
			s = new Socket(address, puerto);
			is = new DataInputStream(s.getInputStream());
			os = new DataOutputStream(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(is));
			clienteMandaUsuario(user);
		} catch (IOException e) {
			System.err.println("No se ha podido conectar al host especificado");
			return null;
		}
		
		return false;
	}
	
	// procesar lo que le ha mandado
	private void procesarLectura(String result) {
		
		
	}
	
	@Override
	public void run() {
		
		boolean running = true;

		
		while (running) {
			
			String result = "";
			
			try {
				char c = (char) in.read();
				while (c!=-1) {
					result += c;
					c = (char) in.read();
				}	
			} catch (IOException e1) {
				System.err.println("Error de lectura");
				running = false;
				continue;
			}
			
			procesarLectura(result);
			
			//se hace jugada (se bloquea hasta entonces) MIRAR
			String jugada =  // se enviará un json 
			
			//luego escribir
			os.write(jugada);
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // refresco cada segundo
			
		}
		
		
		try {
			ss.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el socket");
			//e.printStackTrace();
		} 
	}*/
}

