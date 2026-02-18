package es.unex.cume.mdp.ef3.modelo.mesa;
/**
 * MesaClasica. Clase abstracta que implementa IMesa 
 */
public abstract class MesaClasica implements IMesa {

	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 36;
	protected int id;
	protected float precio;
	protected String bola;
	
	/**
	 * Constructor por defecto de la clase MesaClasica que inicializa los atributos con valores por defecto
	 */
	public MesaClasica() {
		id = 0;
		precio =0f;
	}
	
	/**Constructor parametrizado de la clase MesaClasica que inicializa los atributos con valores dados por parámetro
	 * @param id: identificador de la mesa
	 * @param precio: precio de la mesa
	 */
	public MesaClasica(int id, float precio) {
		this.id = id;
		this.precio = precio;
	}

	/**
	 * Método que devuelve el identificador de la mesa
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método que modifica el identificador de la mesa por el parámetro dado
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método que devuelve el valor del atributo precio
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * Metodo que modifica el valor del precio de la mesa dado el parametro dado
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Método que devuelve el número donde se ha caído la bola, una vez se juega
	 * @return bola
	 */
	public String getBola() {
		return bola;
	}
	
	/**
	 * Método que modifica el número de la bola por el parámetro dado
	 * @param bola
	 */
	public void setBola(String bola) {
		this.bola = bola;
	}
	
	/**
	 * Método que devuelve el valor de la constante Minvalor
	 * @return MINVALOR
	 */
	public static int getMinvalor() {
		return MINVALOR;
	}
	
	/**
	 * Método que devuelve el valor de la constante MAXVALOR
	 * @return MAXVALOR
	 */
	public static int getMaxvalor() {
		return MAXVALOR;
	}
	
	
}
