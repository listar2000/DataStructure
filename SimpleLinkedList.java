package BasicJavaElementLearning;

public class SimpleLinkedList<T> {
	
	private Node<T> headNode;
	private int length = 0;
	
	public SimpleLinkedList (Node<T> head) {
		this.headNode = head;
	}
	
	public boolean isEmpty() {
		return this.headNode == null;
	}
	
	public int length() {
		return this.length;
	}
	
	public T get(int index) {
		
		int count = 0;
		Node<T> p = headNode;
		
		if (p != null && index >= 0 && index < this.length) {
			while (count < index) {
				p = p.next;
				count ++;
			}
			return p.data;
		}
		
		return null;
	}
	
	/**
	 * 	
	 * @param data -- new value
	 * @param index -- position
	 * @return T -- old value
	 */
	public T set(int index, T data) {
		if (data != null && index >= 0 && index < this.length) {
			int count = 0;
			Node<T> p = headNode;
			while (count < index) {
				p = p.next;
				count ++;
			}
			T old = p.data;
			p.data = data;
			return old;
		}
		return null;
	}
	
	public boolean add(int index, T data) {
		if (data != null && index >= 0) 
		{
			if (headNode == null || index == 0) {
				this.headNode = new Node<T> (data, headNode);
			}
			else {
				int count = 0;
				Node<T> pre = headNode;
				while (pre.next != null && count < index - 1) {
					pre = pre.next;
					count ++;
				}
				pre.next = new Node<T>(data, pre.next);
			}
			this.length ++;
			return true;
		}
		return false;
	}
	
	public boolean add(T data) {
		return add(this.length, data);
	}
	
	public T remove(int index) {
		if (index >= 0 && index < this.length) {
			T old = null;
			if (index == 0) {
				old = headNode.data;
				this.headNode = this.headNode.next;
			}
			else {
				int count = 0;
				Node<T> pre = headNode;
				while (count < index - 1) {
					pre = pre.next;
					count ++;
				}
				old = pre.next.data;
				pre.next = pre.next.next;
			}
			this.length --;
			return old;
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>(null);
		list.add(5);
		list.add(7);
		System.out.println(list.get(1));
		list.set(0, 8);
		list.add(1, 4);
		list.add(12);
		list.remove(0);
		for (int i = 0; i < list.length(); i++) {
			System.out.println("Êý¾ÝÊä³ö£º " + list.get(i));
		}
	}

}

class Node<T> 
{
	public T data;
	public Node<T> next;
	
	public Node (T data) {
		this.data = data;
	}
	
	public Node (T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}
