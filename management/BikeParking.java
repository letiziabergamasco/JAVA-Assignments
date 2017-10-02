package parking.management;

public class BikeParking extends Parking{
	
	BikeParking(){                       //constructor 1   
		length = 1.80;                    //to be used when vehicle size is standard
		width = 0.70;
		level = 1;
		vehicle_ok = true;
	}
	
	BikeParking(String num, double len, double wid){          //constructor 2
		length = 1.80;                         //to be used when unsure about dimensions
		width = 0.70;
		level = 1;
		if(isRightSize(len,wid)) {
			vehicle_ok = true;
		}
			else
				vehicle_ok = false;
	}

}
