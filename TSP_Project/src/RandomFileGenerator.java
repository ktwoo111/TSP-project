import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class RandomFileGenerator {
    public static void main(String[] args) {
    	Random rand = new Random();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("RandomInput.txt"));
            Integer numPoints = rand.nextInt(9)+2;// writing from 2 to 10 points
            writer.write(numPoints.toString());
            writer.newLine();
            for(int i = 0; i < numPoints; i++){
            	writer.write(new Integer(rand.nextInt(101)+1).toString());
            	writer.write(" ");
            	writer.write(new Integer(rand.nextInt(101)+1).toString());
            	writer.newLine();
            }
            writer.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
