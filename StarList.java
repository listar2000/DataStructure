
/**
 * @author liyx
 *
 */
public class StarList <T> {

	private int length;
	private Object [] array;
	
	/**
	 * Constructor that initiates the list with an automatic size
	 */
	private Object [] getArray() {
		return array;
	}
	
	public StarList() {
		
		array = new Object [64];
		
	}
	
	/**Consturctor that creates the an array with the given size
	 * @param size
	 * 
	 */
	public StarList(int size) {
		
		array = new Object [size];
		
	}
	
	public boolean isEmpty() {
		
		return this.length==0;
		
	}
	
	public int length() {
		
		return this.length;
		
	}
	
	public void ensureCapacity() {
		
		Object [] temp = this.array;
		this.array = new Object [(int) (temp.length*1.5)];
		
		for (int i=0; i<temp.length; i++) {
			array[i] = temp[i];
		}
	}
	
	public boolean add(int index, T data) {
		
		if (data == null) {
			return false;
		}
		
		if (index<0) {
			index = 0;
		}
		
		if (index>this.length) {
			index = this.length;
		}
		
		if (this.length==array.length) {
			ensureCapacity();
		}
		
		for (int i=this.length; i>=index; i--) {
			array[i+1] = array[i];
		}
		
		array[index] = data;
		this.length++;
		
		return true;
	}
	
	public boolean add(T data) {
		
		if (data == null) {
			return false;
		}
		
		if (this.length==array.length) {
			ensureCapacity();
		}
			
		array[this.length] = data;
		this.length++;
		
		return true;
	}
	
	public T get(int index) {
		
		if (index>=0 && index<this.length) {
			
			return (T) array[index];
			
		}
		
		return null;
		
	}
	
	public void set(int index, T data) {
		
		array[index] = data;
		
	}
	
	public Object [] toArray() {
		
		Object [] obj = new Object [this.length];
		
		for (int i=0; i<this.length; i++) {
			obj [i] = array [i];
		}
		return obj;
	}
	
	public boolean remove(int index) {
		
		if (index>this.length && index<0) {
			return false;
		}
		
		for (int i= index; i<this.length; i++) {
			array[index] = array[index+1];
		}
		
		this.length--;
		
		return true;
		
	}
	
	public boolean remove(T data) {
		
		if (!(data == null)) {
			return false;
		}
		
		for(int i=0; i<this.length;i++) {
			
			if (data.equals(array[i])) {
				remove(i);
				break;
			}
			
		}
		
		return true;
}
	
	public T takeAway(int index) {
		
		T data = (T) array[index];
		
		remove(index);
		
		return data;
	}
	
	public int indexOf(T data) {
		
		if (data==null) {
			return -1;
		}
		else {
			for(int i=0; i<this.length;i++) {
	
				if (data.equals(array[i])) {
					return i;
				}
	
			}
		}
		return -1;
	}
	
}
