package cc.omnicon.reservas.api.exception;

public class OmniconException extends RuntimeException{
	
	private static final long serialVersionUID = 2513900516364090151L;

	public OmniconException() {

	}

	public OmniconException(String message) {
		super(message);
	}

	public OmniconException(Throwable cause) {
		super(cause);
	}

	public OmniconException(String message, Throwable cause) {
		super(message, cause);
	}

}
