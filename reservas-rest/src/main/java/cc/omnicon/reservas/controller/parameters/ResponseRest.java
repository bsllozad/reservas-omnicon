package cc.omnicon.reservas.controller.parameters;

public class ResponseRest <T>{
	
	private String codigo;
	private String mensaje;
	private T objeto;
	
	public ResponseRest() {
		
	}
	
	public ResponseRest(String codigo, String mensaje, T objeto) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.objeto = objeto;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	
	

}
