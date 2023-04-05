package br.com.hla11.preprocessing.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;

public class UpdateEvolucaoCaso {
	
	public static void main(String[] args) throws Exception {
		
		List<CsvBean> sivepList = readCsv();
		
		long updates = 0;
		
		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			
	        if (updateEvolucaoCaso(sivepBean)) {
	        	updates++;
	        }
		}
		
		System.out.printf("Records with evolucaoCaso \"NAO INFORMADO\": %d", updates);
		
		writeCsv(sivepList);
	}
	
	private static boolean updateEvolucaoCaso(SivepCsvBean sivepBean) {
		String evolucaoCaso = sivepBean.getEvolucaoCaso();
		
		if(!evolucaoCaso.equals("1 - CURA") && !evolucaoCaso.equals("2 - OBITO")) {
			sivepBean.setEvolucaoCaso("NAO INFORMADO");
			return true;
		}
			  
	    return false;
	}
	
	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP_WITH_IDADE_FILLED);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_WITH_EVOLUCAO_CASO_UPDATED);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}

}
