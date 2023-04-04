package br.com.hla11.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilTest {
	
	@Test
	public void testNormalize() {
		String name1 = "Maria das Graças";
		String name2 = "MARIA das Graças";
		String name3 = "MARIA das Gracas";
		String name4 = "MARIA DAS GRAÇAS";
		String name5 = "MARIA DAS GRACAS";
		String name6 = " MARIA     DAS GRACAS ";
		String normalizedName = "MARIA DAS GRACAS";
				
		assertEquals(normalizedName, StringUtil.normalize(name1));
		assertEquals(normalizedName, StringUtil.normalize(name2));
		assertEquals(normalizedName, StringUtil.normalize(name3));
		assertEquals(normalizedName, StringUtil.normalize(name4));
		assertEquals(normalizedName, StringUtil.normalize(name5));
		assertEquals(normalizedName, StringUtil.normalize(name6));
	}

}
