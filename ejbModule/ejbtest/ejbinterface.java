package ejbtest;

import javax.ejb.Remote;

@Remote
public interface ejbinterface {
	String theEjbCall1();
	void theEjbCall2(StringBuffer sb);
	// Example of primitive
	void theEjbCall3(int iParam1, int iParam2);
}
