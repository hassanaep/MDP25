package es.unex.cume.mdp.ef3.modelo.casino;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Usuario. Clase que contiene la información del usuario y que se encuatra formada
 * por los distintos movimiento monetarios que haya realizado (lista de Movimiento), tanto al cargar 
 * el monedero como al jugar o repartir premios. Además tiene una composición Naria con Apuestas 
 * (que recoge todas las apuestas realizadas y solo es necesario el método addApuesta) y una composición
 *  unaria con EstadísticaJugador, actualizadas cuando se adhiere a una partida o se juega la partida.
 */
public class Usuario {
   
	protected String nick;
	protected String nombre;
	protected String password;
	protected float monedero;
	protected transient List<Movimiento> historico;
	protected List<Apuesta>apuestas;
	protected EstadisticaJugador ej;
	
	/**
	 * Constructor por defecto de la clase Usuario que inicializa los atributos con los valores 
	 * por defecto
	 */
	public Usuario() {
		this.nick = "";
		this.nombre = "";
		this.password = "";
		this.monedero = 0f;
		this.historico = new LinkedList<Movimiento>();
		this.apuestas = new LinkedList<Apuesta>();
		this.ej = null;
	}
	
	/**
	 * Constructor parametrizado de la clase Usuario que inicializa los atributos con los valores 
	 * dados por parámetro
	 * @param nick: nick del usuario
	 * @param nombre: nombre del usuario
	 * @param password: contraseña del usuario
	 * @param monedero: monedero del usuario
	 */
	public Usuario(String nick, String nombre, String password, float monedero) {
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.monedero = monedero;
		this.historico = new LinkedList<Movimiento>();
		this.apuestas = new LinkedList<Apuesta>();
		this.ej = new EstadisticaJugador();
	}
	

	/**
	 * Método que devuelve el nick del usuario
	 * @return nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * Método que modifica el nick del usuario
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * Método que devuelve el nombre del usuario
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que modifica el nombre del usuario por el dado por parámetro
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve la contraseña del usuario
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método que modifica la contraseña del usuario por el dado por parámetro
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Método que devuelve el monedero del usuario 
	 * @return monedero
	 */
	public float getMonedero() {
		return monedero;
	}

	/**
	 * Método que modifica el monedero del usuario por el dado por parámetro
	 * @param monedero
	 */
	public void setMonedero(float monedero) {
		this.monedero = monedero;
	}

	/**
	 * Método que devuelve la lista de los movimientos monetarios del usuario 
	 * @return historico
	 */
	public List<Movimiento> getHistorico() {
		return historico;
	}

	/**
	 * Método que modifica la lista de los movimientos monetarios del usuario por la dada por parámetro
	 * @param historico
	 */
	public void setHistorico(List<Movimiento> historico) {
		this.historico = historico;
	}

	/**
	 * Método que devuelve la lista de las apuestas realizadas por el usuario 
	 * @return apuestas 
	 */
	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	/**
	 * Método que modifica la lista de las apuestas realizadas por el usuario por las dada por parámetro
	 * @param apuestas
	 */
	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * Método que devuelve la estadística del usuario
	 * @return ej
	 */
	public EstadisticaJugador getEj() {
		return ej;
	}

	/**
	 * Método que modifica la estadística del usuario por la dada por parámetro
	 * @param ej
	 */
	public void setEj(EstadisticaJugador ej) {
		this.ej = ej;
	}
	
	/**
	 * Método que se encarga de añadir apuestas a la lista de apuestas del usuario
	 * @param ap: apuesta a añadir
	 * @return
	 */
	public boolean addApuesta(Apuesta ap) {
		Iterator <Apuesta>it = apuestas.iterator();
		boolean enc = false;
		while(it.hasNext() && !enc) {
			Apuesta aux = (Apuesta) it.next();
			if(aux.getFecha().after(ap.getFecha())) {
				enc = true;
			}
		}
		if(!enc) return apuestas.add(ap);
		
		return false;
		
	}
	
}
