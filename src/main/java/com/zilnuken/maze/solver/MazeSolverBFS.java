package com.zilnuken.maze.solver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zilnuken.maze.model.Point;

/**
 * Maze Solver implement with Breadth First Search Algorithm
 * 
 * @author edwardm
 * @see Base Impl
 *      https://stackoverflow.com/questions/16366448/maze-solving-with-breadth-first-search
 *
 */
public class MazeSolverBFS implements IMazeSolver {

	/**
	 * Data Structure of Maze
	 */
	private List<List<Integer>> maze;

	private HashMap<String, Boolean> visitPoints;

	/**
	 * MazeSolverBFS Constructor.
	 * 
	 * @param maze
	 *            MAze to Solve.
	 */
	public MazeSolverBFS(List<List<Integer>> maze) {
		super();
		this.maze = maze;
		this.visitPoints = new HashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zilnuken.maze.solver.IMazeSolver#solve(com.zilnuken.maze.Point,
	 * com.zilnuken.maze.Point)
	 */
	@Override
	public Point solve(Point startPoint, Point endPoint) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.add(startPoint);

		while (!queue.isEmpty()) {
			Point point = queue.remove();
			Point tempPoint = null;

			if (point.equals(endPoint)) {
				return point;
			}
			// Check Move to Next X Point
			tempPoint = new Point(point.getX() + 1, point.getY(), point.getParent());
			checkMove(queue, point, tempPoint);

			// Check Move to Before X Point
			tempPoint = new Point(point.getX() - 1, point.getY(), point.getParent());
			checkMove(queue, point, tempPoint);

			// Check Move to Next Y Point
			tempPoint = new Point(point.getX(), point.getY() + 1, point.getParent());
			checkMove(queue, point, tempPoint);

			// Check Move to Before Y Point
			tempPoint = new Point(point.getX(), point.getY() - 1, point.getParent());
			checkMove(queue, point, tempPoint);

		}
		return null;
	}

	/**
	 * Check if the Explore Point is free to move and if its already visit.
	 * 
	 * @param queue
	 *            Queue of Points.
	 * @param point
	 *            Current Point.
	 * @param tempPoint
	 *            Explore Point.
	 */
	private void checkMove(Queue<Point> queue, Point point, Point tempPoint) {
		if (canMove(tempPoint)) {
			String hash = String.valueOf(tempPoint.getY() + "," + tempPoint.getX());
			if (!visitPoints.containsKey(hash)) {
				// Set Point as Visit
				setPointAsVisited(queue, point, tempPoint);
				visitPoints.put(hash, true);
			}
		}
	}

	private void setPointAsVisited(Queue<Point> queue, Point point, Point tempPoint) {
		getMaze().get(point.getY()).set(point.getX(), -1);
		Point nextP = new Point(tempPoint.getX(), tempPoint.getY(), point);
		queue.add(nextP);
	}

	/**
	 * Check if this Point is free to move.
	 * 
	 * @param point
	 *            Point to check.
	 * @return
	 */
	private boolean canMove(Point point) {
		if ((point.getY() >= 0 && point.getY() < getMaze().size())
				&& (point.getX() >= 0 && point.getX() < getMaze().get(point.getY()).size())
				&& (getMaze().get(point.getY()).get(point.getX()) == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * @return the maze
	 */
	public List<List<Integer>> getMaze() {
		return maze;
	}

	/**
	 * @param maze
	 *            the maze to set
	 */
	public void setMaze(List<List<Integer>> maze) {
		this.maze = maze;
	}

	/**
	 * @return the visitPoints
	 */
	public HashMap<String, Boolean> getVisitPoints() {
		return visitPoints;
	}

	/**
	 * @param visitPoints
	 *            the visitPoints to set
	 */
	public void setVisitPoints(HashMap<String, Boolean> visitPoints) {
		this.visitPoints = visitPoints;
	}

}
