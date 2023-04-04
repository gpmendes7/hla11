package br.com.hla11.app.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;

public class WriteSivep {
	
	public static void main(String[] args) throws Exception {
		SivepCsvBean sivepBean = new SivepCsvBean();
		
		Date dtNascRedome = new GregorianCalendar(1985, Calendar.SEPTEMBER, 12).getTime();
		Date dataNotificacao = new GregorianCalendar(2020, Calendar.MARCH, 20).getTime();
		Date dataPrimeirosSintomas = new GregorianCalendar(2020, Calendar.MARCH, 13).getTime();
		
		sivepBean.setIdentificacao(337L);
		sivepBean.setNome("LIVIA SILVA QUELHAS");
		sivepBean.setSexoRedome("F");
		sivepBean.setDtNascRedome(dtNascRedome);
		sivepBean.setEtniaSivep("1 - Branca");
		sivepBean.setEtniaRedome("PRETA");
		sivepBean.setEtniaSivepRedome("");
		sivepBean.setNomeMae("SILVIA MARIA SILVA QUELHAS");
		sivepBean.setMunicipio("NITEROI");
		sivepBean.setCodigoMunicipio(330330L);
		sivepBean.setDataNotificacao(dataNotificacao);
		sivepBean.setSemanaEpidemiologicaNotificacao(202012L);
		sivepBean.setDataPrimeirosSintomas(dataPrimeirosSintomas);
		sivepBean.setSemanaEpidemiologicaPrimeirosSintomas(202011L);
		sivepBean.setEvolucaoCaso(null);
		sivepBean.setId(3428620L);
		sivepBean.setIdade(null);
		
		List<CsvBean> sivepList = new ArrayList<>();
		sivepList.add(sivepBean);
		
		writeCsv(sivepList);
	}
	
	private static void writeCsv(List<CsvBean> csvList) throws Exception {
	    Path path = Paths.get(CsvConstants.SIVEP_EXAMPLE);
	    CsvBeanHandler.writeCsv(path, csvList, SivepCsvBean.class);    
	}

}
