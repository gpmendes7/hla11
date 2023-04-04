package br.com.hla11.preprocessing.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;
import br.com.hla11.util.DateUtil;

public class CalculateIdade {
	
	public static void main(String[] args) throws Exception {
		List<CsvBean> sivepList = readCsv();
		
		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			sivepBean.setIdade(calculateIdade(sivepBean));
		}
		
		writeCsv(sivepList);
	}
	
	private static Integer calculateIdade(SivepCsvBean sivepBean) {
		Date dtNascRedome = sivepBean.getDtNascRedome();
		Date dataNotificacao = sivepBean.getDataNotificacao();
		Date dataPrimeirosSintomas = sivepBean.getDataPrimeirosSintomas();
		
		int idade = 0;
		
		if (dataNotificacao != null) {
			idade = DateUtil.countYearsBetween(dtNascRedome, dataNotificacao);
		} else { 
			idade = DateUtil.countYearsBetween(dtNascRedome, dataPrimeirosSintomas);
		}
		
		return Integer.valueOf(idade);
	}
	
	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP_WITH_ETNIA_SIVEP_NORMALIZED);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_WITH_IDADE);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}

}
