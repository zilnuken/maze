/**
 * 
 */
package com.zilnuken.maze.parser;

import java.util.ArrayList;
import java.util.List;

import com.zilnuken.maze.exception.GenericException;

/**
 * Maze Parser of input file rows.
 * 
 * @author edwardm
 *
 */
public class MazeParserTSV implements IMazeParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zilnuken.maze.parser.IMazeParser#parse(java.util.List)
	 */
	@Override
	public List<List<Integer>> parse(List<String> rows) throws GenericException {
		List<List<Integer>> maze = new ArrayList<>();

		for (String row : rows) {
			List<Integer> rowMaze = new ArrayList<>();
			boolean beforeIsF = false;
			for (char tempChar : row.toCharArray()) {
				if (beforeIsF) {
					beforeIsF = false;
					continue;
				}
				if ('F' == tempChar) {
					rowMaze.add(0);
					beforeIsF = true;
				} else if ('\t' == tempChar) {
					rowMaze.add(1);
				} else {
					throw new GenericException("Input Data Error");
				}
			}
			maze.add(rowMaze);
		}
		return maze;
	}

}
