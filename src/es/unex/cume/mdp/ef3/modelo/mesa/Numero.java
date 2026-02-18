package es.unex.cume.mdp.ef3.modelo.mesa;


import java.util.Objects;
 
/**
 * Clase abstracta que modela los numeros
 */
public abstract class Numero {

	protected Color Color;
	protected ParImpar ParImpar;
	protected String Valor;
	protected String Imagen;
	
	/**
	 * Constructor por defecto de la clase numero
	 */
	public Numero() {
		Color = es.unex.cume.mdp.ef3.modelo.mesa.Color.NOCOLOR;
		ParImpar = es.unex.cume.mdp.ef3.modelo.mesa.ParImpar.NADA;
		Valor = "00";
		Imagen = "";
	}
	
	/**
	 * Constructor parametrizado de la clase Numero
	 * @param color
	 * @param parImpar
	 * @param valor
	 * @param imagen
	 */
	public Numero(Color color, ParImpar parImpar, String valor, String imagen) {
		Color = color;
		ParImpar = parImpar;
		Valor = valor;
		Imagen = imagen;
	}
	
	
	public Numero(Color color, ParImpar parImpar, String valor) {
		Color = color;
		ParImpar = parImpar;
		Valor = valor;
	}

	/**
	 * Método que devuleve el valor del atributo color
	 * @return Color
	 */
	public Color getColor() {
		return Color;
	}
	
	/**
	 * Método que modifica el valor del atributo Color por el parametro dado
	 * @param color
	 */
	public void setColor(Color color) {
		Color = color;
	}
	/**
	 * Método que devuleve el valor del atributo ParImpar
	 * @return ParImpar
	 */
	public ParImpar getParImpar() {
		return ParImpar;
	}
	
	/**
	 * Método que modifica el valor del atributo ParImpar por el parametro dado
	 * @param parImpar
	 */
	public void setParImpar(ParImpar parImpar) {
		ParImpar = parImpar;
	}
	
	/**
	 * Método que devuleve el valor del atributo Valor
	 * @return Valor
	 */
	public String getValor() {
		return Valor;
	}
	
	/**
	 * Método que modifica el valor del atributo Valor por el parametro dado
	 * @param valor
	 */
	public void setValor(String valor) {
		Valor = valor;
	}
	/**
	 * Método que devuleve el valor del atributo Imagen
	 * @return Imagen
	 */
	public String getImagen() {
		return Imagen;
	}
	/**
	 * Método que modifica el valor del atributo Imagen por el parametro dado
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	/**
	 * Metodo que devuelve un número entero calculado a partir del contenido del objeto Numero
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Color, Imagen, ParImpar, Valor);
	}

	/**
	 * Metodo que compara dos objetos Numero
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		return Color == other.Color && Objects.equals(Imagen, other.Imagen) && ParImpar == other.ParImpar
				&& Objects.equals(Valor, other.Valor);
	}

	/**
	 * Metodo que se encarga de la representación en cadena del objeto Numero
	 */
	@Override
	public String toString() {
		return "Numero [Color=" + Color + ", ParImpar=" + ParImpar + ", Valor=" + Valor + ", Imagen=" + Imagen + "]";
	}
	
	
}
