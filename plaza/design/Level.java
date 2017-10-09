package plaza.design;

import java.util.ArrayList;

public class Level {
	
	//constructor
	public Level() {}
	
	

	private int floor;
	
	private ArrayList<ParkingSpot> spots = new ArrayList<>();
	private ArrayList<Exit> exits = new ArrayList<>();
	
	//spots_number => spots.size()
	//exits_number => exits.size()
	
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<Bus> bus = new ArrayList<>();
	private ArrayList<Bike> bikes = new ArrayList<>();
	
	//getters and setters
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getSpotsNumber() {
		return spots.size();
	}

	public int getExitsNumber() {
		return exits.size();
	}

	public ArrayList<ParkingSpot> getSpots() {
		return spots;
	}
	
	public ArrayList<Exit> getExits() {
		return exits;
	}
	
	
	//adding and removing vehicles
	public void addVehicle(Car car) {
		this.cars.add(car);
		System.out.println("Car " + car.getRegistrationNumber() + " is in plaza now");
	}
	
	public void addVehicle(Bus bus) {
		this.bus.add(bus);
		System.out.println("Bus " + bus.getRegistrationNumber() + " is in plaza now");
	}
	
	public void addVehicle(Bike bike) {
		this.bikes.add(bike);
		System.out.println("Bike " + bike.getRegistrationNumber() + " is in plaza now");
	}
	
	public void removeCar(String reg_num) {
		boolean found = false;
		
		for(int i=0; i<cars.size() && found==false;i++) {
			if(cars.get(i).getRegistrationNumber().equals(reg_num)) {
				
				found = true;
				System.out.println("Car " + cars.get(i).getRegistrationNumber() + " is out of plaza now");
				this.cars.remove(i);
			}	
		}
	}
	
	public void removeBus(String reg_num) {
		boolean found = false;
		for(int i=0; i<cars.size() && found==false;i++) {
			if(bus.get(i).getRegistrationNumber().equals(reg_num)) {
				found = true;
				this.bus.remove(i);
			}	
		}
	}
	
	public void removeBike(String reg_num) {
		boolean found = false;
		for(int i=0; i<bikes.size() && found==false;i++) {
			if(bikes.get(i).getRegistrationNumber().equals(reg_num)) {
				found = true;
				this.bikes.remove(i);
			}	
		}
	}

	
	//adding and removing spots, exits
		public void addSpot(ParkingSpot ps) {
			this.spots.add(ps);
		}
		
		public void addExit(Exit ex) {
			this.exits.add(ex);
		}
		
		public void removeSpot(ParkingSpot ps) {
			this.spots.add(ps);
		}
		
		public void removeExit(Exit ex) {
			this.exits.add(ex);
		}
	

	//other methods
	
	public int availableSpots() {  //gives the number of available spots
		int available_spots = 0;
		for(int i=0; i<spots.size(); i++) {
			if(spots.get(i).isFree() == true)
				available_spots++;	
		}
		return available_spots;
	}
	
	public boolean canFit(int n_spots) {    //given the spots required for the vehicle
										//tells if there are enough adjacent spots
		boolean fits = false;
		int count = 0;
		for(int i=0; i<this.spots.size() && fits == false; i++) {
			
			if(spots.get(i).isFree() == true)
				count++;
			else
				count=0;
			if(count == n_spots)
				fits = true;
		}
		return fits;
		
	}
	
	public int updateSpotsAdd(int n_spots) {  //updates spots when adding a vehicle
		int index = 0;
		boolean updated = false;
		int count = 0;
		for(int i=0; i<this.spots.size() && updated == false; i++) {
			if(spots.get(i).isFree() == true)
				count++;
			else
				count=0;
			if(count == n_spots) {
				index = i-count+1;
				for(int j=i; j>=(i-count+1);j--)
					spots.get(i).setFree(false);
				updated = true;
			}
		}
		return index;
		
	}
	
	
	public void updateSpotsRemove(int index, int n_spots) {  //updates spots when removing a vehicle
		for(int i=index; i<index+n_spots; i++) {
			spots.get(i).setFree(true);
		}
	}
	
	public int findCarByRegistrationNumber(String num) { //returns index in the list
															//-1 if not found
		int index = -1;
		for(int i=0; i<cars.size() && index==(-1); i++) {
			if(cars.get(i).getRegistrationNumber().equals(num)) {
				index = i;
			}
				
		}
		
		return index;
	}
	
	public int findBusByRegistrationNumber(String num) { //returns index in the list
		
		int index = -1;
		for(int i=0; i<bus.size() && index==(-1); i++) {
			if(bus.get(i).getRegistrationNumber().equals(num))
				index = i;
		}
		return index;
		
	}
	
	public int findBikeByRegistrationNumber(String num) {  //returns index in the list
		
		int index = -1;
		for(int i=0; i<bikes.size() && index==(-1); i++) {
			if(bikes.get(i).getRegistrationNumber().equals(num))
				index = i;
		}
		return index;
		
	}
	
	public int getCarSpotsByIndex(int ind) { 
		return cars.get(ind).getNspots();
	}
	
	public int getBusSpotsByIndex(int ind) { 
		return bus.get(ind).getNspots();
	}
	
	public int getBikeSpotsByIndex(int ind) { 
		return bikes.get(ind).getNspots();
	}

}
