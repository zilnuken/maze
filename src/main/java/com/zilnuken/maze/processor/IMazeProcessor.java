package com.zilnuken.maze.processor;

import com.zilnuken.maze.exception.GenericException;

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
	 * @throws GenericException
	 *             If a parse error occur.
	 */
	void process(String... args) throws GenericException;

	/**
	 * Print Find Solution.
	 * 
	 */
	void print();
}
