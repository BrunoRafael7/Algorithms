package main.game.map.rollback;

public class RollbackLinkedList<T extends Object> {
	private RollbackNode<T> root;
	
	public RollbackLinkedList () {
		this.root = new RollbackNode<>();
	}

	public void add(T value) {
		RollbackNode<T> newNode = new RollbackNode<>();
		newNode.setValue(value);
		if(this.root.getValue() == null) {
			this.root = newNode;
		} else {
			RollbackNode<T> n = root;
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

		RollbackNode<T> n = root;
		for (int i = 0; i < index; i++) {
			n = n.getNext();
		}
		return n.getValue();
		
	}
	
	
	
	public void set() {

		
	}
	
	@Override
	public String toString() {
		RollbackNode<T> next = root;
		String result = "[ ";
		while(next != null && next.getValue() != null) {
			result += next.getValue() + " ";
			next = next.getNext();
		}
		result += "]";
		return result;
	}
}
