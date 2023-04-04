package br.com.hla11.preprocessing.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;

public class NormalizeEtniaSivep {
	
	public static void main(String[] args) throws Exception {
        List<CsvBean> sivepList = readCsv();
		
		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			
			switch (sivepBean.getEtniaSivep()) {
			case "1 - BRANCA": 
				sivepBean.setEtniaSivep("BRANCA");
				break;
			case "2 - PRETA": 
				sivepBean.setEtniaSivep("PRETA");
				break;
			case "3 - AMARELA": 
				sivepBean.setEtniaSivep("AMARELA");
				break;
			case "4 - PARDA": 
				sivepBean.setEtniaSivep("PARDA");
				break;
			case "9 - IGNORADO": 
				sivepBean.setEtniaSivep("IGNORADO");
				break;
			default:
				break;
			}
		}
		
		writeCsv(sivepList);
	}
	
	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP_WITH_STRINGS_NORMALIZED);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_WITH_ETNIA_SIVEP_NORMALIZED);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}

}
