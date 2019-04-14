public class Quesiton1 {

	public static void main(String[] args) {
		int[] A = {22, 61,-10, 21, 0, 9, 50, 17, 35, 81,-46, 19, 5, 77};
		multiplesOfX(A, 5);
	}
	
	public static void multiplesOfX(int[] A, int x) {
		for (int n = 0 ; n < A.length ; n++) {
			if (A[n] % x == 0 && A[n] != 0) {
				System.out.println("A at index " + n + " is: " + A[n]);
			}
		}
	}
}
