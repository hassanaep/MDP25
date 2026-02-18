package es.unex.cume.mdp.ef3.modelo.partida;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import es.unex.cume.mdp.ef3.modelo.casino.Apuesta;
import es.unex.cume.mdp.ef3.modelo.casino.Movimiento;
import es.unex.cume.mdp.ef3.modelo.casino.Reparto;
import es.unex.cume.mdp.ef3.modelo.mesa.Color;
import es.unex.cume.mdp.ef3.modelo.mesa.NumeroRuleta;
import es.unex.cume.mdp.ef3.modelo.mesa.NumeroTablero;
import es.unex.cume.mdp.ef3.modelo.mesa.ParImpar;
/**
 * PartidaClasica. Clase derivada de Partida que implementa los métodos abstractos de la clase Partida
 */
public class PartidaClasica extends Partida {

	/**
	 * Constructor parametrizado que llama al constructor parametrizado de la clase Partida con los parámetros dados
	 * y modifica el valor de las constantes
	 * @param tipo : modelo de mesa a crear
	 * @param id: identificador de la partida
	 * @param fecha: fecha de la partida
	 * @param caja: caja de la partida
	 * @param precio: precio de la partida
	 */
	public PartidaClasica(String tipo,int id, Date fecha, float caja, float precio) {
		super(tipo,id, fecha, caja, precio);
		// TODO Auto-generated constructor stub
		porColor = 2;
		porParImpar = 2;//premio es el precio de la apuesta multiplicado por esto
		porNumero = 35;
	}

	/**
	 * Método que se encarga de tirar una bola aleatoria y registrar el número ganador
	 * @return reparto
	 */
	@Override
	public Reparto jugar() {
		// TODO Auto-generated method stub
		if(!isJugado()) {
			Random r = new Random();
			int num = r.nextInt(35)+1;
			this.setBolaGanadora(String.valueOf(num));
			this.setjugado(true);
			return this.getReparto();
		}
		return null;
	}

	/**
	 * Método que se encarga de registrar el número ganador por el número dado y de repartir los premios
	 * de número ganador
	 * @return Reparto
	 */
	@Override
	public Reparto jugar(String numero) {
		// TODO Auto-generated method stub
		if(!isJugado()) {
			this.setBolaGanadora(numero);

			this.setjugado(true);
			
			int cont1 =0,cont2=0;
			NumeroRuleta nr=mesa.getNumeroRuleta(numero);
			NumeroTablero nt=mesa.getNumeroTablero(nr.getValor());
			Iterator<Apuesta> it=nt.getLista().iterator();
			Apuesta aux = null;
            while(it.hasNext()) {
            	
            	aux = it.next();
            	aux.setResultado(mesa.getPrecioApuesta()*porNumero);
            	aux.getUsuario().setMonedero(aux.getResultado()+aux.getUsuario().getMonedero());
                //aux.getUsuario().getEj().setNumNumero(aux.getUsuario().getEj().getNumNumero()+1);
                aux.getUsuario().getEj().setNumGanadas(aux.getUsuario().getEj().getNumGanadas()+1);
                aux.getUsuario().getEj().setNumPerdidas(aux.getUsuario().getEj().getNumPerdidas()-1);
                Movimiento m  = new Movimiento(aux.getUsuario().getMonedero(),aux.getResultado(),new Date());
        		aux.getUsuario().getHistorico().add(m);
        		aux.getUsuario().getEj().setDineroGanado(aux.getResultado()+aux.getUsuario().getEj().getDineroGanado());
        		//cont = cont + 1;
        		
            }	
            
			String color=nr.getColor().toString();
			NumeroTablero nColor=mesa.getNumeroTablero(color);
			Iterator<Apuesta>it2=nColor.getLista().iterator();
			Apuesta aux2 = null;
			
			
            while(it2.hasNext()) {
            	aux2 = it2.next();
            	if(aux2.getNt().getValor().equals(Color.ROJO.toString())) {
            		
            		aux2.setResultado(mesa.getPrecioApuesta()*porColor);
            		aux2.getUsuario().setMonedero(aux2.getResultado()+aux2.getUsuario().getMonedero());
            		//aux2.getUsuario().getEj().setNumColor(aux2.getUsuario().getEj().getNumColor()+1);
            		aux2.getUsuario().getEj().setNumGanadas(aux2.getUsuario().getEj().getNumGanadas()+1);
            		aux2.getUsuario().getEj().setNumPerdidas(aux2.getUsuario().getEj().getNumPerdidas()-1);
            		Movimiento m  = new Movimiento(aux2.getUsuario().getMonedero(),aux2.getResultado(),new Date());
            		aux2.getUsuario().getHistorico().add(m);
            		aux2.getUsuario().getEj().setDineroGanado(aux2.getResultado()+aux2.getUsuario().getEj().getDineroGanado());
            		
            		cont1 = cont1+1;
            		
            	}else {
            		aux2.setResultado(0);
            	}
            	
            }	

			String parImpar = nr.getParImpar().toString();
			NumeroTablero nPi = mesa.getNumeroTablero(parImpar);
			Iterator<Apuesta>it3 = nPi.getLista().iterator();
			Apuesta aux3 = null;
            while(it3.hasNext()) {
            	aux3 = it3.next();
            	if(aux3.getNt().getValor().equals(ParImpar.IMPAR.toString())) {
            		
            		aux3.setResultado(mesa.getPrecioApuesta()*porParImpar);
            		aux3.getUsuario().setMonedero(aux3.getResultado()+aux3.getUsuario().getMonedero());
            		//aux3.getUsuario().getEj().setNumPI(aux3.getUsuario().getEj().getNumPI()+1);
            		aux3.getUsuario().getEj().setNumGanadas(aux3.getUsuario().getEj().getNumGanadas()+1);
            		aux3.getUsuario().getEj().setNumPerdidas(aux3.getUsuario().getEj().getNumPerdidas()-1);
            		Movimiento m  = new Movimiento(aux3.getUsuario().getMonedero(),aux3.getResultado(),new Date());
            		aux3.getUsuario().getHistorico().add(m);
            		aux3.getUsuario().getEj().setDineroGanado(aux3.getResultado()+aux3.getUsuario().getEj().getDineroGanado());
            		cont2 = cont2+1;
            	}else {
            		aux3.setResultado(0);
            	}
            	
            }	
			
			reparto.setNumNumero(reparto.getNumNumero()+nt.getLista().size());
			reparto.setRepartoNumero(mesa.getPrecioApuesta()*porNumero*nt.getLista().size());//*nt.getLista().size());
			reparto.setNumColor(reparto.getNumColor()+cont1);//nColor.getLista().size());
			reparto.setRepartoColor(mesa.getPrecioApuesta()*porColor*cont1);//nColor.getLista().size());
			reparto.setNumPI(reparto.getNumPI()+cont2);//nPi.getLista().size());
			reparto.setRepartoPI(mesa.getPrecioApuesta()*porParImpar*cont2);//nPi.getLista().size());
			float suma = reparto.getRepartoColor()+reparto.getRepartoNumero()+reparto.getRepartoPI();
			reparto.setResultado(suma);
			
		}else {
			return null;
		}
		
	return this.getReparto();
}

	











}
