package plaza.design;

public class Car extends Vehicle{
	
	//general constructor
	public Car(String type, String reg_num) {
		setCarType(type);
		setRegistrationNumber(reg_num);
		setNspots(1); //default number of spots is 1
	}
	
	//constructor with spots number, if it's different from the default one
	public Car(String type, String reg_num, int spots) {
		setCarType(type);
		setRegistrationNumber(reg_num);
		setNspots(spots);
	}
	
	//constructor for electric or disabled cars
	public Car(String type, String reg_num, boolean el, boolean dis) {
		setCarType(type);
		setNspots(1);
		setRegistrationNumber(reg_num);
		setElectric(el);
		setDisabled(dis);
	}

	
	private String car_type;
	private boolean electric = false;
	private boolean disabled = false;
	
	
	//getters and setters
	public String getCarType() {
		return car_type;
	}

	public void setCarType(String car_type) {
		this.car_type = car_type;
	}

	public boolean isElectric() {
		return electric;
	}

	public void setElectric(boolean electric) {
		this.electric = electric;
	}
	
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


}
