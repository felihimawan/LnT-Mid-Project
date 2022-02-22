
public class SpecificVehicle extends Specifics{

	@Override
	public void specificType() {
		System.out.print("Input type [SUV | Supercar | Minivan]:");
		
	}

	@Override
	public void specificTypeM() {
		System.out.print("Input type [Manual | Matic]:");
		
	}

	@Override
	public void specificAttribute() {
		System.out.print("Input entertainment system amount [>= 1]: ");
		
	}

	@Override
	public void specificAttributeM() {
		System.out.print("Input helmet amount [>= 1]: ");
		
	}

	@Override
	public void wheel() {
		System.out.print("Input wheel [4 <= wheel <= 6]: ");
		
	}

	@Override
	public void wheelM() {
		System.out.print("Input wheel [Has to be 2]: ");
		
	}

}
