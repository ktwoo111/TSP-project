import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class NearestNeighbor {
	private double totalDistance;
	private ArrayList<Point> order;
	public double duration;
	

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
	}
	
	public void RunTest(ArrayList<Point> points, ArrayList<Boolean> visited, int n) {
		double startTime = System.nanoTime();
	
		order.add(points.get(0));
		int i = 0;
		visited.set(0,true);//mark first point as visited
		while(visited.contains(false) && i < n-1) { // while not all points are visited //n + 1		
			// finding nearest point
		
			double distance = 999999999;
			Point nearPoint = new Point();
			int index = 0;
			for(int j = 0; j < n; j++) { // n+1
				if(visited.get(j) == false) {					
					double newDistance = Point2D.distance(order.get(i).getX(), order.get(i).getY(), points.get(j).getX(), points.get(j).getY());
					if(newDistance <= distance) {		
						distance = newDistance;
						nearPoint = points.get(j);
						index = j;
					}
				}
			}
			totalDistance += distance;	
			//end of finding nearest point					
			order.add(nearPoint);
			visited.set(index, true);// mark this next point as visited
			i++;
		} 
		totalDistance += Point2D.distance(order.get(order.size()-1).getX(), order.get(order.size()-1).getY(), order.get(0).getX(), order.get(0).getY());
	double endTime = System.nanoTime();

	duration = (endTime - startTime)/1000000;
	}
	
	public void Print() {
		System.out.println("nearest neighbor");
		System.out.println("number of points: " + order.size());
		for (Point x: order) {
			System.out.println(x);
			
		}
		System.out.printf("total Distance: %.5f\n", totalDistance);	
		System.out.println("miliseconds passed: " + duration);
	}
}
