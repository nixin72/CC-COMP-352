package a4_40082638_40042586;

import java.util.Random;

public class Element {
	private Integer key;
	private String value;

	public Element() {
		this.key = 0;
		this.value = "";
	};

	public Element(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Element(String value) {
		// Constructor that sets a new pair with a random Integer key
		Random rand = new Random();
		this.key = rand.nextInt(10) + 1;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
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
		
        int hash = 0 ;
        for (int i = 0; i < key; i++) {
            hash = (hash << 5) | (hash >>> 27); 
            hash += key % 10 ; 
            key = key / 10 ;
        }
        return hash ;
    }

	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + "]";
	}
	
	
	
	

}
