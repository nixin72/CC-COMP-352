public class LinearRecursiveOddonacci {
	public static void main(String[] args) {
		long n = linearRecursiveOddonacci(10)[0];
		System.out.println(n);
	}
	

	/**
	 * @Input: 
	 * @Output: void 
	 * 
	 * @Purpose: 
	 * 	Test the performance of the LinearOddonacci method. 
	 * 	It will loop from 5 to 100 and test the algorithm with every multiple of 5.
	 * 	It will output the total time taken to a text file.  
	 */
	public static void TestLinear() {
		long start = System.nanoTime();
		
		for (int n = 5 ; n <= 100 ; n+=5) {
			linearRecursiveOddonacci(n);
		}
		
		long end = System.nanoTime();
		
		OddonacciCalculator.writeTimeToFile(end - start, "Linear");
	}

	
	/**
	 * @Input: The n-th number of the sequence to calculate
	 * @Output: The n-th number of the sequence.
	 * 
	 * @Purpose:
	 * 	Calculate the n-th number of the oddonacci sequence using a linear-recursive approach.
	 * 	If the input is less than 3, it will return an array of the first 3 numbers of the sequence. 
	 * 	If the input is greater, it will shift the values in the array over by 1, pushing out the 
	 * 	first and setting the third value to be the next number in the sequence, computed by the 
	 * 	previous 3 before the array was shifted over. 
	 */
	public static long[] linearRecursiveOddonacci(int n) {
		if (n <= 3) {
			long[] answer = {1, 1, 1};
			return answer;
		} else {
			long[] temp = linearRecursiveOddonacci(n-1);
			long[] answer = {temp[0] + temp[1] + temp[2], temp[0], temp[1]};
			return answer;
		}
	}
	
}
