package com.demo.readcsv;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;


public class FlatfileReader {
	public static String csvInput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/manifest_input.csv";
	
	public static void main(String[] args) {
		FileSystemResource inputFile = new FileSystemResource(csvInput);
		FlatFileItemReader<BatchInput> autoInputReader = cStarInputReader(inputFile);
		
		//autoInputReader.
		
		System.out.println(autoInputReader.toString());
			

	}
	public static FlatFileItemReader<BatchInput> cStarInputReader(FileSystemResource inputFileName) {

    	if(null == inputFileName) {
    		System.out.println("ENTER:BatchConfig-cStarInputReader : null inputFileName");
    		return null;
    	}

    	System.out.println("ENTER:BatchConfig-cStarInputReader : [{}] "+ inputFileName.getFilename());
    	FlatFileItemReader<BatchInput> cStarInputReader = new FlatFileItemReader<>();
		//cStarInputReader.setLinesToSkip(1);
		cStarInputReader.setResource(inputFileName);
	
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		//lineTokenizer.setNames(new String[] {"application number"});
		lineTokenizer.setIncludedFields(new int[] {0});
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);


		BeanWrapperFieldSetMapper<BatchInput> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(BatchInput.class);
		DefaultLineMapper<BatchInput> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		cStarInputReader.setLineMapper(defaultLineMapper);

		System.out.println("EXIT:BatchConfig-cStarInputReader");
		
		return cStarInputReader;
	}


}
