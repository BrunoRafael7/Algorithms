package main.strategies;

import java.util.ArrayList;
import java.util.List;

import main.game.map.Map;
import main.game.map.Point;

public class FewerObstacles implements Strategy{

	/**
	 * N is the next location 
	 * p1 p2 p3
	 * p4 N p5
	 * p6 p7 p8
	 */

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, Map map) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<Point> evaluatePoints(List<Point> possibleNextSteps, Map map) {
		
		/*for (int i = 0; i < possibleNextSteps.size(); i++) {
			List<Point> evaluatePoints = new ArrayList<Point>();
			evaluatePoints.add(new Point(robotLocation.getPositionX() - 1, robotLocation.getPositionY() - 1));
			evaluatePoints.add(new Point(robotLocation.getPositionX() - 1, robotLocation.getPositionY()));
			evaluatePoints.add(new Point(robotLocation.getPositionX() - 1, robotLocation.getPositionY() + 1));
			evaluatePoints.add(new Point(robotLocation.getPositionX(), robotLocation.getPositionY() - 1));
			
			evaluatePoints.add(new Point(robotLocation.getPositionX(), robotLocation.getPositionY() + 1));
			evaluatePoints.add(new Point(robotLocation.getPositionX() + 1, robotLocation.getPositionY() - 1));
			evaluatePoints.add(new Point(robotLocation.getPositionX() + 1, robotLocation.getPositionY()));
			evaluatePoints.add(new Point(robotLocation.getPositionX() + 1, robotLocation.getPositionY() + 1));
			
			for (int i = 0; i < evaluatePoints.size(); i++) {
				Point p = evaluatePoints.get(i);
				int[] scenarioSize = map.getScenarioSize();
				if (p.getPositionX() < 0 || p.getPositionY() < 0 ||
						p.getPositionX() >= scenarioSize[0] || p.getPositionY() >= scenarioSize[1]) {
					evaluatePoints.remove(p);
				}
			}
		}*/
		return null;
	}

}
