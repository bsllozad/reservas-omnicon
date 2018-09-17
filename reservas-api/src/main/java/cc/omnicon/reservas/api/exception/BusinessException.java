package cc.omnicon.reservas.api.exception;

/**
 * Clase que controla las excepciones de Negocio
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class BusinessException
 * @date Sep 16, 2018
 *
 */
public class BusinessException extends OmniconException {

	private static final long serialVersionUID = -698657250769985122L;

	public BusinessException() {

	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
