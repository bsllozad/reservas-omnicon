package cc.omnicon.reservas.api.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UtilsImpl implements Utils {
		
	public String encriptarSha1(String password) throws Exception{
		String respuesta = "";
		try {
			respuesta = DigestUtils.sha1Hex(password);
		} catch (Exception e) {
			throw e;
		}
		return respuesta;
	}
	
}
