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
        for (int i = 0; i<16;i++) {
        	hash = (int) (hash + ((keyval >> i) & 1) + hash*number);
        }
        return hash;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (available != other.available)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + ", available="+ available + "]";
	}
}