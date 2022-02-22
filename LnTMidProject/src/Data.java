
public abstract class Data {
	// Input type [Car | Motorcycle]:
	// Input brand [>= 5]:
	// Input name [>= 5]:
	// Input license:
	// Input top speed [100 <= topSpeed <= 250]:
	// Input gas capacity [30 <= gasCap <= 60]:
	// Input wheel [4 <= wheel <= 6]:
	// Input type [SUV | Supercar | Minivan]:
	// Input entertainment system amount [>= 1]:
	// Input helmet amount [>=1]:
	// ENTER to return
	
	public String type, brand, name, license, sType;
	Integer sAttribute;
	public Integer topSpeed, gasCapacity, wheel;

	public Data(String type, String brand, String name, String license, 
				Integer topSpeed, Integer gasCapacity, Integer wheel,
				String sType, Integer sAttribute) {
		
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.license = license;
		this.topSpeed = topSpeed;
		this.gasCapacity = gasCapacity;
		this.wheel = wheel;
		this.sType = sType;
		this.sAttribute = sAttribute;
	}
	

}
