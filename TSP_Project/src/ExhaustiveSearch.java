import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ExhaustiveSearch {

	private double totalDistance;
	private ArrayList<Point> order;
	public double duration;


	public ExhaustiveSearch(){
		totalDistance = 0.0;
		order = new ArrayList<Point>();	
		//testing = new ArrayList<Double>();
	}

	public void Execute(){
		totalDistance = 0.0;
		order = new ArrayList<Point>();	
		ReadInput input = new ReadInput("RandomInput.txt");
		RunTest(input.points,input.numPoints);
	}

	public void RunTest(ArrayList<Point> points, int n){
		Point firstPoint = points.get(0);
		double startTime = System.nanoTime();
		double distance = 999999999;
		int numPoints = n;
		int factorial = 1;
		ArrayList<ArrayList<Point>> permutations = new ArrayList<ArrayList<Point>>();
		permutations = listPermutations(points); // n!
		for (int i = 1; i <= numPoints; i++){ //n
			factorial*=i;
		}

		for (int i = 0; i < factorial; i++ ){ // n!
			if(permutations.get(i).get(0).equals(firstPoint)){
				double temp = 0.0;
				for (int j = 0; j < numPoints-1; j++){ //n
					temp += Point2D.distance(permutations.get(i).get(j).getX(), permutations.get(i).get(j).getY(),permutations.get(i).get(j+1).getX() , permutations.get(i).get(j+1).getY());

				}
				temp +=Point2D.distance(permutations.get(i).get(0).getX(), permutations.get(i).get(0).getY(),permutations.get(i).get(numPoints-1).getX() , permutations.get(i).get(numPoints-1).getY()); 
				if(temp <= distance){
					distance = temp;
					order = permutations.get(i);			
				}
			}
		}
		totalDistance = distance;
		double endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
	}

	//got Permutation function from https://stackoverflow.com/questions/24460480/permutation-of-an-arraylist-of-numbers-using-recursion
	public ArrayList<ArrayList<Point>> listPermutations(ArrayList<Point> list) {
		if (list.size() == 0) {
			ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
			result.add(new ArrayList<Point>());
			return result;
		}
		ArrayList<ArrayList<Point>> returnMe = new ArrayList<ArrayList<Point>>();

		Point firstElement = list.remove(0);

		ArrayList<ArrayList<Point>> recursiveReturn = listPermutations(list);
		for (ArrayList<Point> li : recursiveReturn) {

			for (int index = 0; index <= li.size(); index++) {
				ArrayList<Point> temp = new ArrayList<Point>(li);
				temp.add(index, firstElement);
				returnMe.add(temp);
			}
		}
		return returnMe;
	}


	public void Print() {
		System.out.println("Exhaustive Search");
		System.out.println("number of points: " + order.size());
		for (Point x: order) {
			System.out.println(x);

		}
		System.out.printf("total Distance: %.5f\n", totalDistance);	
		System.out.println("miliseconds passed: " + duration);
	}


}
