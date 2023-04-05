package br.com.hla11.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.hla11.service.constants.RegiaoConstants;
import br.com.hla11.util.StringUtil;

public class RegiaoService {

	private Map<String, String> mapaRegioes = new HashMap<String, String>();
	
    private List<String> municipiosBaiaIlhaGrande = 
    		Arrays.asList("Angra dos Reis", "Mangaratiba", "Paraty", "Parati");
	
    private List<String> municipiosBaixadaLitoranea = 
    		Arrays.asList("Araruama", "Arma��o dos B�zios", "Arraial do Cabo", "Cabo Frio", 
			              "Casimiro de Abreu", "Iguaba Grande", "Rio das Ostras", 
			              "S�o Pedro da Aldeia", "Saquarema");
    
    private List<String> municipiosCentroSul = 
    		Arrays.asList("Areal", "Comendador Levy Gasparian", "Engenheiro Paulo de Frontin", 
						  "Mendes", "Miguel Pereira", "Paracambi", "Para�ba do Sul",
						  "Paty do Alferes", "Sapucaia", "Tr�s Rios", "Vassouras");
    
    private List<String> municipiosMedioParaiba = 
    		Arrays.asList("Barra do Pira�", "Barra Mansa", "Itatiaia",
						  "Pinheiral", "Pira�", "Porto Real", "Quatis",
						  "Resende", "Rio Claro", "Rio das Flores",
						  "Valen�a", "Volta Redonda");
    
    private List<String> municipiosMetropolitana1 = 
    		Arrays.asList("Belford Roxo", "Duque de Caxias", "Itagua�",
						  "Japeri", "Mag�", "Mesquita", "Nil�polis", 
						  "Nova Igua�u", "Queimados", "Rio de Janeiro", 
						  "S�o Jo�o de Meriti", "Serop�dica");
    
    private List<String> municipiosMetropolitana2 = 
    		Arrays.asList("Itabora�", "Maric�", "Niter�i", 
						  "Rio Bonito", "S�o Gon�alo", "Silva Jardim", 
				           "Tangu�");
    
    private List<String> municipiosNoroeste = 
    		Arrays.asList("Aperib�", "Bom Jesus de Itabapoana", "Bom Jesus do Itabapoana", "Cambuci", 
					      "Cardoso Moreira", "Italva", "Itaocara",
					      "Itaperuna", "Laje do Muria�", "Miracema",
					      "Natividade", "Porci�ncula", "Santo Ant�nio de P�dua", 
					      "S�o Jos� de Ub�", "Varre-Sai");
    
    private List<String> municipiosNorte = 
    		Arrays.asList("Campos dos Goytacazes", "Carapebus", "Concei��o de Macabu", 
			              "Maca�", "Quissam�", "S�o Fid�lis", 
			              "S�o Francisco de Itabapoana", "S�o Jo�o da Barra");
    
    private List<String> municipiosSerrana = 
    		Arrays.asList("Bom Jardim", "Cachoeiras de Macacu", "Cantagalo", 
					      "Carmo", "Cordeiro", "Duas Barras",
					      "Guapimirim", "Macuco", "Nova Friburgo",
					      "Petr�polis", "Santa Maria Madalena", "S�o Jos� do Vale do Rio Preto", 
					      "S�o Sebasti�o do Alto", "Sumidouro", "Teres�polis", 
					      "Trajano de Moraes", "Trajano de Morais");
    
	public RegiaoService() {
		municipiosBaiaIlhaGrande.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.BAIA_ILHA_GRANDE));
		
		municipiosBaixadaLitoranea.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.BAIXADA_LITORANEA));
		
		municipiosCentroSul.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.CENTRO_SUl));
		
		municipiosMedioParaiba.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.MEDIO_PARAIBA));
		
		municipiosCentroSul.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.CENTRO_SUl));
		
		municipiosMetropolitana1.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.METROPOLITANA1));
		
		municipiosMetropolitana2.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.METROPOLITANA2));
		
		municipiosNoroeste.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.NOROESTE));
		
		municipiosNorte.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.NORTE));
		
		municipiosSerrana.stream()
				.forEach(municipio -> mapaRegioes.put(StringUtil.normalize(municipio), RegiaoConstants.SERRANA));
	}

	public String getRegiao(String municipio) {
		return mapaRegioes.get(StringUtil.normalize(municipio));
	}

}
