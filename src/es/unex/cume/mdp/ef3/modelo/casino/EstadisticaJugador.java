package es.unex.cume.mdp.ef3.modelo.casino;

import java.util.Objects;

/**
 * EstadicaJugador. clase básica que representa las estadísticas del jugador
 */
public class EstadisticaJugador {

	protected int numJugadas;
	protected int numGanadas;
	protected int numPerdidas;
	protected float dineroGanado;
	protected float dineroPerdido;
	protected int numColor;
	protected int numPI;
	protected int numNumero;
	
	/**
	 * Constructor por defecto que inicializa los atributos de la clase con los valores por defecto
	 */
	public EstadisticaJugador() {
		numJugadas = 0;
		numGanadas = 0;
		numPerdidas = 0;
		dineroGanado = 0f;
		dineroPerdido = 0f;
		numColor = 0;
		numPI = 0;
		numNumero = 0;
	}
	
	
	/**
	 * Constructor parametrizado que inicializa los valores de los atributos de lla clase por los parámetros dados
	 * @param numJugadas: numero de jugadas
	 * @param numGanadas: numero de juegos ganados
	 * @param numPerdidas: numero de juegos perdidos
	 * @param dineroGanado: Cantidad de dinero ganado
	 * @param dineroPerdido: Cantidad de dinero perdido
	 * @param numColor: numero de numColor apostado
	 * @param numPI:numero de numParImpar apostado
	 * @param numNumero:numero de numNumero apostado
	 */
	public EstadisticaJugador(int numJugadas, int numGanadas, int numPerdidas, float dineroGanado, float dineroPerdido,
			int numColor, int numPI, int numNumero) {
		this.numJugadas = numJugadas;
		this.numGanadas = numGanadas;
		this.numPerdidas = numPerdidas;
		this.dineroGanado = dineroGanado;
		this.dineroPerdido = dineroPerdido;
		this.numColor = numColor;
		this.numPI = numPI;
		this.numNumero = numNumero;
	}


	/**
	 * Método que devuelve el numero de jugadas
	 * @return numJugadas
	 */
	public int getNumJugadas() {
		return numJugadas;
	}

    /**
     * Método que modifica el numero de jugadas por el parámetro dado 
     * @param numJugadas
     */
	public void setNumJugadas(int numJugadas) {
		this.numJugadas = numJugadas;
	}


	/**
	 * Método que devuelve el número de apuestas ganadas
	 * @return numGanadas
	 */
	public int getNumGanadas() {
		return numGanadas;
	}


	/**
	 * Método que modifica el número de apuestas ganadas por el parámetro dado
	 * @param numGanadas
	 */
	public void setNumGanadas(int numGanadas) {
		this.numGanadas = numGanadas;
	}

    /**
     * Método que devuelve el número de apuestas perdidas
     * @return numPerdidas
     */
	public int getNumPerdidas() {
		return numPerdidas;
	}

    /**
     * Método que modifica el número de apuestas perdidas por el parámetro dado
     * @param numPerdidas
     */
	public void setNumPerdidas(int numPerdidas) {
		this.numPerdidas = numPerdidas;
	}

    /**
     * Método que devuelve la cantidad del dinero ganado
     * @return dineroGanado
     */
	public float getDineroGanado() {
		return dineroGanado;
	}

    /**
     * Método que modifica la cantidad del dinero ganado por el parámetro dado
     * @param dineroGanado
     */
	public void setDineroGanado(float dineroGanado) {
		this.dineroGanado = dineroGanado;
	}

    /**
     * Método que devuelve la cantidad del dinero perdido
     * @return dineroPerdido
     */
	public float getDineroPerdido() {
		return dineroPerdido;
	}


	/**
	 * Método que modifica la cantidad del dinero perdido por el parámetro dado
	 * @param dineroPerdido
	 */
	public void setDineroPerdido(float dineroPerdido) {
		this.dineroPerdido = dineroPerdido;
	}


	/**
	 * Método que devuelve la cantidad de numColor apostados
	 * @return numColor
	 */
	public int getNumColor() {
		return numColor;
	}


	/**
	 * Método que modifica la cantidad de numColor apostados por el parámetro dado
	 * @param numColor
	 */
	public void setNumColor(int numColor) {
		this.numColor = numColor;
	}


	/**
	 * Método que devuelve la cantidad de numParImpar apostados
	 * @return numPI
	 */
	public int getNumPI() {
		return numPI;
	}


	/**
	 * Método que modifica la cantidad de numParImpar apostados por el parámetro dado
	 * @param numPI
	 */
	public void setNumPI(int numPI) {
		this.numPI = numPI;
	}


	/**
	 * Método que devuelve la cantidad de numNumero apostados
	 * @return numNumero
	 */
	public int getNumNumero() {
		return numNumero;
	}


	/**
	 * Método que modifica la cantidad de numNumero apostados por el parámetro dado
	 * @param numNumero
	 */
	public void setNumNumero(int numNumero) {
		this.numNumero = numNumero;
	}
	
	

    /**
     * Metodo que devuelve un número entero calculado a partir del contenido del objeto EstadisticaJugador
     */
    @Override
	public int hashCode() {
		return Objects.hash(dineroGanado, dineroPerdido, numColor, numGanadas, numJugadas, numNumero, numPI,
				numPerdidas);
	}

    /**
     * Metodo que compara dos objetos para ver si son iguales
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticaJugador other = (EstadisticaJugador) obj;
		return Float.floatToIntBits(dineroGanado) == Float.floatToIntBits(other.dineroGanado)
				&& Float.floatToIntBits(dineroPerdido) == Float.floatToIntBits(other.dineroPerdido)
				&& numColor == other.numColor && numGanadas == other.numGanadas && numJugadas == other.numJugadas
				&& numNumero == other.numNumero && numPI == other.numPI && numPerdidas == other.numPerdidas;
	}


	/**
     * Método que devuelve la representación en formato cadena de la clase EstadisticaJugador
     */
	@Override
	public String toString() {
		return "EstadisticaJugador [numJugadas=" + numJugadas + ", numGanadas=" + numGanadas + ", numPerdidas="
				+ numPerdidas + ", dineroGanado=" + dineroGanado + ", dineroPerdido=" + dineroPerdido + ", numColor="
				+ numColor + ", numPI=" + numPI + ", numNumero=" + numNumero + "]";
	}
	
	
	
}
