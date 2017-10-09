package plaza.design;

import java.util.ArrayList;

public class ParkingLot {
	
	//constructor
	public ParkingLot() {}
	
	
	private ArrayList<Level> levels = new ArrayList<>();
	//levels_number => levels.size()
	private Exit entrance;
	
	
	//getters and setters
	public int getLevelsNumber() {
		return levels.size();
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}
	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}
	public Exit getEntrance() {
		return entrance;
	}
	public void setEntrance(Exit entrance) {
		this.entrance = entrance;
	}

	
	
	//adding and removing levels
	public void addLevel(Level l) {
		this.levels.add(l);
	}

	public void removeLevel(Level l) {
		this.levels.remove(l);
	}
	
	//other methods
	
	public int freeSpaces() {  //tells how many free spaces there are in the whole plaza
		int spaces = 0;
		for(int i=0; i<levels.size(); i++) {
			spaces += levels.get(i).availableSpots();
		}
		return spaces;
	}
	
	public void addVehicle(Car car) { 
		boolean added = false;
		for(int i=0; i<levels.size() && added==false; i++) {
			
			if(levels.get(i).canFit(car.getNspots())) {
				
				car.setSpotIndex(levels.get(i).updateSpotsAdd(car.getNspots()));	//updates spots
				levels.get(i).addVehicle(car); //adds the car
				
				added = true;
			}
		}
		
		if(added == false)
			System.out.println("There isn't enough space for this vehicle now");	
	}
	
	public void addVehicle(Bus bus) {
		boolean added = false;
		for(int i=0; i<levels.size() && added==false; i++) {
			if(levels.get(i).canFit(bus.getNspots())) {
				bus.setSpotIndex(levels.get(i).updateSpotsAdd(bus.getNspots()));	//updates spots
				levels.get(i).addVehicle(bus); //adds the bus
				
				added = true;
			}
		}
		
		if(added == false)
			System.out.println("There isn't enough space for this vehicle now");
	}
	
	public void addVehicle(Bike bike) { //true only if vehicle is added successfully
		boolean added = false;
		for(int i=0; i<levels.size() && added==false; i++) {
			if(levels.get(i).canFit(bike.getNspots())) {
				bike.setSpotIndex(levels.get(i).updateSpotsAdd(bike.getNspots()));	//updates spots
				levels.get(i).addVehicle(bike); //adds the bike
				
				added = true;
			}
		}
		
		if(added == false)
			System.out.println("There isn't enough space for this vehicle now");
	}
	
	public void removeCar(String reg_num) { 
		boolean found = false;
		int floor = 0;
		int index = -1;
		for(int i=0; i<levels.size() && found==false; i++) {
			if(levels.get(i).findCarByRegistrationNumber(reg_num) != -1) {
				found = true;
				floor = i;
				index = levels.get(i).findCarByRegistrationNumber(reg_num);
			}
		}
		
		if(found == false) {
			System.out.println("This vehicle is not in plaza now");
		}
		else { //it is in level <floor>
			
			int n_spots = levels.get(floor).getCarSpotsByIndex(index);
			levels.get(floor).updateSpotsRemove(index, n_spots); //updates spots
			levels.get(floor).removeCar(reg_num); //removes the car

		}
	}
	
	public void removeBus(String reg_num) { 
		
		boolean found = false;
		int floor = 0;
		int index = -1;
		for(int i=0; i<levels.size() && found==false; i++) {
			if(levels.get(i).findBusByRegistrationNumber(reg_num) != -1) {
				found = true;
				floor = i;
				index = levels.get(i).findBusByRegistrationNumber(reg_num);
			}
		}
		
		if(found == false) {
			System.out.println("This vehicle is not in plaza now");
		}
		else { //it is in level <floor>
			
			int n_spots = levels.get(floor).getBusSpotsByIndex(index);
			levels.get(floor).updateSpotsRemove(index, n_spots); //updates spots
			levels.get(floor).removeBus(reg_num); //removes the bus

		}
	}
	
	public void removeBike(String reg_num) { 
		boolean found = false;
		int floor = 0;
		int index = -1;
		for(int i=0; i<levels.size() && found==false; i++) {
			if(levels.get(i).findBikeByRegistrationNumber(reg_num) != -1) {
				found = true;
				floor = i;
				index = levels.get(i).findBikeByRegistrationNumber(reg_num);
			}
		}
		
		if(found == false) {
			System.out.println("This vehicle is not in plaza now");
		}
		else { //it is in level <floor>
			
			int n_spots = levels.get(floor).getBikeSpotsByIndex(index);
			levels.get(floor).updateSpotsRemove(index, n_spots); //updates spots
			levels.get(floor).removeBike(reg_num); //removes the bike

		}
	}
	
	

}
