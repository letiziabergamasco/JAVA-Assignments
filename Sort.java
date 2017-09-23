
class Sort {
	
	public static int[] values = {12, 3, 6, 11, 1, 8, 15, 9, 5, 10, 2, 13, 4, 14, 7};
	
	public static void sortDown(int[] val) {
		
		for(int i=0; i<val.length-1; i++) {
			
			int maxIndex = i;
			for(int j=i+1; j<val.length; j++) {
				if(val[j]>val[maxIndex]) 
					maxIndex=j;	
			}
			int tmp = val[maxIndex];
			val[maxIndex] = val[i];
			val[i] = tmp;
		}

	}
	
	public static void printArray(int[] ar) {
		
		for(int n=0; n<ar.length; n++)
			System.out.print(ar[n] + " ");
		System.out.println("");
		
	} 

	public static void main(String[] arguments) {
		
		System.out.println("Your integer array is:");
		printArray(values);
		System.out.println("Now your array is sorted in a descending order:");
		sortDown(values);
		printArray(values);
		
	}

}
