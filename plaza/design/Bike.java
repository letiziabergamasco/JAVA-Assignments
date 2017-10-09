package plaza.design;

public class Bike extends Vehicle{
	
	//general constructor
	public Bike(String type, String reg_num) {
		setBikeType(type);
		setRegistrationNumber(reg_num);
		setNspots(1); //default number of spots is 1
	}
	

	
	private String bike_type;
	
	//getters and setters
	public String getBikeType() {
		return bike_type;
	}

	public void setBikeType(String bike_type) {
		this.bike_type = bike_type;
	}
	

}
