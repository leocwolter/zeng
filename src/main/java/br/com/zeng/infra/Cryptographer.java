package br.com.zeng.infra;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Cryptographer{

	private static final String SALT = "uidshguifhuibgdrngoirdnoivnj3o253g65744w54";

	public String cryptoSha256(String text) {
		return DigestUtils.sha256Hex(text + SALT);
	}

	public String cryptoMd5(String text) {
		return DigestUtils.md5Hex(text);
	}

}
