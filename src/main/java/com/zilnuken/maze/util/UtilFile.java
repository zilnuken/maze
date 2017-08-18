package com.zilnuken.maze.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.zilnuken.maze.exception.GenericException;

/**
 * Utility Class For Read File
 * 
 */
public class UtilFile {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	/**
	 * Read all lines from a file.
	 * 
	 * @param fileName
	 *            File name.
	 * @return Lines from the file as a List.
	 * @throws GenericException
	 *             If an I/O error occurs.
	 */
	public static List<String> readFile(String fileName) throws GenericException {
		Path path = Paths.get(fileName);
		try {
			return Files.readAllLines(path, ENCODING);
		} catch (IOException e) {
			throw new GenericException("Read File Error");
		}
	}

}
