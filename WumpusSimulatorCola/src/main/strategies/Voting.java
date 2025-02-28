package main.strategies;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import main.game.map.GameMap;
import main.game.map.Point;

public class Voting implements Strategy{

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, GameMap map) {
		Sort sort = new Sort();
		FewerObstacles fewerObstacles = new FewerObstacles();
		ShortestDistance shortestDistance = new ShortestDistance();
		
		Point sortPoint = sort.evaluatePossbileNextStep(possibleNextStep, map);
		Point fewerObstaclesPoint = fewerObstacles.evaluatePossbileNextStep(possibleNextStep, map);
		Point shortestDistancePoint = shortestDistance.evaluatePossbileNextStep(possibleNextStep, map);
		
		List<Point> points = new LinkedList<>();
		points.add(sortPoint);
		points.add(fewerObstaclesPoint);
		points.add(shortestDistancePoint);
		
		Map<Point, Integer> voting = new HashMap<>();
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			if(voting.get(p) == null) {
				voting.put(p,  1);
			} else {
				voting.put(p, voting.get(p) + 1);		
			}
		}
		return getMostVotedPoint(voting);
	}

	private Point getMostVotedPoint(Map<Point, Integer> voting) {
		Integer biggestValue = Integer.MIN_VALUE;
		Point point = null;
		for (Entry<Point, Integer> entry : voting.entrySet()) {
            if (entry.getValue() > biggestValue && entry.getKey() != null) {
                biggestValue = entry.getValue();
                point = entry.getKey();
            }
        }
		return point;
        
	}
	
	/*@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, GameMap map) {
		Sort sort = new Sort();
		FewerObstacles fewerObstacles = new FewerObstacles();
		ShortestDistance shortestDistance = new ShortestDistance();
		
		Point sortPoint = sort.evaluatePossbileNextStep(possibleNextStep, map);
		Point fewerObstaclesPoint = fewerObstacles.evaluatePossbileNextStep(possibleNextStep, map);
		Point shortestDistancePoint = shortestDistance.evaluatePossbileNextStep(possibleNextStep, map);
		
		
		HashMap<String, Integer> votation = new HashMap<>();
		HashMap<String, Point> points = new HashMap<>();
		String sortPointId = getPointId(sortPoint);
		String fewerObstaclesPointId = getPointId(fewerObstaclesPoint);
		String shortestDistancePointId = getPointId(shortestDistancePoint);
		
		points.put(sortPointId, sortPoint);
		points.put(fewerObstaclesPointId, fewerObstaclesPoint);
		points.put(shortestDistancePointId, shortestDistancePoint);
		
		votation.put(sortPointId, votation.get(sortPointId) + 1);
		votation.put(fewerObstaclesPointId, votation.get(fewerObstaclesPointId) + 1);
		votation.put(shortestDistancePointId, votation.get(shortestDistancePointId) + 1);
		
		return getMostVotedPoint(votation, points);
		
	
	}

	private Point getMostVotedPoint(HashMap<String, Integer> votation, HashMap<String, Point> points) {
		Integer biggestValue = Integer.MIN_VALUE;
		String biggestKey = null;
		// Iterando pelas entradas do mapa
        for (Entry<String, Integer> entry : votation.entrySet()) {
            if (entry.getValue() > biggestValue) {
                biggestValue = entry.getValue();
                biggestKey = entry.getKey();
            }
        }
        
        return points.get(biggestKey);
	}

	public String getPointId(Point p) {
		return p.getPositionX() + "," + p.getPositionY();
	}*/


}
