import java.awt.geom.Point2D;

public class testing {
	
	public static void main(String[] args) {	
		RandomFileGenerator hello = new RandomFileGenerator();
		NearestNeighbor NN = new NearestNeighbor();
		ExhaustiveSearch ES = new ExhaustiveSearch();
		
		//hello.setN(10);
		//hello.Generate();
		//NN.Execute();
		//NN.Print();
		//ES.Execute();
		//ES.Print();
		//System.out.println(Point2D.distance(11, 7, 50, 8)+Point2D.distance(50, 8,3,4)+Point2D.distance(3,4,6,8)+Point2D.distance(6,8,11,7));
		
		
		
		int[] arrNN = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
		int[] arrES = {5,6,7,8,9,10};
		/*
		System.out.println("Nearest Neighbor:");
		for (int i = 0; i < arrNN.length; i++){
			double miliseconds = 0.0;
				hello.setN(arrNN[i]);
				hello.Generate();
			for(int j = 0; j < 3; j++){
			
				NN.Execute();
				miliseconds += NN.duration;
				System.out.println(NN.duration);
			}
			System.out.println(arrNN[i] + ": " + miliseconds/3.0 );		
		}
		
		*/
		
		System.out.println("Exhaustive search:");
		for (int i = 0; i < arrES.length; i++){
			double miliseconds = 0.0;
				hello.setN(arrES[i]);
				hello.Generate();
			for(int j = 0; j < 3; j++){
		
				ES.Execute();
				miliseconds += ES.duration;
				System.out.print(ES.duration + " ");
			}
			System.out.println();
			System.out.println("results for " +arrES[i] + ": " + miliseconds/3.0 +"\n");		
		}
		
		
		
		
		
	}

}
