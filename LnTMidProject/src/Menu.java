import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in);
	
	static Vector<Vehicle> vehicle = new Vector<Vehicle>();
	
	public static void main(String[] args) {
		
		int in = 0;
		boolean counter = false;
		
		do {
			System.out.println("Input the number:");
			System.out.println("1. Input");
			System.out.println("2. View");
			
			try {
				in = scanner.nextInt();
				if(in == 1) {
					input();
				}
				else if(in == 2) {
					display();
					finalDisplay();
			
				}
				else if(in < 1 || in > 2) {
					System.out.println("Input has to be 1 or 2");
				}
				else {
					counter = true;
				}
			}catch(Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("Input has to be a number");
			}
		}while(counter == false);
	}
	
	
	public static void input() {
		
		String type = "", brand = "", name = "", license = "", sType = "";
		Integer topSpeed = 0, gasCapacity = 0, wheel = 0, sAttribute = 0;
		
		while(true) {
			System.out.print("Input type [Car | Motorcycle]: ");
			type = scanner.next();
			if(type.equalsIgnoreCase("Car") || type.equalsIgnoreCase("Motorcycle")){
				break;
			}
			else {
				System.out.println("Input has to be Car or Motorcycle");
			}
		}
		
		while(true) {
			System.out.print("Input brand [>= 5]: ");
			brand = scanner.next();
			if(brand.length() >=5 ){
				break;
			}
			else {
				System.out.println("Input has to be >= 5 characters");
			}
		}
		
		while(true) {
			System.out.print("Input name [>= 5]: ");
			name = scanner.next();
			if(name.length() >=5 ){
				break;
			}
			else {
				System.out.println("Input has to be >= 5 characters");
			}
		}
		
		scanner.nextLine();
		while(true) {
			
			System.out.print("Input license: ");
//			scanner.next();
			license = scanner.nextLine();
			
			
			String regex = "^[A-Z ]+{1}[0-9 ]+{1,4}[A-Z]{1,3}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(license);
			if(m.matches()) {
				
				break;
			}
			else {
				
				System.out.println("Input has to be a single capital letter *space* 1-4 numbers *space* 1-3 capital letters");
				
			}
		}
		
		while(true) {
			try{
				System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
				topSpeed = scanner.nextInt();
				if(topSpeed >= 100 && topSpeed <= 250){
					break;
				}
				else {
					System.out.println("Input has to be between 100 - 250");
				}
			}catch(Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("Input has to be a number");
				continue;
			}
		}

		while(true) {
			try{
				System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
				gasCapacity = scanner.nextInt();
				if(gasCapacity >= 30 && gasCapacity <= 60){
					break;
				}
				else {
					System.out.println("Input has to be between 30 - 60");
				}
			}catch(Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("Input has to be a number");
				continue;
			}
		}

		SpecificVehicle s = new SpecificVehicle();

		if(type.equalsIgnoreCase("Car")) {
			while(true) {
				try{
					s.wheel();
					wheel = scanner.nextInt();
					if(wheel >= 4 && wheel <= 6){
						break;
					}
					else {
						System.out.println("Input has to be between 4 - 6");
					}
				}catch(Exception e) {
					scanner = new Scanner(System.in);
					System.out.println("Input has to be a number");
					continue;
				}
			}
			
			while(true) {
				s.specificType();
				sType = scanner.next();
				if(sType.equalsIgnoreCase("SUV") || sType.equalsIgnoreCase("Supercar") || sType.equalsIgnoreCase("Minivan")){
					break;
				}
				else {
					System.out.println("Input has to be SUV, Supercar or Minivan");
				}
			}
			
			while(true) {
				try{
					s.specificAttribute();
					sAttribute = scanner.nextInt();
					if(sAttribute >= 1){
						break;
					}
					else {
						System.out.println("Input has to be >= 1");
					}
				}catch(Exception e) {
					scanner = new Scanner(System.in);
					System.out.println("Input has to be a number");
					continue;
				}
			}
		}	
		else if(type.equalsIgnoreCase("Motorcycle")) {
			
			while(true) {
				try{
					s.wheelM();
					wheel = scanner.nextInt();
					if(wheel == 2){
						break;
					}
					else {
						System.out.println("Input has to be 2");
					}
				}catch(Exception e) {
					scanner = new Scanner(System.in);
					System.out.println("Input has to be a number");
					continue;
				}
			}
			
			while(true) {
				s.specificTypeM();
				sType = scanner.next();
				if(sType.equalsIgnoreCase("Manual") || sType.equalsIgnoreCase("Matic")){
					break;
				}
				else {
					System.out.println("Input has to be Manual or Matic");
				}
			}
		
			while(true) {
				try{
					s.specificAttributeM();
					sAttribute = scanner.nextInt();
					if(sAttribute >= 1){
						break;
					}
					else {
						System.out.println("Input has to be >= 1");
					}
				}catch(Exception e) {
					scanner = new Scanner(System.in);
					System.out.println("Input has to be a number");
					continue;
				}
			}
		}
		
		System.out.print("ENTER to return");
		scanner.nextLine();
		scanner.nextLine();
		
		Vehicle v = new Vehicle(type, brand, name, license, topSpeed, gasCapacity, wheel, sType, sAttribute);
		vehicle.add(v);
		
	}

	
	public static void display() {
		
		System.out.println(String.format("%1s %1s %1s %1s %1s %1s %1s", "|", "------", "|", "--------------", "|", "-----------------------------", "|"));
		System.out.println(String.format("%1s %3s %4s %10s %5s %10s %20s", "|", "No", "|", "Type", "|", "Name", "|"));
		System.out.println(String.format("%1s %1s %1s %1s %1s %1s %1s", "|", "------", "|", "--------------", "|", "-----------------------------", "|"));
		
		for(int i=0; i<vehicle.size(); i++) {
			System.out.println(String.format("%1s %3s %4s %10s %5s %10s %20s", "|", i+1, "|", vehicle.get(i).type, "|", vehicle.get(i).name, "|"));
			System.out.println(String.format("%1s %1s %1s %1s %1s %1s %1s", "|", "------", "|", "--------------", "|", "-----------------------------", "|"));

		}
		
		System.out.println(String.format("%1s %1s %1s %1s %1s %1s %1s", "|", "------", "|", "--------------", "|", "-----------------------------", "|"));
	}
	
	
	public static void finalDisplay() {
		int idx = -1;
		
		System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
		idx = scanner.nextInt();
		
		if(idx==0) {
			System.exit(0);
		}
		else {
			System.out.println("Brand: " + vehicle.get(idx-1).brand);
			System.out.println("Name: " + vehicle.get(idx-1).name);
			System.out.println("License Plate: " + vehicle.get(idx-1).license);
			System.out.println("Type: " + vehicle.get(idx-1).sType);
			System.out.println("Gas Capacity: " + vehicle.get(idx-1).gasCapacity);
			System.out.println("Top Speed: " + vehicle.get(idx-1).topSpeed);
			System.out.println("Wheel: " + vehicle.get(idx-1).wheel);
			
			if(vehicle.get(idx-1).sType.equalsIgnoreCase("Suv") || vehicle.get(idx-1).sType.equalsIgnoreCase("Minivan")) {
				System.out.println("Entertainment System: " + vehicle.get(idx-1).sAttribute);
				System.out.println("Turning on entertainment system...");
			}
			else if(vehicle.get(idx-1).sType.equalsIgnoreCase("Supercar")) {
				System.out.println("Entertainment System: " + vehicle.get(idx-1).sAttribute);
				System.out.println("Boosting!");
			}
			else if(vehicle.get(idx-1).type.equalsIgnoreCase("Motorcycle")) {
				System.out.println("Helmet amount: " + vehicle.get(idx-1).sAttribute);
				System.out.println(vehicle.get(idx-1).name + " is standing!");
			}
			
			int price;
			
			if(vehicle.get(idx-1).type.equalsIgnoreCase("Car")) {
				System.out.print("Please input the price of the entertainment system: ");
				price = scanner.nextInt();
				System.out.println("The price is " + vehicle.get(idx-1).sAttribute*price);
			}
			else if(vehicle.get(idx-1).type.equalsIgnoreCase("Motorcycle")) {
				System.out.print("Please input the price of the helmet: ");
				price = scanner.nextInt();
				System.out.println("The price is " + vehicle.get(idx-1).sAttribute*price);
			}
		}
		
		
	}
	
	// Input type [Car | Motorcycle]:
	// Input brand [>= 5]:
	// Input name [>= 5]:
	// Input license:
	// License awal huruf kapital spasi 1-4 angka spasi 1-3 huruf kapital
	// Input top speed [100 <= topSpeed <= 250]:
	// Input gas capacity [30 <= gasCap <= 60]:
	// Input wheel [4 <= wheel <= 6]:
	// Input type [SUV | Supercar | Minivan]:
	// Input entertainment system amount [>= 1]:
	// ENTER to return
	
	// No	type	Name
	
	// Brand:
	// Name:
	// License Plate:
	// Type:
	// Gas Capacity
	// Top Speed
	// Wheel
	// Entertainment System
	// Turning on entertainment system...
	// (supercar) Boosting!
	// (motorcycle) name is standing!
	
	// user diminta input harga dari helm ?
	// output Price:

}
