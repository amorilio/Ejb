package client;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import ejbtest.ejbclass;
import ejbtest.ejbinterface;

public class Client {

	public static void main(String[] args){
		InitialContext ctx=getInitialContext();
		Object ref=null;
		try {
			ref = ctx.lookup("ejbclass/remote");
		} catch (NamingException e) {
			System.out.println("Lookup Failed");
			e.printStackTrace();
		}
		ejbinterface  stub=(ejbinterface)PortableRemoteObject.narrow(ref, ejbinterface.class);
		System.out.println(stub.theEjbCall1());
		StringBuffer sb = new StringBuffer("String From Client");

		// WRONG !!!!!!! 
		// EJB doesn't works by reference. should be call by value 
		stub.theEjbCall2(sb);
		System.out.println(sb.toString());

		// WRONG !!!!!!! 
		// EJB doesn't works by reference even when passing primitives 
		int i1 = 0;
		int i2 = 0;		
		stub.theEjbCall3(i1,i2);
		System.out.println("Result From EJB: "+ i1 + " " + i2);
	}
	
	public static InitialContext getInitialContext(){
		Hashtable<String,String> h=new Hashtable<String,String>();
		h.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		h.put("java.naming.provider.url","localhost");
		try {
			return new InitialContext(h);
		} catch (NamingException e) {
			System.out.println("Cannot generate InitialContext");
			e.printStackTrace();
		}
		return null;
	}
}
