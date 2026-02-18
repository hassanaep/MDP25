package es.unex.cume.mdp.ef3.modelo.mesa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import es.unex.cume.mdp.ef3.modelo.casino.Usuario;
/**
 * MesaClasicaAL: clase derivada de la clase MesaClasica que contiene la ruleta y el tablero e implementa los métodos de la interface IMesa
 */
public class MesaClasicaAL extends MesaClasica {

	protected List <NumeroRuleta> ruleta;
	protected List <NumeroTablero> tablero;
	
	/**
	 * Constructor por defecto de la clase MesaClasicaAL que inicializa los atributos
	 * con sus valores por defecto y llama al constructor por defecto de la clase base
	 */
	public MesaClasicaAL() {
		super();
		ruleta = new ArrayList<NumeroRuleta>();
		tablero = new ArrayList<NumeroTablero>();
	}
	

	/**
	 * Constructor parametrizado de la clase MesaClasicaAL que inicializa los atributos
	 * e inicializa el constructor parametrizado de la clase base con los valores dados por parámetro 
	 * @param id identificador de la mesa 
	 * @param precio precio de la mesa
	 */
	public MesaClasicaAL(int id, float precio) {
		super(id, precio);
		ruleta = new ArrayList<NumeroRuleta>();
		tablero = new ArrayList<NumeroTablero>();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Método que devuelve la lista de la ruleta
	 * @return ruleta
	 */
	public List<NumeroRuleta> getRuleta() {
		return ruleta;
	}

	/**
	 * Método que modifica la lista de la ruleta por el parámetro dado
	 * @param ruleta
	 */
	public void setRuleta(List<NumeroRuleta> ruleta) {
		this.ruleta = ruleta;
	}

	/**
	 * Método que devuelve la lista del tablero
	 * @return tablero
	 */
	public List<NumeroTablero> getTablero() {
		return tablero;
	}

	/**
	 * Método que modifica la lista del tablero por el parámetro dado
	 * @param tablero
	 */
	public void setTablero(List<NumeroTablero> tablero) {
		this.tablero = tablero;
	}

	/**
	 * Método que se de realizar el proceso de la creación de la mesa
	 * @param p: precio de la mesa
	 */
	@Override
	public boolean crear(float p) {
		// TODO Auto-generated method stub
		NumeroRuleta n = null; 
		NumeroTablero nt = null; 
		for (int i = MesaClasicaAL.MINVALOR; i <= MAXVALOR; i++) { 
			// Entre los n meros del 1 al 10 y del 19 al 28, 6 
			// los n meros pares van en rojo y los impares en negro. 
			if (((i >= 1 && i <= 10) || (i >= 19 && i <= 28)) && (i % 2 == 0)) { 
				 n = new NumeroRuleta(String.valueOf(i), ParImpar.PAR, Color.NEGRO); 
				 nt = new NumeroTablero(String.valueOf(i), ParImpar.PAR, Color.NEGRO, p);
			 } 
			 else if (((i >= 1 && i < 10) || (i >= 19 && i < 28)) && (i % 2 == 1)) { 
				  n = new NumeroRuleta(String.valueOf(i), ParImpar.IMPAR, Color.ROJO); 
				  nt = new NumeroTablero(String.valueOf(i), ParImpar.IMPAR, Color.ROJO, p);
				  } 
			// Entre los n meros del 11 al 18 y del 29 al 36, 15 
			// los n meros pares van en negro y los impares en rojo.
			else if (((i >= 11 && i <= 18) || (i >= 29 && i <= 36)) && (i % 2 == 0)) { 
				 n = new NumeroRuleta(String.valueOf(i), ParImpar.PAR, Color.ROJO); 
				 nt = new NumeroTablero(String.valueOf(i), ParImpar.PAR, Color.ROJO, p); 
				 } else { 
					  n = new NumeroRuleta(String.valueOf(i), ParImpar.IMPAR, Color.NEGRO); 
					  nt = new NumeroTablero(String.valueOf(i), ParImpar.IMPAR, Color.NEGRO, p);
					  }
			// Anadir n al tablero de ruleta
			ruleta.add(n);
			// Anadir nt al tablero de tablero
			tablero.add(nt);
			}
		    nt = new NumeroTablero(ParImpar.PAR.toString(), ParImpar.PAR, Color.NOCOLOR, p); 
		    tablero.add(nt);
		    // Anadir par al tablero 
		    nt = new NumeroTablero(ParImpar.IMPAR.toString(), ParImpar.IMPAR, Color.NOCOLOR, p); 
		    tablero.add(nt);
		    // Anadir impar al tablero 
		    nt = new NumeroTablero(Color.ROJO.toString(), ParImpar.NADA, Color.ROJO, p); 
		    tablero.add(nt);
		    // Anadir rojo al tablero 
		    nt = new NumeroTablero(Color.NEGRO.toString(), ParImpar.NADA, Color.NEGRO, p); 
		    tablero.add(nt);
		    // Anadir negro al tablero 
		    
		    return true;
		
	}

	/**Método que se encarga de que el usuario pueda adherirse a un número en caso de que pueda pagarlo
	 * @param numero
	 * @param u
	 */
	@Override
	public NumeroTablero adherirseNumero(String numero, Usuario u) {
		// TODO Auto-generated method stub
		Iterator<NumeroTablero> it = tablero.iterator();
		NumeroTablero aux = null;
		boolean enc = false;
		while(it.hasNext() && !enc) {
			aux = it.next();
			if(aux.getValor().equals(numero)) {
				enc = true;
			}
		}
		if (enc && (u.getMonedero()>=aux.getPrecio())) {
			return aux;
		}
		return null;
	}

	/**
	 * Metodo que se engrarga de realizar la jugada aleatoria de la ruleta
	 * @return NumeroRuleta
	 */
	@Override
	public NumeroRuleta jugar() {
		// TODO Auto-generated method stub
		Random num = new Random();
		int ale = num.nextInt(MesaClasicaAL.MAXVALOR-MesaClasicaAL.MINVALOR + 1)+MesaClasicaAL.MINVALOR;
		Iterator<NumeroRuleta> it = ruleta.iterator();
		NumeroRuleta aux = null;
		boolean enc = false;
		while(it.hasNext() && !enc) {
			aux = it.next();
			if(Integer.parseInt(aux.getValor())==ale){
				enc = true;
			}
		}
		if (enc) {
			aux.setBola(true);
			return aux;
		}
		return null;
	}

	/**
	 * Metodo que se encarga Buscar y devolver el numero proporcionado en la ruleta
	 * @param numero
	 * @return NumeroRuleta
	 */
	@Override
	public NumeroRuleta getNumeroRuleta(String numero) {
		// TODO Auto-generated method stub
		Iterator<NumeroRuleta> it = ruleta.iterator();
		NumeroRuleta aux = null;
		boolean enc = false;
		while(it.hasNext() && !enc) {
			aux = it.next();
			if(aux.getValor().equals(numero)) {
				enc = true;
			}
		}
		if (enc) {
			return aux;
		}
	
		return null;
	}

	/**
	 * Metodo que se encarga de Buscar y devolver el numero proporcionado en el tablero
	 * @param numero
	 * @return NumeroTablero
	 */
	@Override
	public NumeroTablero getNumeroTablero(String numero) {
		// TODO Auto-generated method stub
		Iterator<NumeroTablero> it = tablero.iterator();
		NumeroTablero aux = null;
		boolean enc = false;
		while(it.hasNext() && !enc) {
			aux = it.next();
			if(aux.getValor().equals(numero)) {
				enc = true;
			}
		}
		if (enc) {
			return aux;
		}
		return null;
		
	}


	/**
	 * Metodo que se encarga de devolver el precio de la apuesta
	 * @return Precio
	 */
	@Override
	public float getPrecioApuesta() {
		// TODO Auto-generated method stub
		
		return MesaClasicaAL.super.getPrecio();
	}

	/**
	 * Metodo que se encarga de modificar el precio de la apuesta
	 * @param p
	 */
	@Override
	public void setPrecioApuesta(float p) {
		// TODO Auto-generated method stub
		MesaClasicaAL.super.setPrecio(p);
		
	}

	/**
	 * Metodo que se encarga de recibir un numero y de seleccionarlo como la bola elegida de la ruleta
	 * @param valor
	 * @return NumeroRuleta
	 */
	@Override
	public NumeroRuleta jugar(String valor) {
		// TODO Auto-generated method stub
		Iterator<NumeroRuleta> it = ruleta.iterator();
		NumeroRuleta aux = null;
		boolean enc = false;
		while(it.hasNext() && !enc) {
			aux = it.next();
			if(aux.getValor().equals(valor)) {
				enc = true;
			}
		}
		if (enc) {
			aux.setBola(true);
			return aux;
		}
		return null;
	}
	
	
	
    
	
}
