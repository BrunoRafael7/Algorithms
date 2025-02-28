package main.strategies.binaryTree;

import main.game.map.Point;
import main.game.map.TreasureChest;

public class NodeTree <T extends Object>{
	
	private T value;
	private int i;
	private int j;
	
	private NodeTree<T> treasure;

	private NodeTree<T> right;
	private NodeTree<T> left;
	
	public NodeTree() {}
	public NodeTree(T value, int i, int j) {
		super();
		this.value = value;
		this.setI(i);
		this.setJ(j);
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
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public boolean isNILL() {
		return this.getValue() == null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof String) {
			String value = (String) obj;
			return this.getValue().equals(value);
		}
		NodeTree<T> node = (NodeTree) obj;
		return this.getI() == node.getI() && this.getJ() == node.getJ();
	}
	public NodeTree<T> getTreasure() {
		return treasure;
	}
	public void setTreasure(NodeTree<T> treasure) {
		this.treasure = treasure;
	}
	
	public void setTreasure(Point treasure) {
		this.treasure = new NodeTree<T>();
		this.treasure.setI(treasure.getPositionX());
		this.treasure.setJ(treasure.getPositionY());
	}
}
