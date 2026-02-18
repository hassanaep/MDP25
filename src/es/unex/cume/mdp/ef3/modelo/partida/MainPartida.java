package es.unex.cume.mdp.ef3.modelo.partida;

import java.util.Date;
import java.util.Iterator;

import es.unex.cume.mdp.ef3.modelo.casino.Apuesta;
import es.unex.cume.mdp.ef3.modelo.casino.Estadistica;
import es.unex.cume.mdp.ef3.modelo.casino.Usuario;
import es.unex.cume.mdp.ef3.modelo.mesa.Color;
import es.unex.cume.mdp.ef3.modelo.mesa.ParImpar;

public class MainPartida {

	public static void main(String[] args) {
		Usuario u = new Usuario("1", "1", "1", 100000);
		Usuario u2 = new Usuario("2", "2", "2", 100000);
		Estadistica e = new Estadistica();
		for (int i = 0; i < 3; i++) {
			//
			Partida p = new PartidaClasica("ef2.mesa.MesaClasicaAL", 1, new Date(), 1000, 2);
			p.adherirseNumero("1", u, new Date());
			p.adherirseNumero("2", u, new Date());
			p.adherirseNumero("3", u, new Date());
			p.adherirseNumero("4", u, new Date());
			p.adherirseNumero("4", u2, new Date());
			p.adherirseNumero(Color.NEGRO.toString(), u, new Date());
			p.adherirseNumero(Color.ROJO.toString(), u, new Date());
			p.adherirseNumero(ParImpar.PAR.toString(), u, new Date());
			p.adherirseNumero(ParImpar.IMPAR.toString(), u, new Date());
			p.adherirseNumero(ParImpar.PAR.toString(), u2, new Date());
			System.out.println("Partida "+i + " "+p.jugar("4"));
			System.out.println(p.getReparto());
			Iterator<Apuesta>it = p.getApuestas().iterator();
			Apuesta aux = null;

			while(it.hasNext()) {
				aux = it.next();
				System.out.println(aux.toString());
			}
			
			System.out.println(u);
			System.out.println(u.getEj().toString());
		}
		
	}
}
