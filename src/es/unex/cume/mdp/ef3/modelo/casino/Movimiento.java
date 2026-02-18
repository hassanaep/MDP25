package es.unex.cume.mdp.ef3.modelo.casino;

import java.util.Date;
import java.util.Objects;

/**
 * Clase Movimiento. clase que se ebcarga de modelar cualquier movimiento 
 * monetario que se realiza
 */
public class Movimiento {

	private String info;
	private float monederoActual;
	private float valor;
	private Date fecha;
	
	
	/**
	 * Constructor por defecto de la clase Movimiento
	 */
	public Movimiento() {
		info = "";
		monederoActual =0f;
		valor = 0f;
		fecha = new Date();
	}
	
	/**
	 * Constructor parametrizado de la clase Movimiento
	 * @param info
	 * @param monederoActual
	 * @param valor
	 * @param fecha
	 */
	public Movimiento(String info, float monederoActual, float valor, Date fecha) {
		this.info = info;
		this.monederoActual = monederoActual;
		this.valor = valor;
		this.fecha = fecha;
	}
	
	public Movimiento(float monederoActual, float valor, Date fecha) {
		this.monederoActual = monederoActual;
		this.valor = valor;
		this.fecha = fecha;
	}


	/**
	 * Metodo que devuelve el valor del atributo info
	 * @return info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Metodo que modifica el valor del atributo info dado el parametro
	 * @param info
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Metodo que devuelve el valor del atributo monederoActual
	 * @return monederoActual
	 */
	public float getMonederoActual() {
		return monederoActual;
	}

	/**
	 * Metodo que modifica el valor del atributo monederoActual dado el parametro
	 * @param monederoActual
	 */
	public void setMonederoActual(float monederoActual) {
		this.monederoActual = monederoActual;
	}

	/**
	 * Metodo que devuelve el valor del atributo valor
	 * @return valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Metodo que modifica el valor del atributo valor dado el parametro
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que devuelve el valor del atributo fecha
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo que modifica el valor del atributo fecha dado el parametro
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo que devuelve un número entero calculado a partir del contenido del objeto Movimiento
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fecha, info, monederoActual, valor);
	}

	/**
	 * Metodo que compara dos objetos Movimieto
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(info, other.info)
				&& Float.floatToIntBits(monederoActual) == Float.floatToIntBits(other.monederoActual)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}

	/**
	 * Metodo que devuelve la representacion en formato cadena del objeto Movimiento
	 */
	@Override
	public String toString() {
		return "Movimiento [info=" + info + ", monederoActual=" + monederoActual + ", valor=" + valor + ", fecha="
				+ fecha + "]";
	}
	
	
	
	
}
