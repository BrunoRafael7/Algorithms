package main.structure.data.tree;

public class NodeTree <T extends Object>{
	
	private T value;
	private NodeTree<T> right;
	private NodeTree<T> left;
	private NodeTree<T> father;
	
	public NodeTree() {
		super();
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public NodeTree<T> getRight() {
		return right;
	}
	public void setRight(NodeTree<T> right) {
		this.right = right;
	}
	public NodeTree<T> getLeft() {
		return left;
	}
	public void setLeft(NodeTree<T> left) {
		this.left = left;
	}
	public NodeTree<T> getFather() {
		return father;
	}
	public void setFather(NodeTree<T> father) {
		this.father = father;
	}
	
	
}
