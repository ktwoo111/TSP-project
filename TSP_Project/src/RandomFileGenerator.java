import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class RandomFileGenerator {
	public int numPoints;
    public RandomFileGenerator() {
    	numPoints = 0;
    }
    
    public void setN(int n){
    	
    	numPoints = n;
    }
    public void Generate(){
    	Random rand = new Random();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("RandomInput.txt"));
            writer.write(new Integer(numPoints).toString());
            writer.newLine();
            for(int i = 0; i < numPoints; i++){
            	writer.write(new Integer(rand.nextInt(501)+1).toString());
            	writer.write(" ");
            	writer.write(new Integer(rand.nextInt(501)+1).toString());
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
