package br.com.zeng.infra;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Criptografador {

	private static final String SALT = "uidshguifhuibgdrngoirdnoivnj3o253g65744w54";

	public String criptografa(String texto) {
		return DigestUtils.sha256Hex(texto + SALT);
	}

}
