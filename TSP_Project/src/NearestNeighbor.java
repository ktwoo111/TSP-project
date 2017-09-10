import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class NearestNeighbor {
	private double totalDistance;
	private ArrayList<Point> order;
	public double duration;
	
	public static void main(String[] args) {		
		NearestNeighbor hi = new NearestNeighbor();
		ReadInput input = new ReadInput("RandomInput.txt");
		hi.RunTest(input.points, input.visited, input.numPoints);
		hi.Print();
	}
	
	public NearestNeighbor(){
		totalDistance = 0.0;
		order = new ArrayList<Point>();
		duration = 0;
	}

	public void Execute(){
		totalDistance = 0.0;
		order = new ArrayList<Point>();
		duration = 0;
		
		ReadInput input = new ReadInput("RandomInput.txt");
		RunTest(input.points, input.visited, input.numPoints);
		//Print();		
	}
	
	public void RunTest(ArrayList<Point> points, ArrayList<Boolean> visited, int n) {
		double startTime = System.nanoTime();
	
		order.add(points.get(0));
		int i = 0;
		while(visited.contains(false) && i < n-1) { // while not all points are visited //n + 1
			
			// finding nearest point
			visited.set(points.indexOf(order.get(i)),true);//marks this point as visited
			double distance = 999999999;
			Point nearPoint = new Point();
			for(int j = 0; j < n; j++) { // n+1
				if(visited.get(j) == false) {					
					double newDistance = Point2D.distance(order.get(i).getX(), order.get(i).getY(), points.get(j).getX(), points.get(j).getY());
					if(newDistance < distance) {		
						distance = newDistance;
						nearPoint = points.get(j);
					}
				}
			}
			totalDistance += distance;	
			//end of finding nearest point					
			order.add(nearPoint);
			i++;
		} 
		totalDistance += Point2D.distance(order.get(order.size()-1).getX(), order.get(order.size()-1).getY(), order.get(0).getX(), order.get(0).getY());
	double endTime = System.nanoTime();

	duration = (endTime - startTime)/1000000;
	}
	
	public void Print() {
		for (Point x: order) {
			System.out.println(x);
			
		}
		System.out.printf("total Distance: %.5f\n", totalDistance);	
		System.out.println("miliseconds passed: " + duration);
	}
}
