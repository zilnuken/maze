/**
 * 
 */
package com.zilnuken.maze.solver;

import com.zilnuken.maze.model.Point;

/**
 * Interface of Maze Solver.
 * 
 * @author edwardm
 *
 */
public interface IMazeSolver {
	/**
	 * Find Maze endpoint.
	 * 
	 * @param startPoint
	 *            Start Point.
	 * @param endPoint
	 *            End Point.
	 * @return Maze endpoint.
	 */
	Point solve(Point startPoint, Point endPoint);
}
