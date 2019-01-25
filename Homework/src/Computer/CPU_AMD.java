package Computer;

import Computer.CPU;

public class CPU_AMD implements CPU {

	@Override
	public String brand() {
		// TODO Auto-generated method stub
		return "amd ";
	}

	@Override
	public String frequency() {
		// TODO Auto-generated method stub
		return "2.8GHZ";
	}

//	public static void main(String[] args) {
//		System.out.println(CPU_AMD.i);
//	}
}
