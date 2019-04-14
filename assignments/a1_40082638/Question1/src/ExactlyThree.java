import java.util.HashMap;

public class ExactlyThree {
	public static void main(String[] args) {
		int[] list = 
			{
				45, 24, 85, 69, 33, 1 , 54, 70, 28, 25, 
				12, 86, 52, 73, 15, 69, 7 , 89, 20, 53, 
				11, 87, 44, 4 , 1 , 96, 12, 93, 6 , 93, 
				16, 38, 47, 33, 12, 95, 32, 45, 9 , 7 , 
				70, 67, 94, 83, 62, 34, 53, 11, 85, 27, 
				65, 28, 77, 55, 83, 61, 89, 55, 82, 16, 
				43, 32, 9 , 57, 13, 14, 70, 35, 22, 91, 
				9 , 53, 8 , 97, 72, 14, 46, 5 , 48, 91, 
				88, 85, 82, 8 , 70, 95, 41, 90, 70, 25, 
				28, 88, 80, 26, 10, 33, 28, 12, 83, 30,
			};
		boolean found = Exactly3(list);
		System.out.println("Three of a kind: " + found);
	}
	
	static boolean Exactly3(int[] list) {		
		return _Exactly3(list, new HashMap<Integer, Integer>(), 0);
	}
	
	private static boolean _Exactly3(int[] list, HashMap<Integer, Integer> pairs, int curr) {
		if (curr == list.length) {
			return pairs.values().contains(3);
		}		
		
		if (!pairs.containsKey(list[curr])) {
			pairs.put(list[curr], 1);
		}
		else {
			int occurences = pairs.get(list[curr]);
			pairs.replace(list[curr], ++occurences);
		}
		
		return _Exactly3(list, pairs, ++curr);
	}
}