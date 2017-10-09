package plaza.design;

public class ParkingSpot {
	
	//constructor
	public ParkingSpot() {}
	
	private int level_number;
	private int spot_number;
	
	private boolean free;
	private boolean disabled;
	private boolean electrical_charging;
	
	//getters and setters
	public int getLevelNumber() {
		return level_number;
	}

	public void setLevelNumber(int level_number) {
		this.level_number = level_number;
	}

	public int getSpotNumber() {
		return spot_number;
	}

	public void setSpotNumber(int spot_number) {
		this.spot_number = spot_number;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isElectricalCharging() {
		return electrical_charging;
	}

	public void setElectricalCharging(boolean electrical_charging) {
		this.electrical_charging = electrical_charging;
	}

	
}
