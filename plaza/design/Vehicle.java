package plaza.design;

public abstract class Vehicle {
	
	private double length;
	private double width;
	private double height;
	
	private String registration_number;
	
	private int n_spots; //number of spots required by the vehicle
	private int spot_index; //spot where the vehicle is parked (first spot, if there are many)

	//getters and setters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getRegistrationNumber() {
		return registration_number;
	}

	public void setRegistrationNumber(String registration_number) {
		this.registration_number = registration_number;
	}

	public int getNspots() {
		return n_spots;
	}

	public void setNspots(int n_spots) {
		this.n_spots = n_spots;
	}

	public int getSpotIndex() {
		return spot_index;
	}

	public void setSpotIndex(int spot_index) {
		this.spot_index = spot_index;
	}
	

}
