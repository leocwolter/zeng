 package br.com.zeng.infra;

import static org.junit.Assert.*;

import org.junit.Test;

public class CryptographerTest {

	@Test
	public void shouldGenerateTheRightHash() {
		Cryptographer cryptographer = new Cryptographer();
		assertEquals("e3dacc870dcf211ac0117efdeacdfc17", cryptographer.cryptoMd5("leocwolter@gmail.com"));
	}

}
