package br.com.hla11.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.hla11.service.constants.RegiaoConstants;

public class RegiaoServiceTest {
	
	private static RegiaoService regiaoService;
	
	@BeforeAll
	public static void setup() {
		regiaoService = new RegiaoService(); 
	}
	
	@Test
	public void testGetRegiao_CaptalizationAndWhiteSpace() {
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao("ANGRA DOS REIS"));
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao(" ANGRA DOS REIS "));
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao("  ANGRA   DOS REIS    "));
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao("Angra dos Reis"));
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao("Angra DOS Reis"));
	}
	
	@Test
	public void testGetRegiao() {
		assertEquals(RegiaoConstants.BAIA_ILHA_GRANDE, regiaoService.getRegiao("ANGRA DOS REIS"));
		assertEquals(RegiaoConstants.BAIXADA_LITORANEA, regiaoService.getRegiao("ARARUAMA"));
		assertEquals(RegiaoConstants.CENTRO_SUl, regiaoService.getRegiao("AREAL"));
		assertEquals(RegiaoConstants.MEDIO_PARAIBA, regiaoService.getRegiao("BARRA DO PIRAI"));
		assertEquals(RegiaoConstants.METROPOLITANA1, regiaoService.getRegiao("BELFORD ROXO"));
		assertEquals(RegiaoConstants.METROPOLITANA2, regiaoService.getRegiao("ITABORAI"));
		assertEquals(RegiaoConstants.NOROESTE, regiaoService.getRegiao("APERIBE"));
	    assertEquals(RegiaoConstants.NORTE, regiaoService.getRegiao("CAMPOS DOS GOYTACAZES"));
		assertEquals(RegiaoConstants.SERRANA, regiaoService.getRegiao("BOM JARDIM"));
	}

}
