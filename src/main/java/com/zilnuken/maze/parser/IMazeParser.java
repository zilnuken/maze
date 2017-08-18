package com.zilnuken.maze.parser;

import java.util.List;

import com.zilnuken.maze.exception.GenericException;

/**
 * Interface of Maze Parser.
 * 
 * @author edwardm
 *
 */
public interface IMazeParser {
	/**
	 * Parse Rows and create Maze Data Structure.
	 * 
	 * @param rows
	 *            Input list of file rows.
	 * @return Maze Data Structure.
	 * @throws GenericException
	 *             If a parse error occur.
	 */
	List<List<Integer>> parse(List<String> rows) throws GenericException;
}
