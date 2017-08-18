package com.zilnuken.maze.processor;

import java.util.List;

import com.zilnuken.maze.exception.GenericException;
import com.zilnuken.maze.model.Point;
import com.zilnuken.maze.parser.IMazeParser;
import com.zilnuken.maze.parser.MazeParserTSV;
import com.zilnuken.maze.solver.IMazeSolver;
import com.zilnuken.maze.solver.MazeSolverBFS;
import com.zilnuken.maze.util.UtilFile;

/**
 * Processor of Maze.
 * 
 * @author edwardm
 *
 */
public class MazeProcessor implements IMazeProcessor {

	private Point solutionPoint;
	private Point startPoint;
	private Point endPoint;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zilnuken.maze.processor.IMazeProcessor#process()
	 */
	@Override
	public void process(String... args) throws GenericException {

		String nameFile = null;

		// Read Command Line Parameters.
		if (args.length == 5) {
			nameFile = args[0];
			setStartPoint(new Point(Integer.parseInt(args[1]) - 1, Integer.parseInt(args[2]) - 1));
			setEndPoint(new Point(Integer.parseInt(args[3]) - 1, Integer.parseInt(args[4]) - 1));
		} else if (args.length == 1 && "default".equals(args[0])) {
			nameFile = "Hound_Maze(tsv).txt";
			setStartPoint(new Point(60 - 1, 83 - 1));
			setEndPoint(new Point(18 - 1, 26 - 1));
		} else {
			System.out.println("Usage: filename xStartPoint yStartPoint xEndPoint yEndPoint");
			System.out.println("Example: Sample1(tsv).txt 31 6 19 17");
			throw new GenericException("Bad Usage");
		}
		// Read File.
		List<String> rows = UtilFile.readFile(nameFile);

		// Pase File and Build Maze Solver.
		IMazeParser parser = new MazeParserTSV();
		List<List<Integer>> maze = parser.parse(rows);
		IMazeSolver solver = new MazeSolverBFS(maze);

		// Find Solution
		setSolutionPoint(solver.solve(getStartPoint(), getEndPoint()));

		if (null == getSolutionPoint()) {
			throw new GenericException("Not Solution Found");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zilnuken.maze.processor.IMazeProcessor#printSolution()
	 */
	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		while (getSolutionPoint().getParent() != null) {
			sb.insert(0, getSolutionPoint().toString() + ",");
			setSolutionPoint(getSolutionPoint().getParent());
		}
		sb.insert(0, getStartPoint().toString() + ",");
		String result = "[" + sb.substring(0, sb.length() - 1) + "]";

		System.out.print("solution: " + result);
	}

	/**
	 * @return the solutionPoint
	 */
	public Point getSolutionPoint() {
		return solutionPoint;
	}

	/**
	 * @param solutionPoint
	 *            the solutionPoint to set
	 */
	public void setSolutionPoint(Point solutionPoint) {
		this.solutionPoint = solutionPoint;
	}

	/**
	 * @return the startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * @param startPoint
	 *            the startPoint to set
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * @return the endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint
	 *            the endPoint to set
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
