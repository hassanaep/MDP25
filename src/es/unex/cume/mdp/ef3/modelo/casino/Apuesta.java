package es.unex.cume.mdp.ef3.modelo.casino;

import java.util.Date;

import es.unex.cume.mdp.ef3.modelo.mesa.NumeroTablero;
import es.unex.cume.mdp.ef3.modelo.partida.Partida;
/**
 * Clase Apuesta. Clase basica que modela una apuesta en el casino
 */
public class Apuesta {

	private Date fecha;
	private float valor;
	private NumeroTablero nt;
	private float resultado;
	private Partida partida;
	private Usuario usuario;
	
	/**
	 * Constructor por defecto de la clase apuesta que inicializa los atributos por los valores por defecto
	 */
	public Apuesta() {
		fecha = new Date();
		valor = 0f;
		nt = null;
		partida = null;
		usuario = null;
		resultado = 0f;
	}
	
	/**
	 * Constructor parametrizado de la clase apuesta que inicializa los atributos por los valores dados por parámetro 
	 * @param fecha: fecha de la apuesta
	 * @param valor: valor o precio de la apuesta
	 * @param nt: numeroTablero asociado a la apuesta
	 * @param resultado: resultado de la apuesta
	 */
	public Apuesta(Date fecha, float valor, NumeroTablero nt, float resultado) {
		this.fecha = fecha;
		this.valor = valor;
		this.nt = nt;
		this.resultado = resultado;
		
	}
	
	/**
	 * Constructor parametrizado de la clase apuesta que inicializa los atributos por los valores dados por parámetro 
	 * @param fecha: fecha de la apuesta
	 * @param nt: numeroTablero asociado a la apuesta
	 * @param usuario: usuario que realiza la apuesta
	 * @param valor: valor o precio de la apuesta
	 */
	public Apuesta(Date fecha, NumeroTablero nt,Usuario usuario,float valor) {
		this.fecha = fecha;
		this.valor = valor;
		this.nt = nt;
	    this.usuario = usuario;
	    
		
	}

	/**
	 * Método que devuel la fecha de la apuesta
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
    /**
     * Método que modifica la fecha de la apuesta por la del parámetro dado
     * @param fecha
     */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
    /**
     * Método que devuelve el valor de la apuesta
     * @return valor
     */
	public float getValor() {
		return valor;
	}
 
	
	/**
	 * Método que modifica el valor de la apuesta por el parámetro dado
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * Método que devuelve el NumeroTablero asociado a la apuesta
	 * @return nt
	 */
	public NumeroTablero getNt() {
		return nt;
	}

	/**
	 *  Método que modifica el NumeroTablero asociado a la apuesta por el parámetro dado
	 * @param nt
	 */
	public void setNt(NumeroTablero nt) {
		this.nt = nt;
	}

	/**
	 * Método que devuelve el resultado de la apuesta
	 * @return resultado
	 */
	public float getResultado() {
		return resultado;
	}

	/**
	 * Método que modifica el resultado de la apuesta por el parámetro dado
	 * @param resultado
	 */
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	/**
	 * Método que devuelve la partida asociada a la apuesta
	 * @return partida
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * Método que modifica la partida asociada a la apuesta por el parámetro dado
	 * @param partida
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * Método que devuelve el usuario que ha realizado la apuesta
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Método que modifica el usuario que ha realizado la apuesta por el parámetro dado
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método que devuelve una representación en cadena de la clase Apuesta
	 */
	@Override
	public String toString() {
		return "Apuesta [fecha=" + fecha + ", valor=" + valor + ", resultado=" + resultado +  "]";
	}
	
	
	
}
