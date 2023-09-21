package com.design.patterns.abstractFactory;

public interface DataSourceAbstractFactory {
	
	Service createService();
	Response createResponse();

}
