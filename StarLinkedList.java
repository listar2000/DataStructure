

/*
 * Imitate the LinkedList Class from Java.util and create a single-direction linkedlist.
 */ 
interface requestedFunction <T> {
	
	public boolean add(int index, T data);
	public boolean isEmpty();
	public int length();
	public T remove(int index);
	public void set(int index, T data);
	public T get(int index);
	public int indexOf(T data);
	
}
public class StarLinkedList <T> implements requestedFunction <T>{
	
	protected Node <T> head;
	protected Node <T> rear;
	
	public static void main(String[] args) {
		StarLinkedList<Integer> tt = new StarLinkedList<Integer>();
		tt.add(0, 4);
		tt.add(1, 8);
		tt.add(6);
		tt.add(8);
	}
	
	public StarLinkedList() {
		this.head = this.rear = new Node<T>(null);
	}
	
	public boolean add(T data) {
		
		if (data != null) {
			this.rear.next = new Node<T>(data);
			this.rear = this.rear.next;
		}
		
		return true;
	}

	@Override
	public boolean add(int index, T data) {
		
		if (data==null){
	        throw new NullPointerException("data can\'t be empty!");
	    }

	    if(index<0)
	        throw new NullPointerException("index can\'t less than 0");
		int j=0;
		Node<T>pre = this.head;
		
		while (pre.next!=null && j<index) {
			j++;
			pre=pre.next;
		}
		
		Node<T> q = new Node<T>(data, pre.next);
		pre.next = q;
		
		if (pre==this.rear) {
			this.rear = q;
		}
		return true;
	
	}

	@Override
	public boolean isEmpty() {
		return this.head.next==null;
	}

	@Override
	public int length() {
		
		int length = 0;
		Node<T>currentLength = this.head.next;
		while (currentLength != null) {
			length++;
			currentLength = currentLength.next;
		}
		
		return length;
	}

	@Override
	public T remove(int index) {
		T old = null;
		
		if (index>=0 && index<this.length()) {
			
			int j=0;
			Node<T>pre = this.head;
			
			while (pre!=null && j<index) {
				pre = pre.next;
			}
			
			Node<T> r = pre.next;
			
			if (r != null) {
				old = r.data;
				
				if (r==this.rear) {
					this.rear = pre;
				}
				pre.next = r.next;
			}
			return old;
		}
		
		return null;
		
	}

	@Override
	public void set(int index, T data) {
		if (index>=0 && index<this.length()) {
			int j=0;
			Node<T>pre = this.head;
			
			while (pre!=null && j<index) {
				pre = pre.next;
			}
			
			if (pre!=null) {
				pre.next.data = data;
			}
			
		}
	}

	@Override
	public T get(int index) {
		
		if (index>=0 && index<this.length()) {
			int j=0;
			Node<T>pre = this.head.next;
			
			while(j<index && pre!=null) {
				pre = pre.next;
				j++;
			}
			
			if (pre != null) {
				return pre.data;
			}
		}
		
		return null;
		
	}

	@Override
	public int indexOf(T data) {
		
		int j =0;
		while (j<length()) {
			if (data.equals(this.get(j))) return j;
			j++;
		}
		return -1;
		
	}

}

//Accomplish a single unit for storing data called Node
class Node<T>{
	
	public T data;
	public Node <T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node(T data, Node<T>next){
		this.data = data;
		this.next = next;
	}
}
	
