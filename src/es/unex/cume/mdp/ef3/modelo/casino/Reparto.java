package es.unex.cume.mdp.ef3.modelo.casino;

import java.util.Objects;

/**
 *Reparto. Clase Básica que representa el reparto de la partida
 */
public class Reparto {

	private float caja;
	private float recaudacion;
	private float resultado;
	private int numApuestas;
	private int numNumero;
	private int numColor;
	private int numPI;
	private float repartoNumero;
	private float repartoColor;
	private float repartoPI;
	
	/**
	 * Constructor por defecto de la clase reparto que inicializa los atributos con 
	 * los valores por defecto
	 */
	public Reparto() {
		this.caja = 0f;
		this.recaudacion = 0f;
		this.resultado = 0f;
		this.numApuestas = 0;
		this.numNumero = 0;
		this.numColor = 0;
		this.numPI = 0;
		this.repartoNumero = 0f;
		this.repartoColor = 0f;
		this.repartoPI = 0f;
	}
	
	/**
	 * Constructor parametrizado de la clase reparto que inicializa los atributos con 
	 * los valores por los valores dados por parámetro
	 * @param caja
	 * @param recaudacion
	 * @param resultado
	 * @param numApuestas
	 * @param numNumero
	 * @param numColor
	 * @param numPI
	 * @param repartoNumero
	 * @param repartoColor
	 * @param repartoPI
	 */
	public Reparto(float caja, float recaudacion, float resultado, int numApuestas, int numNumero, int numColor,
			int numPI, float repartoNumero, float repartoColor, float repartoPI) {
		this.caja = caja;
		this.recaudacion = recaudacion;
		this.resultado = resultado;
		this.numApuestas = numApuestas;
		this.numNumero = numNumero;
		this.numColor = numColor;
		this.numPI = numPI;
		this.repartoNumero = repartoNumero;
		this.repartoColor = repartoColor;
		this.repartoPI = repartoPI;
	}
	
	/**
	 * Método que devuelve el valor de la caja del reparto
	 * @return caja
	 */
	public float getCaja() {
		return caja;
	}
	
	/**
	 * Método que modifica el valor de la caja del reparto por el parámetro dado
	 * @param caja
	 */
	public void setCaja(float caja) {
		this.caja = caja;
	}
	
	/**
	 * Método que devuelve el valor de la recaudacion del reparto
	 * @return recaudacion
	 */
	public float getRecaudacion() {
		return recaudacion;
	}
	
	/**
	 * Método que modifica el valor de la recaudacion del reparto por parámetro dado
	 * @param recaudacion
	 */
	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}
	
	/**
	 * Método que devuelve el valor del resultado del reparto
	 * @return resultado
	 */
	public float getResultado() {
		return resultado;
	}
	
	/**
	 * Método que modifica el valor del resultado del reparto por el parámetro dado
	 * @param resultado
	 */
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * Método que devuelve el valor del número de apuestas del reparto
	 * @return numApuestas
	 */
	public int getNumApuestas() {
		return numApuestas;
	}
	
	/**
	 * Método que modifica el valor del número de apuestas del reparto por el parámetro dado
	 * @param numApuestas
	 */
	public void setNumApuestas(int numApuestas) {
		this.numApuestas = numApuestas;
	}
	
	/**
	 * Método que devuelve el valor del número de número del reparto
	 * @return numNumero
	 */
	public int getNumNumero() {
		return numNumero;
	}
	
	/**
	 * Método que modifica el valor del número de número del reparto por el parámetro dado
	 * @param numNumero
	 */
	public void setNumNumero(int numNumero) {
		this.numNumero = numNumero;
	}
	
	/**
	 * Método que devuelve el valor del número de Color del reparto
	 * @return numColor
	 */
	public int getNumColor() {
		return numColor;
	}
	
	/**
	 * Método que modifica el valor del número de Color del reparto por el dado por parámetro
	 * @param numColor
	 */
	public void setNumColor(int numColor) {
		this.numColor = numColor;
	}
	
	/**
	 * Método que devuelve el valor del número de ParImpar del reparto
	 * @return numPI
	 */
	public int getNumPI() {
		return numPI;
	}
	
	/**
	 * Método que modifica el valor del número de ParImpar del reparto por el dado por parámetro
	 * @param numPI
	 */
	public void setNumPI(int numPI) {
		this.numPI = numPI;
	}
	
	/**
	 * Método que devuelve el valor del Reparto de número
	 * @return repartoNumero
	 */
	public float getRepartoNumero() {
		return repartoNumero;
	}
	
	/**
	 * Método que modifica el valor del Reparto de número por el parámetro dado
	 * @param repartoNumero
	 */
	public void setRepartoNumero(float repartoNumero) {
		this.repartoNumero = repartoNumero;
	}
	
	/**
	 * Método que devuelve el valor del Reparto de Color
	 * @return repartoColor
	 */
	public float getRepartoColor() {
		return repartoColor;
	}
	
	/**
	 * Método que modifica el valor del Reparto de Color por el parámetro dado
	 * @param repartoColor
	 */
	public void setRepartoColor(float repartoColor) {
		this.repartoColor = repartoColor;
	}
	
	/**
	 * Método que devuelve el valor del Reparto de ParImpar
	 * @return repartoPI
	 */
	public float getRepartoPI() {
		return repartoPI;
	}
	
	/**
	 * Método que modifica el valor del Reparto de ParImpar por el parámetro dado
	 * @param repartoPI
	 */
	public void setRepartoPI(float repartoPI) {
		this.repartoPI = repartoPI;
	}
	
	/**
	 * Metodo que devuelve un número entero calculado a partir del contenido del objeto Reparto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(caja, numApuestas, numColor, numNumero, numPI, recaudacion, repartoColor, repartoNumero,
				repartoPI, resultado);
	}
	/**
	 * Método que compara dos objetos para ver si son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparto other = (Reparto) obj;
		return Float.floatToIntBits(caja) == Float.floatToIntBits(other.caja) && numApuestas == other.numApuestas
				&& numColor == other.numColor && numNumero == other.numNumero && numPI == other.numPI
				&& Float.floatToIntBits(recaudacion) == Float.floatToIntBits(other.recaudacion)
				&& Float.floatToIntBits(repartoColor) == Float.floatToIntBits(other.repartoColor)
				&& Float.floatToIntBits(repartoNumero) == Float.floatToIntBits(other.repartoNumero)
				&& Float.floatToIntBits(repartoPI) == Float.floatToIntBits(other.repartoPI)
				&& Float.floatToIntBits(resultado) == Float.floatToIntBits(other.resultado);
	}
	/**
	 * Metodo que devuelve la representacion en formato cadena de la clase Reparto
	 */
	@Override
	public String toString() {
		return "Reparto [caja=" + caja + ", recaudacion=" + recaudacion + ", resultado=" + resultado + ", numApuestas="
				+ numApuestas + ", numNumero=" + numNumero + ", numColor=" + numColor + ", numPI=" + numPI
				+ ", repartoNumero=" + repartoNumero + ", repartoColor=" + repartoColor + ", repartoPI=" + repartoPI
				+ "]";
	}
	
	
}
