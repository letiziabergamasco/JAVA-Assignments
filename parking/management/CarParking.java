package parking.management;


public class CarParking extends Parking{

	CarParking(){   //void constructor
		length = 4.20;
		width = 1.80;
		level = 3;
	}
	
	CarParking(String num){             //constructor 1
		setRegistrationNumber(num);       //to be used when vehicle size is standard
		length = 4.20;
		width = 1.80;
		level = 3;
		vehicle_ok = true;
	}
	
	CarParking(String num, double len, double wid){     //constructor 2
		setRegistrationNumber(num);      //to be used when unsure about dimensions
		length = 4.20;
		width = 1.80;
		level = 3;
		if(isRightSize(len,wid)) {
			vehicle_ok = true;
		}
			
			else
				vehicle_ok = false;
	}
	
}
