package a4_40082638_40042586;

import java.util.Random;

public class Element {
	private int key;
	private String value;

	public Element() {
		this.key = 0;
		this.value = "";
	};

	public Element(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public Element(String value) {
		// Constructor that sets a new pair with a random Integer key
		Random rand = new Random();
		this.key = rand.nextInt(10) + 1;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		//returns the HashCode using polynomial accumulation
		final int prime = 31;
		int result = 0;
		for (int i = 0; i < value.length(); i++) {
			result = prime * result + value.charAt(i);}
		return result;
	}
	

}
