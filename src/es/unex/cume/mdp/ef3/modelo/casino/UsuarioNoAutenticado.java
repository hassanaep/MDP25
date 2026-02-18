package es.unex.cume.mdp.ef3.modelo.casino;
/**
 * Excepción el usuario requiere autenticación y el usuario no está registrado o no se ha autenticado
 */
public class UsuarioNoAutenticado extends Exception {

	/**
	 * Método que muestra un mensaje en caso de que el usuario no haya podido autentificarse
	 */
	public UsuarioNoAutenticado() {
		super("El usuario no ha podido autentificarse");
	}
}
