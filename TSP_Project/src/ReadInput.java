import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInput {
	public String filePath;
	public ArrayList<Point> points;
	public ArrayList<Boolean> visited;
	public int numPoints;
	
	/*
	public static void main(String[] args) {
		ReadInput hello = new ReadInput("C:\\Users\\dkdld\\Desktop\\Algorithm\\Inputs.txt");
		hello.Print();
		
	}
	*/
	
	public ReadInput(String filePath) {
		super();
		numPoints = 0;
		points = new ArrayList<Point>();
		visited = new ArrayList<Boolean>();
		ReadFile(filePath);

	}
	public void ReadFile(String filePath) {
		try {
			Scanner s = new Scanner(new FileReader(filePath));
			numPoints = s.nextInt();
			while(s.hasNext()) {
				int x = s.nextInt();
				int y = s.nextInt();
				Point newPoint = new Point(x,y);
				points.add(newPoint);
				visited.add(false);
			}
			s.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Print() {
		for(Point x: points){
			System.out.println(x);
		}
		
	}

}
