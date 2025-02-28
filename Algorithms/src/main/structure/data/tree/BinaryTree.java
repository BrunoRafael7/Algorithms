package main.structure.data.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private NodeTree<Integer> root;

	public BinaryTree() {
		this.root = new NodeTree<>();
	}
	
	public void insert(Integer value) {
		if(this.root.getValue() == null) {
			this.root.setValue(value);
		} else {
			insertInTree(value, this.root);
		}
	}

	public void insertInTree (Integer value, NodeTree<Integer> node) {		
		if(value < node.getValue()) {
			if(node.getLeft() == null) {
				NodeTree<Integer> newNode = new NodeTree<Integer>();
				newNode.setValue(value);
				node.setLeft(newNode);
				newNode.setFather(node);
			} else {
				insertInTree(value, node.getLeft());
			}
		} else {
			if(node.getRight() == null) {
				NodeTree<Integer> newNode = new NodeTree<Integer>();
				newNode.setValue(value);
				node.setRight(newNode);
				newNode.setFather(node);
			} else {
				insertInTree(value, node.getRight());
			}
		}
		
	}
	
	
	public boolean findBFS (Integer value) {
		if (this.root == null) {
			System.out.println("Árvore Vazia");
			return false;
		}
		Queue<NodeTree<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			NodeTree<Integer> nextNode = queue.poll();
			if(nextNode.getValue().equals(value)) {
				return true;
			}
			if(nextNode.getLeft() != null) {
				queue.add(nextNode.getLeft());
			}
			if(nextNode.getRight() != null) {
				queue.add(nextNode.getRight());
			}
		}
		return false;
	}

	public void DFS () {
		posOrder(this.root);
	}
	
	public void preOrder(NodeTree<Integer> node) {
		if(node != null && node.getValue() != null) {
			System.out.print(node.getValue() + "->");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public void inOrder(NodeTree<Integer> node) {
		if(node != null && node.getValue() != null) {
			inOrder(node.getLeft());
			System.out.print(node.getValue() + "->");
			inOrder(node.getRight());
		}
	}
	
	public void posOrder(NodeTree<Integer> node) {
		if(node != null && node.getValue() != null) {
			posOrder(node.getLeft());
			posOrder(node.getRight());
			System.out.print(node.getValue() + "->");
		}
	}
	
	/*
    public static TreeNode buildTree(String[][] arr, int i, int j) {

        if (i < 0 || i >= arr.length || j < 0 || j > >= arr[0].lenght) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);

        node.left = buildTree(arr, 2 * index + 1); // Índice do filho esquerdo
        node.right = buildTree(arr, 2 * index + 2); // Índice do filho direito

        return node;
    }*/


}
