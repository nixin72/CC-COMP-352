package a4_40082638_40042586;

import java.util.Random;

public class Element {
	private Integer key;
	private String value;
	boolean available;

	public Element() {
		this.key = 0;
		this.value = "";
		this.available = false;
	};

	public Element(Integer key, String value) {
		this.key = key;
		this.value = value;
		this.available = false;
	}

	public Element(String value) {
		// Constructor that sets a new pair with a random Integer key
		Random rand = new Random();
		this.key = rand.nextInt(100) + 1;
		this.value = value;
		this.available = false;
	}
	
	public Element(Element element) {
		this.key = element.getKey();
		this.value = element.getValue();
		this.available = element.getAvailable();
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
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
        int hash = 0;
        int keyval = key;
        int number = 33;
        for(int i = 0; i<16;i++) {
        hash =     (int) (hash + ((keyval >> i) & 1) + hash*number);
        }
        return hash;
    }

	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + ", available="+ available + "]";
	}
}