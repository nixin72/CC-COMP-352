public class MultiRecursiveOddonacci {
	public static void main(String[] args) {
		TestMultiRecursive();
	}
	
	/** 
	 * @Input: 
	 * @Output: void
	 * 
	 * @Purpose: 
	 * 	Test the performance of the MultiRecursiveOddonacci method. 
	 * 	It will loop from 5 to 100 and test the algorithm with every multiple of 5.
	 * 	It will output the total time taken to a text file. 
	 * */
	public static void TestMultiRecursive() {
		long start = System.nanoTime();
		
		for (int n = 5 ; n <= 100 ; n+= 5) {
			multiRecursiveOddonacci(n);
		}
		
		long end = System.nanoTime();
		
		OddonacciCalculator.writeTimeToFile(end - start, "Multi");
	}

	/**
	 * @Input: The n-th number of the sequence to calculate
	 * @Output: the n-th number of the sequence. 
	 * 
	 * @Purpose:
	 * 	Calculate the n-th number of the oddonacci sequence using a multi-recursive approach. 
	 * 	If the input is less than 4, it will return 1 - being the first 3 numbers in the sequence. 
	 * 	If the input is greater than 3, it will make 3 recursive calls with decremented values 
	 * 	to calculate the current value, and then return the output of the 3 recursive calls.  
	 */
	public static int multiRecursiveOddonacci(int n) {
		if (n <= 3) {
			return 1;
		}
		return multiRecursiveOddonacci(n-3) + 
			multiRecursiveOddonacci(n-2) + 
			multiRecursiveOddonacci(n-1);   
	}
	
}
