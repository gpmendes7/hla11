package br.com.hla11.preprocessing.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;
import br.com.hla11.util.StringUtil;

public class FillEtniaRedomeSivep {
	
	public static void main(String[] args) throws Exception {
		List<CsvBean> sivepList = readCsv();
		
		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			fillEtniaRedomeSivep(sivepBean);
		}
		
		writeCsv(sivepList);
	}
	
	private static void fillEtniaRedomeSivep(SivepCsvBean sivepBean) {
		String etniaSivepRedome = sivepBean.getEtniaRedome();
		String etniaSivep = sivepBean.getEtniaSivep();
		
		if(etniaSivepRedome.equals("NAO INFORMADO")) {
			if(!StringUtil.isEmptyOrNull(etniaSivep) 
			   && !etniaSivep.equals("IGNORADO")) {
				sivepBean.setEtniaSivepRedome(etniaSivep);
				return;
			}
		}
		
		sivepBean.setEtniaSivepRedome(etniaSivepRedome);	
	}
	
	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP_WITH_ETNIA_SIVEP_NORMALIZED);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_WITH_ETNIA_SIVEP_REDOME_FILLED);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}
	
}
