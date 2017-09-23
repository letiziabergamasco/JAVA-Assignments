
public class Triangle {
	
	int size;
	
	Triangle(int s){
		size=s;
	};

	public void printTriangle() {
		
		int stop;
		
		for(int i=1;i<=2*size+1;i++) {
			String toPrint = "";
			if(i<size+1)
				stop=2*i;
			else if(i==size+1)
				stop= 2*size +1;
				else
					stop=2*(2*(size+1)-i);
			for(int j=0;j<stop;j++) {
				toPrint+="*";	
			}
			
			System.out.println(toPrint);
		}
	}
	
	
	
	public static void main(String[] arguments) {
		
		int sizeToInt = Integer.parseInt(arguments[0]);
		Triangle myTriangle = new Triangle(sizeToInt);
		
		myTriangle.printTriangle();
		
		}
}
