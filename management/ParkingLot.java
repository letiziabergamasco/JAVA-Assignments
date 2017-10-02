package parking.management;

import java.util.ArrayList;


public class ParkingLot {
	
	static ArrayList<CarParking> cars = new ArrayList<CarParking>();	//level 3
	static ArrayList<TruckParking> trucks = new ArrayList<TruckParking>();	//level 1
	static ArrayList<BikeParking> bikes = new ArrayList<BikeParking>();	//level 1
	static ArrayList<MotorcycleParking> motorcycles = new ArrayList<MotorcycleParking>();	//level 2
	
	static int max_cars = 100;
	static int max_trucks = 20;
	static int max_bikes = 80;
	static int max_motorcycles = 60;
	
	//1 => car, 2 => truck, 3 => motorcycle, 4 => bike
	//given a vehicle, tells if there are free places for that vehicle
	static boolean isSpace(int vehicle) {  
		switch(vehicle) {
			case 1: 
				if(cars.size() < max_cars)
					return true;
				else
					return false;
			case 2: 
				if(trucks.size() < max_trucks)
					return true;
				else
					return false;
			case 3: 
				if(motorcycles.size() < max_motorcycles)
					return true;
				else
					return false;
			case 4: 
				if(bikes.size() < max_bikes)
					return true;
				else
					return false;
			default: 
				System.out.println("Invalid number");
				return false;
			}
	}
	
	static void printVehicles() {   //registration number of all vehicles in plaza
		int i;
		System.out.println("These vehicles are in plaza:");
		for(i=0;i<cars.size();i++)
			System.out.println("Car " + cars.get(i).getRegistrationNumber());
		for(i=0;i<trucks.size();i++)
			System.out.println("Truck " + trucks.get(i).getRegistrationNumber());
		for(i=0;i<bikes.size();i++)
			System.out.println("Bike n° " + (i+1));
		for(i=0;i<motorcycles.size();i++)
			System.out.println("Motorcycle " + motorcycles.get(i).getRegistrationNumber());
	}
	
	//1 => car, 2 => truck, 3 => motorcycle, 4 => bike
	//given a vehicle, tells which is its level
	static int findLevel(int vehicle) {
		switch(vehicle) {
		case 1: 
			return 3;
		case 2: 
			return 1;
		case 3: 
			return 2;
		case 4: 
			return 1;
		default: 
			System.out.println("Invalid number");
			return -1;
		}
		
	}
	
	//tells how many free places there are in plaza
	static int freePlaces() {
		int places = 0;
		places += (max_cars - cars.size());
		places += (max_trucks - trucks.size());
		places += (max_bikes - bikes.size());
		places += (max_motorcycles - motorcycles.size());
		
		return places;
	}
	
	
	
	
	public static void main(String[] args) {
		
		//new car arriving in plaza
		CarParking car1 = new CarParking("AB123CD");
		car1.setArrivingTime(12.00);
		
		if(isSpace(1) == true) {
			if(car1.vehicle_ok == true) {
				cars.add(car1);
				System.out.println("Car " + car1.getRegistrationNumber() + " is in plaza now");
			}
			else
				System.out.println("The vehicle is too big");
		}
		else 
			System.out.println("No free places for this vehicle");
		
		//new bike arriving in plaza
		BikeParking bike1 = new BikeParking();
		bike1.setArrivingTime(12.00);
		
		if(isSpace(4) == true) {
			if(bike1.vehicle_ok == true) {
				bikes.add(bike1);
				System.out.println("Bike n° " + bikes.size() + " is in plaza now");
			}
			else
				System.out.println("The vehicle is too big");
		}
		else 
			System.out.println("No free places for this vehicle");
		
		//printing all vehicles in plaza
		System.out.println("");
		printVehicles();
		
		//printing number of free places
		System.out.println("");
		System.out.print("There are " + freePlaces() + " free places");
		System.out.println(" out of " + (max_cars + max_trucks + max_bikes + max_motorcycles));
		
		//car going out of plaza
		car1 = cars.get(0);
		car1.setLeavingTime(13.50);
		System.out.println("");
		System.out.println("Car " + car1.getRegistrationNumber() + " is leaving");
		System.out.println("Parking cost is " + car1.cost(car1.getArrivingTime(),car1.getLeavingTime()));
		System.out.println("");
		cars.remove(0);
		
		//big truck arriving in plaza
		TruckParking truck1 = new TruckParking("EF456GH", 30.00, 3.50);
		truck1.setArrivingTime(14.30);
		System.out.println("Truck " + truck1.getRegistrationNumber() + " is arriving in plaza");
		
		if(isSpace(2) == true) {
			if(truck1.vehicle_ok == true) {
				trucks.add(truck1);
				System.out.println("Truck " + truck1.getRegistrationNumber() + " is in plaza now");
			}
			else
				System.out.println("The vehicle is too big");
		}
		else 
			System.out.println("No free places for this vehicle");	
	
	}

}
