package plaza.design;

public class Exit {
	
	//constructors
	public Exit() {}
	
	public Exit(double w, double h, String loc) {
		this.width = w;
		this.height = h;
		this.location = loc;
	}
	
	
	
	private double width;
	private double height;
	private String location;
	
	//getters and setters
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	//other methods
	
	public boolean canExit(double width, double height) { //given the dimensions of a vehicle
													//tells if the vehicle can use this exit
		if(width < this.width && height < this.height)
			return true;
		else
			return false;
	}
	
}
