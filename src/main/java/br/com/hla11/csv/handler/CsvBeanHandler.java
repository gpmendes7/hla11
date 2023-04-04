package br.com.hla11.csv.handler;

import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import br.com.hla11.csv.model.CsvBean;

public class CsvBeanHandler {

	public static List<CsvBean> readCsv(Path path, Class clazz) throws Exception {
		List<CsvBean> csvList = new ArrayList<>();

		try (Reader reader = Files.newBufferedReader(path)) {
			CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
					.withType(clazz).build();

			csvList.addAll(cb.parse());
		}

		return csvList;
	}

	public static void writeCsv(Path path, List<CsvBean> csvList, Class clazz) throws Exception {
		HeaderColumnNameMappingStrategy<CsvBean> strategy = new HeaderColumnNameMappingStrategy<CsvBean>();
		strategy.setType(clazz);

		String headerLine = Arrays.stream(clazz.getDeclaredFields())
				.map(field -> field.getAnnotation(CsvBindByName.class))
				.filter(Objects::nonNull)
				.map(CsvBindByName::column)
				.collect(Collectors.joining(","));

		try (StringReader reader = new StringReader(headerLine)) {
			CsvToBean<CsvBean> csv = new CsvToBeanBuilder<CsvBean>(reader)
					.withType(clazz)
					.withMappingStrategy(strategy)
					.build();
			
			for (CsvBean csvRow : csv) {
			}
		}

		try (Writer writer = new FileWriter(path.toString())) {
			StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
					.withMappingStrategy(strategy)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.build();

			sbc.write(csvList);
		}

	}

}
