package com.design.patterns.chainofresponsibility;

public class Client {

	public static void main(String[] args) {
		AuthenticationHandler auth = new AuthenticationHandler ("12345");
		ContentTypeHandler cont = new ContentTypeHandler("Json");
		PayloadHandler payload = new PayloadHandler("Body : {\"username\" = \"john\"}");
		
		auth.next = cont;
		cont.next = payload;
		
		String withAuth = auth.addHandler("Headers with authentication");
		System.out.println(withAuth);
		
		System.out.println("\n");
		
		String withoutAuthentication = cont.addHandler("Headers without Authentication");
		System.out.println(withoutAuthentication);

	}

}
