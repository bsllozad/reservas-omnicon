package cc.omnicon.reservas.api.exception;

/**
 * Clase que controla las excepciones de validacion
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class ValidateException
 * @date Sep 16, 2018
 *
 */
public class ValidateException extends OmniconException {

	private static final long serialVersionUID = -8288847618343172687L;

	public ValidateException() {

	}

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(Throwable cause) {
		super(cause);
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

}
