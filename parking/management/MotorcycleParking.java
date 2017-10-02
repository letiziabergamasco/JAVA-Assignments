package parking.management;

public class MotorcycleParking extends Parking {

	MotorcycleParking(){  //void constructor
		length = 2.50;
		width = 1.40;
		level = 2;
	}
	
	MotorcycleParking(String num){      //constructor 1
		setRegistrationNumber(num);       //to be used when vehicle size is standard
		length = 2.50;
		width = 1.40;
		level = 2;
		vehicle_ok = true;
	}
	
	MotorcycleParking(String num, double len, double wid){          //constructor 2
		setRegistrationNumber(num);                             //to be used when unsure about dimensions
		length = 2.50;
		width = 1.40;
		level = 2;
		if(isRightSize(len,wid)) {
			vehicle_ok = true;
		}
			else
				vehicle_ok = false;
	}
	

}
