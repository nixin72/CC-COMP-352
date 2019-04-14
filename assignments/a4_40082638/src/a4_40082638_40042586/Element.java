package a4_40082638_40042586;

import java.util.Random;

/*
 * Class Name: Element
 * 
 * - key : Integer
 * - value : String
 * ~ available : boolean
 * 
 * <<constructor>> + Element()
 * <<constructor>> + Element(value : String)
 * <<constructor>> + Element(element : Element)
 * <<constructor>> + Element(key : Integer, value : String)
 * 
 * + getKey() : Integer
 * + getValue() : String
 * + getAvailable() : boolean
 * + setKey(key : Integer) : void
 * + setValue(value : String) : void
 * + setAvailability(available : boolean) : void
 * + hashCode() : int
 * + equals(obj : Object) : boolean
 * + toString() : String
 * */
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
		Random rand = new Random();
		this.key = rand.nextInt(50);
		this.value = value;
		this.available = false;
	}
	
	public Element(Element element) {
		this.key = element.getKey();
		this.value = element.getValue();
		this.available = element.getAvailable();
	}

	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Public facing method to get the value of the key
	 * 
	 * Output: Integer
	 *  
	 * */
	public Integer getKey() {
		return key;
	}

	/*
	 * Input: Integer
	 * 
	 * Purpose: 
	 * 	Public facing method to set the value of the key
	 * 
	 * Output: void
	 *  
	 * */
	public void setKey(Integer key) {
		this.key = key;
	}

	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Public facing method to get the value
	 * 
	 * Output: String
	 *  
	 * */
	public String getValue() {
		return value;
	}

	/*
	 * Input: String
	 * 
	 * Purpose: 
	 * 	Public facing method to set the value
	 * 
	 * Output: void
	 *  
	 * */
	public void setValue(String value) {
		this.value = value;
	}
	
	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Public facing method to get the availability
	 * 
	 * Output: boolean
	 *  
	 * */
	public boolean getAvailable() {
		return available;
	}
	
	/*
	 * Input: boolean
	 * 
	 * Purpose: 
	 * 	Public facing method to set the value of the availability
	 * 
	 * Output: void
	 *  
	 * */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Public facing method to get the hash code of the object
	 * 
	 * Output: int
	 *  
	 * */	
	@Override
	public int hashCode() {
        return key;
    }

	/*
	 * Input: Object
	 * 
	 * Purpose: 
	 * 	Check if this object is identical to another instance of the same object.
	 * 
	 * Output: boolean
	 *  
	 * */	
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

	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Get the String representation of this object
	 * 
	 * Output: String
	 *  
	 * */
	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + ", available="+ available + "]";
	}
}