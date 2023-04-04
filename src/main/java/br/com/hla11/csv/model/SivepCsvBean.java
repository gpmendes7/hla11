package br.com.hla11.csv.model;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SivepCsvBean extends CsvBean {
	
	@CsvBindByName(column = "identificacao")
	private Long identificacao;
	
	@CsvBindByName(column = "nome")
	private String nome;
	
	@CsvBindByName(column = "sexoRedome")
	private String sexoRedome;
	
	@CsvBindByName(column = "dtNascRedome")
	@CsvDate(value = "dd/MM/yyyy")
	private Date dtNascRedome;
	
	@CsvBindByName(column = "etniaSivep")
	private String etniaSivep;
	
	@CsvBindByName(column = "etniaRedome")
	private String etniaRedome;
	
	@CsvBindByName(column = "etniaSivepRedome")
	private String etniaSivepRedome;
	
	@CsvBindByName(column = "nomeMae")
	private String nomeMae;
	
	@CsvBindByName(column = "municipio")
	private String municipio;
	
	@CsvBindByName(column = "codigoMunicipio")
	private Long codigoMunicipio;
	
	@CsvBindByName(column = "dataNotificacao")
	@CsvDate(value = "dd/MM/yyyy")
	private Date dataNotificacao;
	
	@CsvBindByName(column = "semanaEpidemiologicaNotificacao")
	private Long semanaEpidemiologicaNotificacao;
	
	@CsvBindByName(column = "dataPrimeirosSintomas")
	@CsvDate(value = "dd/MM/yyyy")
	private Date dataPrimeirosSintomas;
	
	@CsvBindByName(column = "semanaEpidemiologicaPrimeirosSintomas")
	private Long semanaEpidemiologicaPrimeirosSintomas;
	
	@CsvBindByName(column = "evolucaoCaso")
	private String evolucaoCaso;
	
	@CsvBindByName(column = "id")
	private Long id;
	
	@CsvBindByName(column = "idade")
	private Integer idade;
	
}
