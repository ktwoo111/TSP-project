
public class testing {
	
	public static void main(String[] args) {	
		RandomFileGenerator hello = new RandomFileGenerator();
		NearestNeighbor NN = new NearestNeighbor();
		
		int[] arr = {100,300,400,500,600,700,800,900,1000};
		
		for (int i = 0; i < arr.length; i++){
			double miliseconds = 0.0;
			for(int j = 0; j < 3; j++){
				hello.setN(arr[i]);
				hello.Generate();
				NN.Execute();
				miliseconds += NN.duration;
			}
			System.out.println(arr[i] + ": " + miliseconds/3.0 );		
		}
		
		
		
		
	}

}
