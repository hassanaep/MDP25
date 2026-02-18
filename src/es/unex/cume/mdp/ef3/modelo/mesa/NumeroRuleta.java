package es.unex.cume.mdp.ef3.modelo.mesa;

import java.util.Objects;
/**
 * Clase NumeroRuleta es una clase derivada de la clase numero que se compone de un valor booleano que 
 * indica si es el numero ganador
 */
public class NumeroRuleta extends Numero{
    
	private boolean bola;
	
	/**
	 * Constructor por defecto de la clase NumeroRuleta
	 */
	public NumeroRuleta() {
		// TODO Auto-generated constructor stub
		super();
		bola = false;
	}

	/**
	 * Constructor parametrizado de la clase NumeroRuleta
	 * @param color
	 * @param parImpar
	 * @param valor
	 * @param imagen
	 * @param bola
	 */
	public NumeroRuleta(es.unex.cume.mdp.ef3.modelo.mesa.Color color, es.unex.cume.mdp.ef3.modelo.mesa.ParImpar parImpar, String valor, String imagen,boolean bola) {
		super(color, parImpar, valor, imagen);
		// TODO Auto-generated constructor stub
		this.bola = bola;
		
	}

	public NumeroRuleta(String valor, es.unex.cume.mdp.ef3.modelo.mesa.ParImpar parImpar,es.unex.cume.mdp.ef3.modelo.mesa.Color color) {
		super(color, parImpar, valor);
		// TODO Auto-generated constructor stub	
	}
	
	//n = new NumeroRuleta(String.valueOf(i), ParImpar.PAR, Color.NEGRO); 
	/**
	 * Metodo que devuelve el valor booleano del atributo bola
	 * @return bola
	 */
	public boolean isBola() {
		return bola;
	}

	/**
	 * Metodo que modifica el valor del atributo bola por el parametro dado
	 * @param bola
	 */
	public void setBola(boolean bola) {
		this.bola = bola;
	}

	/**
	 * Metodo que devuelve un número entero calculado a partir del contenido del objeto NumeroRuleta
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bola);
		return result;
	}

	/**
	 * Metodo que compara dos objetos NumeroRuleta
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroRuleta other = (NumeroRuleta) obj;
		return bola == other.bola;
	}

	/**
	 * Metodo que muestra la representacion en cadena del objeto NumeroRuleta
	 */
	@Override
	public String toString() {
		return "NumeroRuleta [bola=" + bola + "]";
	}
    
	
	

}
