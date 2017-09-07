import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ExhaustiveSearch {

	private double totalDistance;
	private ArrayList<Point> order;
	
	
	public static void main(String[] args) {		
		ExhaustiveSearch hi = new ExhaustiveSearch();
		ReadInput input = new ReadInput("Inputs.txt");
		//hi.RunTest(input.points,input.numPoints);
		//hi.Print();
			
	}

public ExhaustiveSearch(){
	totalDistance = 0.0;
	order = new ArrayList<Point>();	
}

public void RunTest(ArrayList<Point> points, int n){
	double distance = 999999999;
	int numPoints = n;
	ArrayList<ArrayList<Point>> permutations = new ArrayList<ArrayList<Point>>();
	permutations = listPermutations(points);
	for (int i = 0; i < n; i++){
		n*=n;
	}
	
	double temp = 0.0;
	for (int i = 0; i < n; i++ ){
		for (int j = 0; j < numPoints-1; j++){
			temp = Point2D.distance(permutations.get(i).get(j).getX(), permutations.get(i).get(j).getY(),permutations.get(i).get(j+1).getX() , permutations.get(i).get(j+1).getY())
		}
	}
	
	
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
	for (Point x: order) {
		System.out.println(x);
		
	}
	System.out.printf("total Distance: %.5f\n", totalDistance);	
}

}
