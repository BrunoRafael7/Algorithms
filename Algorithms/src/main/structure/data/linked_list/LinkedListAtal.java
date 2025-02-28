package main.structure.data.linked_list;

public class LinkedListAtal<T extends Object> {
	private Node<T> root;
	
	public LinkedListAtal () {
		this.root = new Node<>();
	}

	public void add(T value) {
		Node<T> newNode = new Node<>();
		newNode.setValue(value);
		if(this.root.getValue() == null) {
			this.root = newNode;
		} else {
			Node<T> n = root;
			while(n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(newNode);
			newNode.setBefore(n);
			
		}
	}

	public T get(int index) {
		if(this.root.getValue() == null) {
			return null;
		}

		Node<T> n = root;
		for (int i = 0; i < index; i++) {
			n = n.getNext();
		}
		return n.getValue();
		
	}
	
	
	
	public void set() {

		
	}
	
	@Override
	public String toString() {
		Node<T> next = root;
		String result = "[ ";
		while(next != null && next.getValue() != null) {
			result += next.getValue() + " ";
			next = next.getNext();
		}
		result += "]";
		return result;
	}
}
