package com.zilnuken.maze.processor;

/**
 * Interface of Maze Processor.
 * 
 * @author edwardm
 *
 */
public interface IMazeProcessor {
	/**
	 * Process Maze Solver
	 * 
	 * @param args
	 *            Arguments from command line.
	 */
	void process(String... args);

	/**
	 * Print Find Solution.
	 * 
	 */
	void print();
}
