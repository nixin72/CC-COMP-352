package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import part2.MyArrayList;
import part2.MyLinkedList;

public class ListTester {

	private static enum POSITION {
		//Beginning, End, Random, Value
		S, E, R, V
	}
	
	static HashMap<String, Long> data = new HashMap<>();
	
	public static void main(String[] args) {
		removeFileContents();		
				
		for (int size = 10 ; size <= 100000 ; size *= 10) {			
			System.out.println(size);
			data.put("N", (long)size);
			
			MyArrayList<Integer> myArrayList = test_Add_MyArrayList(size, POSITION.S);
			ArrayList<Integer> arrayList = test_Add_ArrayList(size, POSITION.S);
			MyLinkedList<Integer> myLinkedList = test_Add_MyLinkedList(size, POSITION.S);
			LinkedList<Integer> linkedList = test_Add_LinkedList(size, POSITION.S);
			
			test_Add_MyArrayList(size, POSITION.E);
			test_Add_ArrayList(size, POSITION.E);
			test_Add_MyLinkedList(size, POSITION.E);
			test_Add_LinkedList(size, POSITION.E);
			
			test_Add_MyArrayList(size, POSITION.R);
			test_Add_ArrayList(size, POSITION.R);
			test_Add_MyLinkedList(size, POSITION.R);
			test_Add_LinkedList(size, POSITION.R);
			
			test_Remove_MyArrayList(myArrayList, POSITION.S);
			test_Remove_ArrayList(arrayList, POSITION.S);
			test_Remove_MyLinkedList(myLinkedList, POSITION.S);
			test_Remove_LinkedList(linkedList, POSITION.S);
			
			test_Remove_MyArrayList(myArrayList, POSITION.E);
			test_Remove_ArrayList(arrayList, POSITION.E);
			test_Remove_MyLinkedList(myLinkedList, POSITION.E);
			test_Remove_LinkedList(linkedList, POSITION.E);
			
			test_Remove_MyArrayList(myArrayList, POSITION.R);
			test_Remove_ArrayList(arrayList, POSITION.R);
			test_Remove_MyLinkedList(myLinkedList, POSITION.R);
			test_Remove_LinkedList(linkedList, POSITION.R);
			
			test_Remove_MyArrayList(myArrayList, POSITION.V);
			test_Remove_ArrayList(arrayList, POSITION.V);
			test_Remove_MyLinkedList(myLinkedList, POSITION.V);
			test_Remove_LinkedList(linkedList, POSITION.V);	
			
			writeToFile(data);
			data = new HashMap<>();
		}
	}

	private static MyArrayList<Integer> test_Add_MyArrayList(int size, POSITION p) {
		long start = System.nanoTime();

		MyArrayList<Integer> ml = new MyArrayList<Integer>(size);

		for (int q = 0 ; q < size ; q++) {
			Integer val = new Integer(random(0,size*2));
			int index = random(0, q);
			switch(p) {
				case S: ml.add(0, val); 
					break;
				case E: ml.add(val);
					break;
				case R: ml.add(index, val);
					break;
				default: {}
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("is_mal", timeTaken);
				break;
			case E: data.put("ie_mal", timeTaken);
				break;
			case R: data.put("ir_mal", timeTaken);
				break;
		default:
			break;
		}
		
		return ml;
	}
	
	private static ArrayList<Integer> test_Add_ArrayList(int size, POSITION p) {
		long start = System.nanoTime();

		ArrayList<Integer> ml = new ArrayList<Integer>(size);

		for (int q = 0 ; q < size ; q++) {
			Integer val = new Integer(random(0,size*2));
			int index = random(0, q);
			switch(p) {
				case S: ml.add(0, val);
					break;
				case E: ml.add(val);
					break;
				case R: ml.add(index, val);
					break;
				default: {}
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("is_al", timeTaken);
				break;
			case E: data.put("ie_al", timeTaken);
				break;
			case R: data.put("ir_al", timeTaken);
				break;
		default:
			break;
		}
		
		return ml;
	}
	
	private static MyLinkedList<Integer> test_Add_MyLinkedList(int size, POSITION p) {
		long start = System.nanoTime();

		MyLinkedList<Integer> ml = new MyLinkedList<Integer>();

		for (int q = 0 ; q < size ; q++) {
			Integer val = new Integer(random(0,size*2));
			int index = random(0, q);
			switch(p) {
				case S: ml.add(0, val);
					break;
				case E: ml.add(val);
					break;
				case R: ml.add(index, val);
					break;
				default: {}
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("is_mll", timeTaken);
				break;
			case E: data.put("ie_mll", timeTaken);
				break;
			case R: data.put("ir_mll", timeTaken);
				break;
		default:
			break;
		}
		
		return ml;
	}
	
	private static LinkedList<Integer>  test_Add_LinkedList(int size, POSITION p) {
		long start = System.nanoTime();

		LinkedList<Integer> ml = new LinkedList<Integer>();

		for (int q = 0 ; q < size ; q++) {
			Integer val = new Integer(random(0,size*2));
			int index = random(0, q);
			switch(p) {
				case S: ml.add(0, val);
					break;
				case E: ml.add(val);
					break;
				case R: ml.add(index, val);
					break;
				default: {}
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("is_ll", timeTaken);
				break;
			case E: data.put("ie_ll", timeTaken);
				break;
			case R: data.put("ir_ll", timeTaken);
				break;
		default:
			break;
		}
		
		return ml;
	}

	/*
	 * @Input: The list to remove all elements from, and the position to remove the elements at. 
	 * 
	 * */
	public static void test_Remove_MyArrayList(MyArrayList<Integer> list, POSITION p) {
		long start = System.nanoTime();
		
		for ( ; list.size() >= 0 ;) {
			Integer val = new Integer(random(0, list.size()));
			int index = random(0, list.size());
			switch(p) {
				case S: list.remove(0);
					break;
				case E: list.remove(list.size());
					break;
				case R: list.remove(index);
					break;
				case V: list.remove((Object) val);
					break;
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("rs_mal", timeTaken);
				break;
			case E: data.put("re_mal", timeTaken);
				break;
			case R: data.put("rr_mal", timeTaken);
				break;
			case V: data.put("rv_mal", timeTaken);
				break;
		default: 
			break;
		}
	}
	
	public static void test_Remove_ArrayList(ArrayList<Integer> list, POSITION p) {
		long start = System.nanoTime();

		for (; list.size() > 0 ;) {
			Integer val = new Integer(random(0, list.size()));
			int index = random(0, list.size());
			switch(p) {
				case S: list.remove(0);
					break;
				case E: list.remove(list.size()-1);
					break;
				case R: list.remove(index);
					break;
				case V: list.remove(val);
					break;
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;
		
		switch(p) {
			case S: data.put("rs_al", timeTaken);
				break;
			case E: data.put("re_al", timeTaken);
				break;
			case R: data.put("rr_al", timeTaken);
				break;
			case V: data.put("rv_al", timeTaken);
				break;
		default:
			break;
		}
	}
	
	public static void test_Remove_MyLinkedList(MyLinkedList<Integer> list, POSITION p) {
		long start = System.nanoTime();

		for ( ; list.size() >= 0 ;) {
			Integer val = new Integer(random(0, list.size()));
			int index = random(0, list.size());
			switch(p) {
				case S: list.remove(0);
					break;
				case E: list.remove(list.size()-1);
					break;
				case R: list.remove(index);
					break;
				case V: list.remove(val);
					break;
			}
		}

		long end = System.nanoTime();
		long timeTaken = end - start;
		
		switch(p) {
			case S: data.put("rs_mll", timeTaken);
				break;
			case E: data.put("re_mll", timeTaken);
				break;
			case R: data.put("rr_mll", timeTaken);
				break;
			case V: data.put("rv_mll", timeTaken);
				break;
		default:
			break;
		}
	}
	
	public static void test_Remove_LinkedList(LinkedList<Integer> list, POSITION p) {
		long start = System.nanoTime();

		for ( ; list.size() > 0 ;) {
			Integer val = new Integer(random(0, list.size()));
			int index = random(0, list.size());
			switch(p) {
				case S: list.remove(0);
					break;
				case E: list.remove(list.size()-1);
					break;
				case R: list.remove(index);
					break;
				case V: list.remove(val);
					break;
			}
		}
		
		long end = System.nanoTime();
		long timeTaken = end - start;

		switch(p) {
			case S: data.put("rs_ll", timeTaken);
				break;
			case E: data.put("re_ll", timeTaken);
				break;
			case R: data.put("rr_ll", timeTaken);
				break;
			case V: data.put("rv_ll", timeTaken);
				break;
		default:
			break;
		}
	}

	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	
	public static void removeFileContents() {
		try {
			File outputFile = new File("testRun.txt");
			FileWriter writer = new FileWriter(outputFile);
			
			writer.write("");			
			writer.close();
		}
		catch (IOException e) {
			System.out.println("The output file could not be found.");
		}
	}
	
	public static void writeToFile(HashMap<String, Long> data) {
		try {
			File outputFile = new File("testRun.md");
			FileWriter writer = new FileWriter(outputFile, true);

			@SuppressWarnings("resource")
			String content = new Scanner(new File("template.txt")).useDelimiter("\\Z").next();
				
			for (String key : data.keySet()) {
				long val = data.get(key);
								
				content = content.replace("{{" + key + "}}", String.valueOf(val));
			}
						
			writer.append(content + "\n");
			writer.close();
		}
		catch (FileNotFoundException e) {
			
		}
		catch (Exception e) {
			
		}
	}
}
