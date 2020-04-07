package com.demo.springbatch;

import org.springframework.batch.item.ItemProcessor;
import com.demo.springbatch.model.*;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult result) throws Exception {
		
		System.out.println("Processing result: "+result);
		
		 if(result.getPercentage() < 75){
	            return null;
	        }
		
		return result;
	}

}
