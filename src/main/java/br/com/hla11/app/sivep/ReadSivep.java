package br.com.hla11.app.sivep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.hla11.csv.constants.CsvConstants;
import br.com.hla11.csv.handler.CsvBeanHandler;
import br.com.hla11.csv.model.CsvBean;
import br.com.hla11.csv.model.SivepCsvBean;

public class ReadSivep {

	public static void main(String[] args) throws Exception {
		List<CsvBean> sivepList = readCsv();

		for (CsvBean csvBean : sivepList) {
			SivepCsvBean sivepBean = (SivepCsvBean) csvBean;
			System.out.println();
			System.out.println("******************************");
			System.out.printf("identificacao: %d%n", sivepBean.getIdentificacao());
			System.out.printf("nome: %s%n", sivepBean.getNome());
			System.out.printf("sexoRedome: %s%n", sivepBean.getSexoRedome());
			System.out.printf("dtNascRedome: %te de %<tB de %<tY%n", sivepBean.getDtNascRedome());
			System.out.printf("etniaSivep: %s%n", sivepBean.getEtniaSivep());
			System.out.printf("etniaRedome: %s%n", sivepBean.getEtniaRedome());
			System.out.printf("etniaSivepRedome: %s%n", sivepBean.getEtniaSivepRedome());
			System.out.printf("nomeMae: %s%n", sivepBean.getNomeMae());
			System.out.printf("municipio: %s%n", sivepBean.getMunicipio());
			System.out.printf("codigoMunicipio: %d%n", sivepBean.getCodigoMunicipio());
			System.out.printf("dataNotificacao: %te de %<tB de %<tY%n", sivepBean.getDataNotificacao());
			System.out.printf("semanaEpidemiologicaNotificacao: %d%n", sivepBean.getSemanaEpidemiologicaNotificacao());
			System.out.printf("dataPrimeirosSintomas: %te de %<tB de %<tY%n", sivepBean.getDataPrimeirosSintomas());
			System.out.printf("semanaEpidemiologicaPrimeirosSintomas: %d%n",
					sivepBean.getSemanaEpidemiologicaPrimeirosSintomas());
			System.out.printf("evolucaoCaso: %s%n", sivepBean.getEvolucaoCaso());
			System.out.printf("id: %d%n", sivepBean.getId());
			System.out.printf("idade: %d%n", sivepBean.getIdade());
			System.out.println("******************************");
			System.out.println();
		}
	}

	private static List<CsvBean> readCsv() throws Exception {
		Path path = Paths.get(CsvConstants.SIVEP);
		return CsvBeanHandler.readCsv(path, SivepCsvBean.class);
	}

}
