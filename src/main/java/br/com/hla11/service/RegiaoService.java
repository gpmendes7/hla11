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
    		Arrays.asList("Araruama", "Armação dos Búzios", "Arraial do Cabo", "Cabo Frio", 
			              "Casimiro de Abreu", "Iguaba Grande", "Rio das Ostras", 
			              "São Pedro da Aldeia", "Saquarema");
    
    private List<String> municipiosCentroSul = 
    		Arrays.asList("Areal", "Comendador Levy Gasparian", "Engenheiro Paulo de Frontin", 
						  "Mendes", "Miguel Pereira", "Paracambi", "Paraíba do Sul",
						  "Paty do Alferes", "Sapucaia", "Três Rios", "Vassouras");
    
    private List<String> municipiosMedioParaiba = 
    		Arrays.asList("Barra do Piraí", "Barra Mansa", "Itatiaia",
						  "Pinheiral", "Piraí", "Porto Real", "Quatis",
						  "Resende", "Rio Claro", "Rio das Flores",
						  "Valença", "Volta Redonda");
    
    private List<String> municipiosMetropolitana1 = 
    		Arrays.asList("Belford Roxo", "Duque de Caxias", "Itaguaí",
						  "Japeri", "Magé", "Mesquita", "Nilópolis", 
						  "Nova Iguaçu", "Queimados", "Rio de Janeiro", 
						  "São João de Meriti", "Seropédica");
    
    private List<String> municipiosMetropolitana2 = 
    		Arrays.asList("Itaboraí", "Maricá", "Niterói", 
						  "Rio Bonito", "São Gonçalo", "Silva Jardim", 
				           "Tanguá");
    
    private List<String> municipiosNoroeste = 
    		Arrays.asList("Aperibé", "Bom Jesus de Itabapoana", "Bom Jesus do Itabapoana", "Cambuci", 
					      "Cardoso Moreira", "Italva", "Itaocara",
					      "Itaperuna", "Laje do Muriaé", "Miracema",
					      "Natividade", "Porciúncula", "Santo Antônio de Pádua", 
					      "São José de Ubá", "Varre-Sai");
    
    private List<String> municipiosNorte = 
    		Arrays.asList("Campos dos Goytacazes", "Carapebus", "Conceição de Macabu", 
			              "Macaé", "Quissamã", "São Fidélis", 
			              "São Francisco de Itabapoana", "São João da Barra");
    
    private List<String> municipiosSerrana = 
    		Arrays.asList("Bom Jardim", "Cachoeiras de Macacu", "Cantagalo", 
					      "Carmo", "Cordeiro", "Duas Barras",
					      "Guapimirim", "Macuco", "Nova Friburgo",
					      "Petrópolis", "Santa Maria Madalena", "São José do Vale do Rio Preto", 
					      "São Sebastião do Alto", "Sumidouro", "Teresópolis", 
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
