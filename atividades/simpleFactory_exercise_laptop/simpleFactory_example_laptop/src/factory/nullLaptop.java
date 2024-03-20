package factory;

public class nullLaptop implements Laptop{

	

	@Override
	public void assemble(String model, String cpu, int ram, int hd) {
		System.out.println("Notebook nulo");
		
	}

	@Override
	public void runTests() {
		System.out.println("Notebook nulo");
		
	}

	@Override
	public boolean isNull() {
		
		return true;
	}

}
