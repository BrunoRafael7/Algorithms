package main.game.map.rollback;

public class RollbackNode <T extends Object>{
	private T value;
	private RollbackNode<T> next;
	private RollbackNode<T> before;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public RollbackNode<T> getNext() {
		return next;
	}

	public void setNext(RollbackNode<T> next) {
		this.next = next;
	}

	public RollbackNode<T> getBefore() {
		return before;
	}

	public void setBefore(RollbackNode<T> before) {
		this.before = before;
	}
}
