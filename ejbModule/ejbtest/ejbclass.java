
package ejbtest;

import javax.ejb.Stateless;

@Stateless
public class ejbclass implements ejbinterface {

	@Override
	public String theEjbCall1() {
		return "Hallo Ilia";
	}

	@Override
	public void theEjbCall2(StringBuffer sb) {
		System.out.println("theEjbCall2 1:" + sb.toString());
		sb.delete(0, sb.length());
		sb.append("String Buffered Hallo Ilia");
		System.out.println("theEjbCall2 2:" + sb.toString());
	}

	@Override
	public void theEjbCall3(int iParam1, int iParam2) {
		System.out.println("theEjbCall2 1:" + iParam1 + " " + iParam2);
		iParam1 = 100;
		iParam2 = 200;
		System.out.println("theEjbCall2 2:" + iParam1 + " " + iParam2);
	}

}
