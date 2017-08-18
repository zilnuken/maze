package com.zilnuken.maze.model;

/**
 * A point representing a location in (x,y) coordinate space, specified in
 * integer precision.
 * 
 * @author edwardm
 *
 */
public class Point {
	/**
	 * The X coordinate of this Point.
	 */
	private int x;
	/**
	 * The Y coordinate of this Point.
	 */
	private int y;
	/**
	 * Parent of this Point.
	 */
	private Point parent;

	/**
	 * Point Constructor
	 * 
	 * @param x
	 *            The X coordinate of this Point.
	 * @param y
	 *            The Y coordinate of this Point.
	 * @param parent
	 *            Parent Point
	 */
	public Point(int x, int y, Point parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}

	/**
	 * Point Constructor
	 * 
	 * @param x
	 *            The X coordinate of this Point.
	 * @param y
	 *            The Y coordinate of this Point.
	 */
	public Point(int x, int y) {
		this(x, y, null);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the parent
	 */
	public Point getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Point parent) {
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + (x + 1) + "," + (y + 1) + "]";
	}

}
