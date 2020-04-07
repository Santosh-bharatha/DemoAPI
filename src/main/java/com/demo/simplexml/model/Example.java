package com.demo.simplexml.model;

import org.simpleframework.xml.*;

import com.demo.simplexml.model.*;

@Root(name="root")
public class Example implements Task{
    @Element
	private Task task;
    
    
	public Example() {
		super();
	}
	/*@Element(name="message")
	private String text;
	
	@Attribute
	private int index;

	public Example(String text, int index) {
		this.text = text;
		this.index = index;
	}
	
	public String getMessage() {
		return text;
	}
	
	public int getId() {
		return index;
	}
*/
	@Override
	public double execute() {
		return task.execute();
	}
}



@Root
class Configuration{
	
	 @Element
	 private Server server;
	 @Attribute
	 private int id;
	 
	 public int getIdentity() {
		 return id;
	 }
	 public Server getServer() {
		 return server;
	 }
}

@Root
class Server{
	@Attribute
	   private int port;

	   @Element
	   private String host;

	   @Element
	   private Security security;

	   public int getPort() {
	      return port;           
	   }

	   public String getHost() {
	      return host;           
	   }

	   public Security getSecurity() {
	      return security;           
	   }
}

@Root
class Security{
	@Attribute
	   private boolean ssl;

	   @Element
	   private String keyStore;

	   public boolean isSSL() {
	      return ssl;           
	   }

	   public String getKeyStore() {
	      return keyStore;           
	   }
}

class OptionalExample {

	   @Attribute(required=false)
	   private int version;

	   @Attribute
	   private int id;

	   @Element(required=false)
	   private String name;   

	   @Element
	   private String address;

	   public int getId() {
	      return id;
	   }

	   public int getVersion() {
	      return version;
	   }

	   public String getName() {
	      return name;
	   }

	   public String getAddress() {
	      return address;
	   }
	}