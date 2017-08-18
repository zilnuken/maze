package com.zilnuken.maze;

import com.zilnuken.maze.exception.GenericException;
import com.zilnuken.maze.processor.IMazeProcessor;
import com.zilnuken.maze.processor.MazeProcessor;

/**
 * Maze App Solver
 * 
 * @author edwardm
 *
 */
public class MazeApp {

	public static void main(String[] args) {
		try {
			IMazeProcessor processor = new MazeProcessor();
			processor.process(args);
			processor.print();
		} catch (GenericException error) {
			System.err.println("Handle Error: " + error.getMessage());
		}
	}

}