package com.zilnuken.maze;

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
		IMazeProcessor processor = new MazeProcessor();
		processor.process(args);
		processor.print();
	}

}