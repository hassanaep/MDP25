package es.unex.cume.mdp.ef3.modelo.mesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import es.unex.cume.mdp.ef3.modelo.casino.Apuesta;
/**
 * Clase NumeroTablero es un derivada de la clase Numero con un precio del numero y una lista 
 * de apuestas para dicho numero
 */
public class NumeroTablero extends Numero {
    protected float precio;
    private List<Apuesta> lista;  
    
    /**
     * Constructor por defecto de la clase NumeroTablero
     */
	public NumeroTablero() {
		// TODO Auto-generated constructor stub
		super();
		precio = 0f;
		lista = new ArrayList<Apuesta>();
	}

	/**
	 * Constructo Parametrizado de la clase NumeroTablero
	 * @param color
	 * @param parImpar
	 * @param valor
	 * @param imagen
	 * @param precio
	 */
	public NumeroTablero(Color color, ParImpar parImpar, String valor, String imagen, float precio) {
		super(color, parImpar, valor, imagen);
		// TODO Auto-generated constructor stub
		this.precio = precio;
		lista = new ArrayList<Apuesta>();
	}
	
	public NumeroTablero(String valor,ParImpar parImpar,Color color , float precio) {
		super(color, parImpar, valor);
		// TODO Auto-generated constructor stub
		this.precio = precio;
		lista = new ArrayList<Apuesta>();
	}
    //n = new NumeroTablero(ParImpar.IMPAR.toString(), ParImpar.IMPAR, Color.NOCOLOR, p);
	//nt = new NumeroTablero(String.valueOf(i), ParImpar.PAR, Color.NEGRO, p);
	/**
	 * Metodo que devuelve el valor del atributo precio
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Metodo que modifica el valor del atributo precio por el 
	 * parametro dado
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Metodo que devuelve la lista de las apuestas
	 * @return apuestas
	 */
	public List<Apuesta> getLista() {
		return lista;
	}

	/**
	 * Metodo que modifica la lista de las apuestas
	 * @param apuestas
	 */
	public void setLista(List<Apuesta> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo que devuelve un numero calculado en funcion del contenido del objeto NumeroTablero
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(lista, precio);
		return result;
	}

	/**
	 * Metodo que compara dos objetos NumeroTablero
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroTablero other = (NumeroTablero) obj;
		return Objects.equals(lista, other.lista) && Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}

	/**
	 * Metodo que devuelve la representacion del objeto en formato cadena
	 */
	@Override
	public String toString() {
		return "NumeroTablero [precio=" + precio + ", lista=" + lista + "]";
	}
	
	
	

	
}
