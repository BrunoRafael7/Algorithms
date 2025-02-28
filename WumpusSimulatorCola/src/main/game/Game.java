package main.game;

import main.game.map.GameMap;
import main.game.map.Point;
import main.game.map.TreasureChest;
import main.strategies.binaryTree.BinaryTree;

public class Game {
	private GameMap map;
	private Player player;
	public Game() {
		this.map = new GameMap(8, 8);
		this.player = new Player(new BinaryTree(this.map));
	}
	
	public void run() {
		this.map.print();
		System.out.println();
		while(true) {
			Point nextPoint = this.player.evaluatePossbileNextStep(map);
			if (nextPoint == null) {
				break;
			} else {
				String space = this.map.get(nextPoint);
				if (space != null && space.equals(TreasureChest.CHARACTER)) {
					this.map.openTreasureChest(nextPoint);
					this.map.print();
					break;
				} else {
					this.map.moveRobot(nextPoint);					
				}
			}
			this.map.print();
			System.out.println();
		}
	}

}
