package plaza.design;

import java.io.*;

/*FILE NAME: plaza
 * 
 * FILE FORMAT: <E or L> <Vehicle> <Registration_number> <Vehicle_type>
 *
 *When it detects a vehicle not in plaza trying to leave the plaza (L = leaving)
 *it prints the error message: "This vehicle is not in plaza now"
 */

public class Main {

	public static void main(String[] args) throws IOException{
		
		//creating the plaza
		
		ParkingLot plaza = new ParkingLot();
		Level level0 = new Level();
		
		Exit exit1 = new Exit();
		exit1.setLocation("Front");
		level0.addExit(exit1); //one exit added
		
		for(int i=0; i<50; i++) { //50 spots added
			ParkingSpot newspot = new ParkingSpot();
			newspot.setFree(true);
			newspot.setLevelNumber(0);
			newspot.setSpotNumber(i);
			level0.addSpot(newspot);
		}
		
		plaza.addLevel(level0);
		System.out.println("New plaza has been created");
		System.out.println("");
		
		//reading from file
		try {
			FileReader fr = new FileReader("./src/plaza/design/plaza");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			
			String entering_leaving = null;
			String vehicle = null;
			String registration_number = null;
			String vehicle_type = null;
			
			while ((line = br.readLine()) != null) {
				
				String[] split = line.split(" ");
				entering_leaving = split[0];
				vehicle = split[1];
				registration_number = split[2];
				vehicle_type = split[3];
				
				
				if(entering_leaving.equals("E")) {
					
					switch(vehicle) {
					case "Car":
						Car newcar = new Car(vehicle_type, registration_number);
						plaza.addVehicle(newcar);
						break;
					case "Bus":
						Bus newbus = new Bus(vehicle_type, registration_number);
						plaza.addVehicle(newbus);
						break;
					case "Bike":
						Bike newbike = new Bike(vehicle_type, registration_number);
						plaza.addVehicle(newbike);
						break;
					default:
							System.out.println("Wrong file format");
					}
					
				}
				else if(entering_leaving.equals("L")) {
					
					switch(vehicle) {
					case "Car":
						plaza.removeCar(registration_number);
						break;
					case "Bus":
						plaza.removeBus(registration_number);
						break;
					case "Bike":
						plaza.removeBike(registration_number);
						break;
					default:
							System.out.println("Wrong file format");
					}
					
				}
				else {
					System.out.println("Wrong file format");
				}
					
			}
			
			br.close();
			
		} catch (IOException e) {
			 System.out.println("An error occurred: " + e);
		}

	}

}
