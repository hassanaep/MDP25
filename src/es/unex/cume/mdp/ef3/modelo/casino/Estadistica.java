package es.unex.cume.mdp.ef3.modelo.casino;

/**
 * Clase Estadistica. Clase básica que se encarga de realizar las estadísticas de los números
 */
public class Estadistica {

	private int numero;
	private int numVecesApostado;
	private int numGanado;
	private float precioGanado;
	
	/**
	 * Constructor parametrizado de la clase estadístic que se encarga de inicializar los atributos de 
	 * la clase estadída con los valores por defecto
	 */
	public Estadistica() {
		numero=0;
		numVecesApostado=0;
		numGanado = 0;
		precioGanado = 0f;
	}
	
	
	
	/**
	 * Constructor parametrizado de la clase estadístic que se encarga de inicializar los atributos de 
	 * la clase estadída con los valores dados por parámetro
	 * @param numero: número de la estadística
	 * @param numVecesApostado: las veces que se ha apostado el número
	 * @param numGanado: las veces que ha ganado el número
	 * @param precioGanado: las ganancias que ha obtenido el número
	 */
	public Estadistica(int numero, int numVecesApostado, int numGanado, float precioGanado) {
		this.numero = numero;
		this.numVecesApostado = numVecesApostado;
		this.numGanado = numGanado;
		this.precioGanado = precioGanado;
	}



	/**
	 * Método que devuelve el valor del número de la estadística
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * Método que modifica el valor del número de la estadística por el parámetro dado
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Método que devuelve el número de veces que el número ha sido apostado
	 * @return numVecesApostado
	 */
	public int getNumVecesApostado() {
		return numVecesApostado;
	}
	
	/**
	 * Método que modifica el número de veces que el número ha sido apostado por el parámetro dado
	 * @param numVecesApostado
	 */
	public void setNumVecesApostado(int numVecesApostado) {
		this.numVecesApostado = numVecesApostado;
	}
	
	/**
	 * Método que devuelve el número de veces que el número ha ganado
	 * @return numGanado
	 */
	public int getNumGanado() {
		return numGanado;
	}
	
	/**
	 * Método que modifica el número de veces que el número ha ganado por el parámetro dado
	 * @param numGanado
	 */
	public void setNumGanado(int numGanado) {
		this.numGanado = numGanado;
	}
	
	/**
	 * Método que devuelve las ganancias del número
	 * @return precioGanado
	 */
	public float getPrecioGanado() {
		return precioGanado;
	}
	
	/**
	 * Método que modifica las ganancias del número por el parámetro dado
	 * @param precioGanado
	 */
	public void setPrecioGanado(float precioGanado) {
		this.precioGanado = precioGanado;
	}

     
	/**
	 * Método que devuelve la representación en cadena de la clase Estadística
	 */
	@Override
	public String toString() {
		return "Estadistica [numero=" + numero + ", numVecesApostado=" + numVecesApostado + ", numGanado=" + numGanado
				+ ", precioGanado=" + precioGanado + "]";
	}
	
	
	
}
