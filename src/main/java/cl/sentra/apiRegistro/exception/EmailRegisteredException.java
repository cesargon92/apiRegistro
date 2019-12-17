package cl.sentra.apiRegistro.exception;

public class EmailRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailRegisteredException() {
        super("El correo ya está registrado");
    }
}
