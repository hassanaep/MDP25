package es.unex.cume.mdp.ef3.modelo.mesa;

import es.unex.cume.mdp.ef3.modelo.casino.Usuario;
/**
 * Interface IMesa. Interface que se encarga de definir los métodos a implementar
 */
public interface IMesa {
	
    /**
     * Método que se encarga de crear 
     * @param p :Precio
     * @return True or False
     */
	public boolean crear(float p);
	
	/**
	 * Método que devuelve el NumeroTablero del número dado como parámetro en caso de que
	 * el usuario pueda costearlo
	 * @param numero:Valor del numero al que el usuario quiere adherirse
	 * @param u:Usuario 
	 * @return NumeroTablero
	 */
	public NumeroTablero adherirseNumero(String numero, Usuario u);
	
	/**
	 * Metodo que se engrarga de realizar la jugada aleatoria de la ruleta
	 * @return NumeroRuleta
	 */
	public NumeroRuleta jugar();
	
	/**
	 * Metodo que se encarga Buscar y devolver el numero proporcionado en la ruleta
	 * @param numero
	 * @return NumeroRuleta
	 */
	public NumeroRuleta getNumeroRuleta(String numero);
	
	/**
	 * Metodo que se encarga de Buscar y devolver el numero proporcionado en el tablero
	 * @param numero
	 * @return NumeroTablero
	 */
	public NumeroTablero getNumeroTablero(String numero);
	
	
	/**
	 * Metodo que se encarga de devolver el precio de la apuesta
	 * @return float
	 */
	public float getPrecioApuesta();
	
	/**
	 * Metodo que se encarga de modificar el id
	 * @param id
	 */
	public void setId(int id);
	
	/**
	 * Metodo que se encarga de modificar el precio de la apuesta
	 * @param p
	 */
	public void setPrecioApuesta(float p);
	
	/**
	 * Metodo que se encarga de recibir un numero y de seleccionarlo como la bola elegida de la ruleta
	 * @param valor
	 * @return NumeroRuleta
	 */
	public NumeroRuleta jugar(String valor);
}
