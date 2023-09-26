package com.design.patterns.chainofresponsibility;

public class PayloadHandler implements HandlerChain{
	String payload;
	
	public HandlerChain next;
	
	public PayloadHandler(String payload) {
		this.payload =payload;
	}

	@Override
	public String addHandler(String inputHeader) {
		String outputHeader = inputHeader +"\n payload "+ payload;
		if(next == null)
		  return outputHeader;
		else
			return next.addHandler(outputHeader);
	}

}
