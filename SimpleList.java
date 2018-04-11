package BasicJavaElementLearning;

import java.util.Iterator;

public class SimpleList <T> implements Iterable<T>{
	
	//定义无参创建时的初始数组容量和一个Object数组
	private final int INITIAL_CAPACITY = 64;
	private final double ENLARGE_INDEX = 1.5;
	private Object[] array;
	private int size;

	//无参constructor
	public SimpleList() {
		array = new Object[INITIAL_CAPACITY];
	}
	
	public SimpleList(int capacity) {
		//判定参数
		if (capacity <= 0) 
			throw new IllegalArgumentException(capacity+" is not a valid number");
		array = new Object[capacity];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.array.length == 0;
	}
	
	public void ensureCapacity() {
		Object[] old = array;
		array = new Object[(int) (old.length*ENLARGE_INDEX)];
		for (int i = 0; i < old.length; i++) {
			array[i] = old[i];
		}
	}
	
	public boolean add(int index, T data) {
		if (index < 0 || index >= this.size || data == null) return false;
		if (this.size == array.length) ensureCapacity();
		for (int i = this.size-1; i >= index; i--) {
			array[i+1] = array[i];
		}
		array[index] = data;
		this.size++;
		return true;
	}
	//List的尾部插入数据，效率最高
	public boolean add(T data) {
		if (data == null) return false;
		if (this.size == array.length) ensureCapacity();
		array[this.size] = data;
		this.size++;
		return true;
	}
	
	public T remove(int index) {
		if (index < 0 || index >= this.size) return null;
		@SuppressWarnings("unchecked")
		T data = (T) array[index];
		for (int i = index; i < this.size-1; i++) {
			array[i] = array[i+1];
		}
		this.size--;
		return data;
	}
	
	public boolean remove(T data) {
		if (data == null) return false;
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(data)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void set(int index, T data) {
		if (index < 0 || index>=this.size)
			throw new IndexOutOfBoundsException();
		array[index] = data;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index < 0 || index>=this.size)
			return null;
		return (T) array[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
		
	}
	
	private class Itr implements Iterator<T> 
	{
		int cursor;
		int lastRet = -1;
		
		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public T next() {
			int i = cursor;
			Object[] elements = array;
			cursor = i+1;
			return (T) elements[lastRet = i];
		}
		
		public void remove() {
			if (lastRet == -1)
				throw new IllegalStateException();
			SimpleList.this.remove(lastRet);
			cursor = lastRet;
			lastRet = -1;
		}
	}
	
	public static void main(String[] args) {
		throw new StackOverflowError("stack is overflowing!");
		
		
	}

		
	

}
