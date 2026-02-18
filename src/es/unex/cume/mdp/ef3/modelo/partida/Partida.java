package es.unex.cume.mdp.ef3.modelo.partida;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import es.unex.cume.mdp.ef3.modelo.casino.Apuesta;
import es.unex.cume.mdp.ef3.modelo.casino.Movimiento;
import es.unex.cume.mdp.ef3.modelo.casino.Reparto;
import es.unex.cume.mdp.ef3.modelo.casino.Usuario;
import es.unex.cume.mdp.ef3.modelo.mesa.Color;
import es.unex.cume.mdp.ef3.modelo.mesa.IMesa;
import es.unex.cume.mdp.ef3.modelo.mesa.NumeroTablero;
import es.unex.cume.mdp.ef3.modelo.mesa.ParImpar;
/**
 * Partida. Clase abstracta que representa el juego de la ruleta y se encuentra formado por id, fecha,
 *  bolaGanadora, siJugado, y la mesa asociada a la partida. Además tendrá una composición unaria con Reparto, una composición Naria con apuesta. 
 */
public abstract class Partida{

	public static  int porColor = 1;
	public static  int porParImpar = 1;
	public static  int porNumero = 36;
	protected int id;
	protected Date fecha;
	protected boolean jugado;
	protected String bolaGanadora;
	protected IMesa mesa;
	protected Reparto reparto;
	protected List <Apuesta> apuestas;


	/**
	 * Constructor parametrizado que se encarga de crear la mesa y de inicializar
	 * todos los atributos asociados con los parametros dados
	 * @param tipo : modelo de mesa a crear
	 * @param id: identificador de la partida
	 * @param fecha: fecha de la partida
	 * @param caja: caja de la partida
	 * @param precio: precio de la partida
	 */
	public Partida(String tipo,int id, Date fecha,float caja, float precio) {
		this.id = id;
		this.fecha = fecha;


		try {
			// Cargar la clase
			Class<?> clazz = Class.forName(tipo);

			// Obtener el constructor con los tipos de parámetros adecuados
			Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, float.class);

			// Crear una nueva instancia pasando los argumentos (el id y el precio)
			mesa = (IMesa) constructor.newInstance(id, precio);

			System.out.println("Instancia creada: " + mesa.getClass());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mesa.crear(precio);
		reparto = new Reparto();
		reparto.setCaja(caja);
		apuestas = new LinkedList<Apuesta>();

	}
	

	/**
	 * Metodo que se encarga de devolver el identificador de la partida
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que se encarga de modificar el identificador de la partida
	 * por el parametro dado
	 * @param id: identificador
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que se encarga de devolver la fecha de la partida
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo que se encarga de modificar la fecha de la partida por el parametro dado
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo que se encarga de devolver un booleano en caso de que la partida se haya jugado o no
	 * @return true or false
	 */
	public boolean isJugado() {
		return jugado;
	}

	/**
	 * Metodo que se encarga de modificar un booleano en caso de que la partida se haya jugado o no
	 * @param jugado
	 */
	public void setjugado(boolean jugado) {
		this.jugado = jugado;
	}

	/**
	 * Método que se encarga de devolver la bola ganadora
	 * @return bolaGanadora
	 */
	public String getBolaGanadora() {
		return bolaGanadora;
	}

	/**
	 * Metodo que se encarga de modificar la bolaGanadora por el parámetro dado
	 * @param bolaGanadora
	 */
	public void setBolaGanadora(String bolaGanadora) {
		this.bolaGanadora = bolaGanadora;
	}

	/**
	 * Método que devuelve la mesa de la partida
	 * @return mesa
	 */
	public IMesa getMesa() {
		return mesa;
	}

	/**
	 * Método que modifica la mesa de la partida por el parámetro dado
	 * @param mesa
	 */
	public void setMesa(IMesa mesa) {
		this.mesa = mesa;
	}

	/**
	 * Método que devuelve el reparto de la partida
	 * @return reparto
	 */
	public Reparto getReparto() {
		return reparto;
	}

	/**
	 * Método que modifica el reparto de la partida por el parámetro dado
	 * @param reparto
	 */
	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	/**
	 * Método que devuelve la lista de las apuestas
	 * @return apuestas
	 */
	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	/**
	 * Método que modifica la lista de las apuestas por el parámetro dado
	 * @param apuestas
	 */
	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * Método que devuelve la constante porColor
	 * @return porColor
	 */
	public static int getPorcolor() {
		return porColor;
	}

	/**
	 * Método que devuelve la constante porParImpar
	 * @return porParImpar
	 */
	public static int getPorparimpar() {
		return porParImpar;
	}

	/**
	 * Método que devuelve la constante porNumero
	 * @return porNumero
	 */
	public static int getPornumero() {
		return porNumero;
	}


    /**
     * Método que se encarga de registrar una apuesta para un número
     * @param numero: numero a relizar la apuesta
     * @param u: usuario que desea relizar la apuesta
     * @param fecha : fecha de realización de la apuesta
     * @return nt: numeroTablero registrado
     */
	public NumeroTablero adherirseNumero(String numero,Usuario u,Date fecha) {
		//Verificar fondos del usuario:
		float p = mesa.getPrecioApuesta();
		if(u.getMonedero()>=p){
			//Verificar si se puede adherir al número:
			NumeroTablero nt = mesa.adherirseNumero(numero, u);
			if(nt!=null) {
				//Crear una nueva apuesta y añadir donde haya apuestas
				//(Date fecha, float valor, NumeroTablero nt,Usuario usuario,Partida partida)
				Apuesta ap = new Apuesta(fecha,nt,u,p);
				u.addApuesta(ap);
				//Actualizar el historial del usuario:
				mesa.getNumeroTablero(numero).getLista().add(ap);
				//Crear un movimiento y añadirlo donde haga falta
				Movimiento mov = new Movimiento(u.getMonedero(),p,fecha);
				u.getHistorico().add(mov);
				//Actualizar el monedero del usuario:
				u.setMonedero(u.getMonedero()-p);
				//Actualizar estadísticas del usuario:

				u.getEj().setNumJugadas(u.getEj().getNumJugadas()+1);
				u.getEj().setNumPerdidas(u.getEj().getNumPerdidas()+1);
				u.getEj().setDineroPerdido(u.getEj().getDineroPerdido()+p);
				if(numero.equals(ParImpar.IMPAR.toString()) || numero.equals(ParImpar.PAR.toString()) ) {
					u.getEj().setNumPI(u.getEj().getNumPI()+1);
					
				}else {
					if(numero.equals(Color.NEGRO.toString())|| numero.equals(Color.ROJO.toString())) {
						u.getEj().setNumColor(u.getEj().getNumColor()+1);
					}
					else {
						u.getEj().setNumNumero(u.getEj().getNumNumero()+1);
						
					}
				}
				//Actualizar los atributos de partida necesarios:
				apuestas.add(ap);
				reparto.setRecaudacion(reparto.getRecaudacion()+p);
				reparto.setNumApuestas(reparto.getNumApuestas()+1);
				return nt;
			}
		}

		return null;
	}
	/**
	 * Método abstracto que se encarga del juego aleatorio
	 * @return
	 */
	public abstract Reparto jugar();
	
	/**
	 * Método abstracto de se encarga del juego da un número
	 * @param numero
	 * @return
	 */
	public abstract Reparto jugar(String numero);
	
	





}
