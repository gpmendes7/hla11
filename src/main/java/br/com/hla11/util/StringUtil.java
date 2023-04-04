package br.com.hla11.util;

import java.text.Normalizer;

public class StringUtil {
	
	private static String removeSpecialCharacters(String string) {
		return Normalizer.normalize(string, Normalizer.Form.NFD)
						 .replaceAll("[^\\p{ASCII}]", "");
	}
	
	private static String deleteWhiteSpace(String string) {
		return string.replaceAll("\\s+", " ")
				     .trim();
	}
	
	public static boolean isEmptyOrNull(String string) {
		return string == null || string.equals("");
	}
	
	public static String normalize(String string) {
		String normalizedString = removeSpecialCharacters(string);
		normalizedString = deleteWhiteSpace(normalizedString);
		normalizedString = normalizedString.toUpperCase();
	
		if(string != null) 
		   return normalizedString;
		else
			return "";
	}

}
