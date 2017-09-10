
public class testing {
	
	public static void main(String[] args) {	
		RandomFileGenerator hello = new RandomFileGenerator();
		NearestNeighbor NN = new NearestNeighbor();
		ExhaustiveSearch ES = new ExhaustiveSearch();
		
		//hello.setN(10);
		//hello.Generate();
		NN.Execute();
		NN.Print();
		ES.Execute();
		ES.Print();
		
		
		/*		
		int[] arrNN = {100,300,400,500,600,700,800,900,1000};
		int[] arrES = {2,4,6,7,8,9,10};
		
		System.out.println("Nearest Neighbor:");
		for (int i = 0; i < arrNN.length; i++){
			double miliseconds = 0.0;
			for(int j = 0; j < 3; j++){
				hello.setN(arrNN[i]);
				hello.Generate();
				NN.Execute();
				miliseconds += NN.duration;
			}
			System.out.println(arrNN[i] + ": " + miliseconds/3.0 );		
		}
		
		
		System.out.println("Exhaustive search:");
		for (int i = 0; i < arrES.length; i++){
			double miliseconds = 0.0;
			for(int j = 0; j < 3; j++){
				hello.setN(arrES[i]);
				hello.Generate();
				ES.Execute();
				miliseconds += ES.duration;
			}
			System.out.println(arrES[i] + ": " + miliseconds/3.0 );		
		}
		
		*/
		
		
	}

}
