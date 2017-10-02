package parking.management;

public class TruckParking extends Parking{
	
	TruckParking(){  //void constructor
		length = 22.50;
		width = 4.00;
		level = 1;
	}
		
	TruckParking(String num){       //constructor 1
		setRegistrationNumber(num);     //to be used when vehicle size is standard
		length = 22.50;
		width = 4.00;
		level = 1;
		vehicle_ok = true;
	}
	
	TruckParking(String num, double len, double wid){          //constructor 2
		setRegistrationNumber(num);                         //to be used when unsure about dimensions
		length = 22.50;
		width = 4.00;
		level = 1;
		if(isRightSize(len,wid)) {
			vehicle_ok = true;
		}
			else
				vehicle_ok = false;
	}

}
