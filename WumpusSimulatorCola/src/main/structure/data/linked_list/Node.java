package main.structure.data.linked_list;

public class Node <T extends Object>{
	private T value;
	private Node<T> next;
	private Node<T> before;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getBefore() {
		return before;
	}

	public void setBefore(Node<T> before) {
		this.before = before;
	}
}
