package plaza.design;

public class Bus extends Vehicle{
	
	//general constructor
	public Bus(String type, String reg_num) {
		setBusType(type);
		setRegistrationNumber(reg_num);
		setNspots(3); //default number of spots is 3
	}
	
	//constructor with spots number, if it's different from the default one
	public Bus(String type, String reg_num, int spots) {
		setBusType(type);
		setRegistrationNumber(reg_num);
		setNspots(spots);
	}
	
	//constructor with all vehicle characteristics
	public Bus(String type, String reg_num, double l, double w, double h) {
		setBusType(type);
		setRegistrationNumber(reg_num);
		setNspots(3);
		setLength(l);
		setWidth(w);
		setHeight(h);
	}
	
	

	private String bus_type;
	
	//getters and setters
	public String getBusType() {
		return bus_type;
	}

	public void setBusType(String bus_type) {
		this.bus_type = bus_type;
	}


}
