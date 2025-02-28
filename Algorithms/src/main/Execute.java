package main;

import main.structure.data.tree.BinaryTree;

public class Execute {
	public static void main(String[] args) {
	
		BinaryTree bn = new BinaryTree();
		bn.insert(100);
		bn.insert(90);
		bn.insert(85);
		bn.insert(92);
		bn.insert(105);
		bn.DFS();
	}
}
