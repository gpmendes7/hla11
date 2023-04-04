package br.com.hla11.preprocessing.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;
import br.com.hla11.util.StringUtil;

public class NormalizeStringsSivep {
	
	public static void main(String[] args) throws Exception {
		List<CsvBean> sivepList = readCsv();
		
		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			sivepBean.setNome(StringUtil.normalize(sivepBean.getNome()));
			sivepBean.setSexoRedome(StringUtil.normalize(sivepBean.getSexoRedome()));
			sivepBean.setEtniaSivep(StringUtil.normalize(sivepBean.getEtniaSivep()));
			sivepBean.setEtniaRedome(StringUtil.normalize(sivepBean.getEtniaRedome()));
			sivepBean.setEtniaSivepRedome(StringUtil.normalize(sivepBean.getEtniaSivepRedome()));
			sivepBean.setNomeMae(StringUtil.normalize(sivepBean.getNomeMae()));
			sivepBean.setMunicipio(StringUtil.normalize(sivepBean.getMunicipio()));
			sivepBean.setEvolucaoCaso(StringUtil.normalize(sivepBean.getEvolucaoCaso()));
		}
		
		writeCsv(sivepList);
	}
	
	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_NORMALIZED);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}

}
