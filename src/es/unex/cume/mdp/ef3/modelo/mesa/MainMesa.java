package es.unex.cume.mdp.ef3.modelo.mesa;

import es.unex.cume.mdp.ef3.modelo.casino.Usuario;

public class MainMesa {

	public static void main(String []args) { 
		IMesa m= new MesaClasicaAL(1,1.0F);
		Usuario u= new Usuario("1","1","1",100);
		Usuario u2= new Usuario("1","1","1",100);
		m.crear(1);
		m.adherirseNumero("1", u);
		m.adherirseNumero("2", u2);
		System.out.println(m.jugar("1")); 
		
	} 
}
