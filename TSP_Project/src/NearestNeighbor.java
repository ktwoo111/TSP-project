import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NearestNeighbor {
	public ReadInput input;
	public double totalDistance;
	public ArrayList<Point> order;
	
	public static void main(String[] args) {		
		NearestNeighbor hi = new NearestNeighbor();
		hi.RunTest();
	}
	
	NearestNeighbor(){
		input = new ReadInput("Inputs.txt");
		totalDistance = 0.0;
		order = new ArrayList<Point>();
	}

	public void RunTest() {
		order.add(input.points.get(0));
		int i = 0;
		while(input.visited.contains(false) && i < input.numPoints-1) { // while not all points are visited
			order.add(FindNearestPoint(order.get(i)));
			i++;
		} 
		totalDistance += Point2D.distance(order.get(order.size()-1).getX(), order.get(order.size()-1).getY(), order.get(0).getX(), order.get(0).getY());
		Print();
	}
	
	
	public Point FindNearestPoint(Point p) {
		input.visited.set(input.points.indexOf(p),true);//marks this point as visited
		double distance = 999999999;
		Point nearPoint = new Point();
		for(int i = 0; i < input.points.size(); i++) {
			if(input.visited.get(i) == false) {					
				double newDistance = Point2D.distance(p.getX(), p.getY(), input.points.get(i).getX(), input.points.get(i).getY());
				if(newDistance < distance) {		
					distance = newDistance;
					nearPoint = input.points.get(i);
				}
			}
		}
		totalDistance += distance;
		return nearPoint;
	}
	
	public void Print() {
		for (Point x: order) {
			System.out.println(x);
			
		}
		System.out.printf("total Distance: %.0f\n", totalDistance);		
	}

}
