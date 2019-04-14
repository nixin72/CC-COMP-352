import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class OddonacciCalculator {	
	public static void main(String[] args) {	
		System.out.println(OddonacciTail(10));
	}
	
	/**
	 * @Input: time taken, name of algorithm tested. 
	 * @Output: void 
	 * 
	 * @Purpose: 
	 * 	Write the results of my tests to a text file. Hide this background work from the 
	 * 	methods that need to be outputting to the file. 
	 * */
	public static void writeTimeToFile(long time, String name) {
		try {
			FileWriter fw = new FileWriter(name + ".txt", true);
			BufferedWriter writer = new BufferedWriter(fw);
			
			writer.write("Time to execute " + name + ": " + time + "\n");
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occured when trying to write the results. The file could not be found.");
		}
		catch (IOException e) {
			System.out.println("An IO error occured when trying to write the results.");
		}
		catch (Exception e) {
			System.out.println("An unexpected error occured when trying to write the results.");
		}
	}
	
	/**
	 * @Input: The n-th number of the sequence to calculate
	 * @Output: The n-th number of the sequence.
	 * 
	 * @Note:
	 * 	I wrote the tail-recursive method to compute the Oddonacci sequence in 
	 * 	Java before converting it to pseudo-code. This is not technically required by the assignment. 
	 * 
	 * 	To abstract away the extra parameters from the calling method, I used an inner class 
	 *  as a way to hold a method inside another method since Java doesn't supper methods 
	 *  inside methods. Assuming Java 8 this could be written using lambda functions/closures, 
	 *  but I'm sticking with inner classes since I don't know what version of Java will be 
	 *  tested with.
	 * 
	 * @Purpose: 
	 * 	Calculate the n-th number of the oddonacci sequence using a tail-recursive approach.
	 * 	If the input is less than 3, return the corresponding parameter. Otherwise, return a 
	 * 	recursive call to the method, shifting the parameters over so that the final one is 
	 * 	the next number in the sequence.
	 * */
	static int OddonacciTail(int n) {
    	class Oddonacci {
    		int Oddo(int n, int a, int b, int c) {
    			if (n == 1) 
    	            return a; 
    	        if (n == 2) 
    	            return b; 
    	        if (n == 3) 
    	            return c;
    	        return Oddo(n - 1, b, c, a + b + c); 
    		}
    	}
    	
        Oddonacci compute = new Oddonacci();
        return compute.Oddo(n, 1, 1, 1);
    }
}