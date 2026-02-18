package es.unex.cume.mdp.ef3.modelo.casino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import es.unex.cume.mdp.ef3.modelo.mesa.Color;
import es.unex.cume.mdp.ef3.modelo.mesa.NumeroTablero;
import es.unex.cume.mdp.ef3.modelo.mesa.ParImpar;
import es.unex.cume.mdp.ef3.modelo.partida.Partida;
import es.unex.cume.mdp.ef3.modelo.partida.PartidaClasica;



/**
 * Casino. Clase que representa al sistema Casino y 
 * se encuentra formado por los usuarios, las partidas 
 * que tiene el sistema, las estadísticas del casino y 
 * la caja total con la cual empieza el casino
 */
public class Casino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Usuario> usuarios;
	protected Map<Date,Partida> partidas;
	protected Map<String,Estadistica> estadisticas;
	protected float caja;
	private String tipo="ef2.mesa.MesaClasicaAL";

	/**
	 * Constructor por defecto de la clase Casino que inicializa los atributos
	 * con los valores por defecto
	 */
	public Casino() {
		usuarios = new HashMap<String,Usuario>();
		partidas = new HashMap<Date,Partida>();
		estadisticas = new HashMap<String,Estadistica>();
		caja = 0f;

	}

	/**
	 * Constructor parametrizado de la clase Casino que inicializa los atributos con los parámetros dados
	 * @param caja : caja total inicial del casino
	 */
	public Casino(float caja) {
		this.caja = caja;
		usuarios = new HashMap<String,Usuario>();
		partidas = new HashMap<Date,Partida>();
		estadisticas = new HashMap<String,Estadistica>();
		for(int i =1 ;i<=36;i++) {
			Estadistica e = new Estadistica(i,0,0,0);
			estadisticas.put(String.valueOf(i), e);
		}
		estadisticas.put(ParImpar.PAR.toString(), new Estadistica(0,0,0,0));
		estadisticas.put(ParImpar.IMPAR.toString(), new Estadistica(0,0,0,0));
		estadisticas.put(Color.ROJO.toString(), new Estadistica(0,0,0,0));
		estadisticas.put(Color.NEGRO.toString(), new Estadistica(0,0,0,0));
	}

	/**
	 * Método que devuelve el tipo de mesa
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método que modifica el tipo de mesa
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * Método que devuelve el mapa de usuarios
	 * @return usuarios
	 */
	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Método que modifica el mapa de usuarios por el dado por parámetro
	 * @param usuarios
	 */
	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Método que devuelve el mapa de partidas
	 * @return partidas
	 */
	public Map<Date, Partida> getPartidas() {
		return partidas;
	}

	/**
	 * Método que modifica el mapa de partidas por el dado por parámetro
	 * @param partidas
	 */
	public void setPartidas(Map<Date, Partida> partidas) {
		this.partidas = partidas;
	}

	/**
	 * Método que devuelve el mapa de estadisticas
	 * @return estadisticas
	 */
	public Map<String, Estadistica> getEstadisticas() {
		return estadisticas;
	}

	/**
	 * Método que modifica el mapa de estadisticas por el dado por parámetro
	 * @param estadisticas
	 */
	public void setEstadisticas(Map<String, Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	/**
	 * Método que devuelve la caja del casino
	 * @return caja
	 */
	public float getCaja() {
		return caja;
	}

	/**
	 * Método que modifica la caja del casino por el parámetro dado
	 * @param caja
	 */
	public void setCaja(float caja) {
		this.caja = caja;
	}


	/**
	 * Método que se encarga de la autentificación del usuario
	 * @param nick
	 * @param password
	 * @return u
	 * @throws UsuarioNoAutenticado
	 */
	public Usuario login(String nick,String password) throws UsuarioNoAutenticado {
		Usuario u = usuarios.get(nick);
		if(u ==null) {
			throw new UsuarioNoAutenticado();
		}
		else {
			if(!u.getPassword().equals(password)) {
				System.out.println("Contraseña incorrecta");
				throw new UsuarioNoAutenticado();
			}
		}

		return u;

	}

	/**
	 * Método que da de alta al usuario en el sistema
	 * @param nick
	 * @param name
	 * @param password
	 * @param monedero
	 * @return true or false
	 */
	public boolean register(String nick,String name,String password,float monedero) {
		Usuario u = new Usuario(nick,name,password,monedero);
		if(!usuarios.containsKey(nick)) {
			usuarios.put(nick, u);
			System.out.println("Usuario registrado");
			return true;
		}
		System.out.println("El usuario ya se encuentra registrado");
		return false;

	}
	public boolean addMonedero(String nick,String password,float monedero) {
		Usuario u;
		try {
			u = login(nick,password);
			u.setMonedero(u.getMonedero()+monedero);
			Movimiento e = new Movimiento(u.getMonedero(),monedero,new Date());
			u.getHistorico().add(e);
			return true;
		} catch (UsuarioNoAutenticado e) {
			return false;
		}



	}

	/**
	 * Método que se encarga de crear partida
	 * @param tipo
	 * @param d
	 * @param caja
	 * @param precio
	 * @return p
	 */
	public Partida crearPartida(String tipo,Date d,float caja,float precio) {
		Partida p = new PartidaClasica(tipo,partidas.size()+1,d,caja,precio);
		partidas.put(d,p);

		return p;
	}

	/**
	 * Método se encarga de que el usuario se adhiera a un número
	 * @param nick
	 * @param password
	 * @param d
	 * @param numero
	 * @return nt
	 */
	public NumeroTablero adherirseNumero(String nick,String password,Date d,String numero) {
		Usuario u;
		try {
			u = login(nick,password);
			NumeroTablero nt = partidas.get(d).adherirseNumero(numero, u, d);
			//Movimiento e = new Movimiento(u.getMonedero(),,new Date());
			//u.getHistorico().add(e);
			Estadistica e = estadisticas.get(numero);
			if(e!=null) {
				e.setNumVecesApostado(e.getNumVecesApostado()+1);
			}
			return nt;
		} catch (UsuarioNoAutenticado e) {
			return null;
		}

	}

	/**
	 * Método que se encarga del juego de la ruleta y devolver el reparto resultante
	 * @param d
	 * @return r
	 */
	public Reparto jugar(Date d) {
		Partida p1 = partidas.get(d);
		if(!p1.isJugado()) {
			Reparto r = p1.jugar();
			this.setCaja(this.getCaja()+p1.getReparto().getRecaudacion()-p1.getReparto().getResultado());
			return r;
		}
		return null;
	}

	/**
	 * Método que se encarga de devolver el reparto resultante del juego de un numero dado
	 * @param d
	 * @param numero
	 * @return r
	 */
	public Reparto jugar(Date d, String numero) {
		Partida p1 = partidas.get(d);

		Reparto r = null;
		if(!p1.isJugado()) {

			r = p1.jugar(numero);
			//NumeroTablero nt = p1.getMesa().getNumeroTablero(numero);
			this.setCaja(this.getCaja()+p1.getReparto().getRecaudacion()-p1.getReparto().getResultado());
			Estadistica e=estadisticas.get(numero);
			if(e!=null){
				//System.out.println(ParImpar.IMPAR.toString());
				if(numero.contains(ParImpar.IMPAR.toString())) {
					e.setNumGanado(e.getNumGanado()+1);
					e.setPrecioGanado(r.getRepartoPI());
				}
				else if(numero.contains(Color.ROJO.toString())) {
					e.setNumGanado(e.getNumGanado()+1);
					e.setPrecioGanado(r.getRepartoColor());
				}
				else {
					//e.setNumVecesApostado(r.getNumApuestas());
					e.setNumGanado(e.getNumGanado()+1);
					System.out.println(e.getNumGanado());
					e.setPrecioGanado(e.getPrecioGanado() + r.getRepartoNumero());
					if(r.getNumColor()>0) {
						Estadistica e1 = estadisticas.get(Color.ROJO.toString());
						e1.setNumGanado(e1.getNumGanado()+1);
						e1.setPrecioGanado(e1.getPrecioGanado()+r.getRepartoColor());
					}
					if(r.getNumPI()>0) {
						Estadistica e2 = estadisticas.get(ParImpar.IMPAR.toString());
						e2.setNumGanado(e2.getNumGanado()+1);
						e2.setPrecioGanado(e2.getPrecioGanado()+r.getRepartoPI());
					}

				}

			}

		}
		return r;

	}

	/**
	 * Méodo que devuelve una partida del mapa de partidas
	 * @param d
	 * @return p2
	 */
	public Partida consultarPartida(Date d) {
		Partida p2 = partidas.get(d);
		return p2;
	}

	/**
	 * Método que se encarga de devolver la estadistica de un numero dado del 
	 * mapa de estadisticas
	 * @param numero
	 * @return estadistica del numero
	 */
	public Estadistica getEstadisticaNumero(String numero) {
		return estadisticas.get(numero);
	}


	/**
	 * Método que se encarga de devolver las estadísticas del jugador
	 * @param u
	 * @return estadítica del jugador
	 */
	public EstadisticaJugador VerEstadisticaJugador(Usuario u) {
		return u.getEj();
	}

	/**
	 * Método que devuelve una lista ordenada de las estadísticas en función del tipo
	 *  tipo == 1: en función del numGanado
	 *  tipo == 2: en función del PrecioGanado
	 *  tipo == 3: en función del NumVecesApostado
	 * @param tipo
	 * @return ranking
	 */
	public List <Estadistica> Estadistica(int tipo){
		List<Estadistica> ranking = this.getEstadisticas()
				.values()
				.stream()
				.collect(Collectors.toList());
		if(tipo == 1) {
			Collections.sort(ranking,Comparator.comparing(Estadistica::getNumGanado).reversed());
		}
		if(tipo==2) {
			Collections.sort(ranking,Comparator.comparing(Estadistica::getPrecioGanado).reversed());
		}
		if(tipo==3) {
			Collections.sort(ranking,Comparator.comparing(Estadistica::getNumVecesApostado).reversed());
		}

		return ranking;

	}

	/**
	 * Metodo que se encarga de cargar los movimientos una vez inicada la aplicacion
	 * @param fmov
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public void cargarMovimientos(String fmov) throws NumberFormatException, ParseException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fmov)));
			String line = null;
			while ((line = br.readLine()) != null) {
				// divido la línea por cada #
				String[] split = line.split(":");
				//:idUsuario:info:monederoactual:valor:fecha
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Movimiento m = new Movimiento(split[2],Float.parseFloat(split[3]),Float.parseFloat(split[4]),sdf.parse(split[5]));
				Usuario u = usuarios.get(split[1]);
				u.getHistorico().add(m);
				System.out.println(u.toString());
			}
			br.close();
		} catch (IOException e) {

		}
	}

	/**
	 * Metodo que se encarga de salvar los movimientos una vez finalizada la aplicacion
	 * @param fimov
	 */
	public void salvarMovimientos(String fimov) {
		BufferedWriter dis = null;
		try {
			dis = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fimov)));
			for (Usuario u : this.usuarios.values()) {
				Iterator<Movimiento>it= u.getHistorico().iterator();
				Movimiento aux = null;
				while(it.hasNext()) {
					dis.write(":"+ u.getNick()+":"+aux.getInfo()+":"+aux.getMonederoActual()+":"+aux.getValor()+":"+aux.getFecha()+"\n" );
				}    
			}
			dis.close();
		} catch (IOException e) {

		}
	}
	
	
}
