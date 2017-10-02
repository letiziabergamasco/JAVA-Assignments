package parking.management;

public class Parking {
	
	double cost_per_hour = 2.00;
	private double arriving_time;
	private double leaving_time;	
	
	double getArrivingTime() {
		return arriving_time;
	}
	double getLeavingTime() {
		return leaving_time;
	}
	void setArrivingTime(double t1) {
		arriving_time = t1;
	}
	void setLeavingTime(double t2) {
		leaving_time = t2;
	}
	
	int level;
	
	double length; //parking spot dimensions
	double width;
	
	boolean vehicle_ok;  //true if vehicle dimensions fit parking spot dimensions
	
	private String registration_number; //vehicle registration number
	
	String getRegistrationNumber() {
		return registration_number;
	}
	void setRegistrationNumber(String r) {
		registration_number = r;
	}
	
	
	double cost(double time1, double time2) {
			return (time2 - time1) * cost_per_hour;
	}
	
	boolean isRightSize(double len, double wid){
		if(len<length && wid<width)
			return true;
		else
			return false;
		
	}
	
			

}
