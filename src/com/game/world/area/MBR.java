package com.game.world.area;

public interface MBR {
	/**
	 * Fetches the length of the given dimension.
	 * 
	 * @param axis
	 *            the dimension
	 * @return the length of the dimension requested
	 */
	public int getDimension(int axis);

	/**
	 * Fetches the number of dimensions this MBR represents. This may be one,
	 * two, three or more.
	 * 
	 * @return the number of dimensions.
	 */
	public int getDimensions();

	/**
	 * Fetches the minimum value (smallest value) on the given axis.
	 * 
	 * @param axis
	 *            the axis
	 * @return the smallest value
	 */
	public int getMin(int axis);
}