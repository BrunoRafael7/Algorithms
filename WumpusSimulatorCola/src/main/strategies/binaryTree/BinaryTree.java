package main.strategies.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.game.map.GameMap;
import main.game.map.MapOfTreasure;
import main.game.map.Monster;
import main.game.map.Point;
import main.game.map.Rock;
import main.strategies.Strategy;

public class BinaryTree implements Strategy {
	
	private NodeTree<String> root;
	private List<NodeTree<String>> sequenceSelected;
	private GameMap gameMap;

	public BinaryTree(GameMap map) {
		map.print();
		System.out.println("");
		this.gameMap = map;
		this.root = new NodeTree<>();
		this.sequenceSelected = new LinkedList<>();
		
		buildTreeAndCalculatePath(map, 0, 0);
	}

	public void insert(String value) {
		if(this.root.getValue() == null) {
			this.root.setValue(value);
		} else {
			insertInTree(value, this.root);
		}
	}

	public void insertInTree (String value, NodeTree<String> node) {		
		if(node.getValue().equals(value)) {
			if(node.getLeft() == null) {
				NodeTree<String> newNode = new NodeTree<String>();
				newNode.setValue(value);
				node.setLeft(newNode);

			} else {
				insertInTree(value, node.getLeft());
			}
		} else {
			if(node.getRight() == null) {
				NodeTree<String> newNode = new NodeTree<String>();
				newNode.setValue(value);
				node.setRight(newNode);
			} else {
				insertInTree(value, node.getRight());
			}
		}
		
	}
	
	
	public boolean findBFS (String value) {
		if (this.root == null) {
			System.out.println("Árvore Vazia");
			return false;
		}
		Queue<NodeTree<String>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			NodeTree<String> nextNode = queue.poll();
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

	
	public void buildTreeAndCalculatePath (GameMap map, int i, int j) {
		this.root = buildTreeAndCalculatePath(map.getScenario(), 0, 0);
		this.DFS(this.root);
		
	}
	
	public void DFS (NodeTree<String> node) {
		LinkedList<NodeTree<String>> path = new LinkedList<>();
		preOrder(node, MapOfTreasure.CHARACTER, path);
		if(path.size() > 0) {
			NodeTree<String> mapOfTreasure = path.get(path.size() - 1);
			path = new LinkedList<>();
			preOrder(node, mapOfTreasure.getTreasure(), path);
			this.sequenceSelected = path;
			this.sequenceSelected.removeFirst();			
		} else {
			System.out.println("É impossível acessar o mapa do tesouro");
			/*
			 * preOrder(node, TreasureChest.CHARACTER, path);
			if(path.size() > 0) {
				this.sequenceSelected = path;
				this.sequenceSelected.removeFirst();				
			}
			 */
		}
	}
	
	public boolean preOrder(NodeTree<String> node, Object value, LinkedList<NodeTree<String>> path) {
		//O problema era a árvore sendo gerada errada pois estava com * depois do map.print() ao invés de null
		if (node == null) {
			return false;
		}
		
		path.add(node);
		if(node.equals(value)) {
			return true;
		}
		
		if (preOrder(node.getLeft(), value, path) || preOrder(node.getRight(), value, path)) {
			return true;
		}
		
		path.remove(path.size() - 1);
		return false;
	}
	
	public NodeTree<String> buildTreeAndCalculatePath (String [][] map, int i, int j) {
		if(i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
			return null;
		}
		
		if(!map[i][j].equals(Rock.CHARACTER) && !map[i][j].equals(Monster.CHARACTER)) {
			NodeTree<String> newNode = new NodeTree<>(map[i][j], i, j);			
			if(map[i][j].equals(MapOfTreasure.CHARACTER)) {
				newNode.setTreasure(this.gameMap.getTresureLocalization());
			}
			newNode.setLeft(buildTreeAndCalculatePath(map, i + 1, j));
			newNode.setRight(buildTreeAndCalculatePath(map, i, j + 1));
			return newNode;
		}
		return null;
	}

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, GameMap map) {
		if(!sequenceSelected.isEmpty()) {
			NodeTree<String> nextPoint = sequenceSelected.removeFirst();
			if(nextPoint != null) {
				if(!nextPoint.isNILL()) {
					return new Point(nextPoint.getI(), nextPoint.getJ());
				}
			}
		}
		return null;
	}
}
