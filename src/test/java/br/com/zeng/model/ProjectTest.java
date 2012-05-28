package br.com.zeng.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void mustSetUrlSameAsTheNameButNormalized() {
		Project project = new Project(); 
		project.setName("ëÉÁáÉüÚãçÃcäṕóÒÀ");
		assertEquals("eeaaeuuacacapooa", project.getUrl());
	}

}
