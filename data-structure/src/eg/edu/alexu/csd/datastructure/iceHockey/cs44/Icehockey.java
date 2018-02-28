package eg.edu.alexu.csd.datastructure.iceHockey.cs44;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 *
 * @author SHIKO
 *
 */
public class Icehockey implements IPlayersFinder {
	/**
	 * @serialField pixels
	 */
	public char[][] photoPixels;
	/**
	 * @serialField area;
	 */
	public int area;
	/**
	 * @serialField flag
	 *                  array
	 */
	public boolean[][] visited;
	/**
	 * @serialField maxRow
	 */
	public int maxRow = 0;
	/**
	 * @serialField max
	 *                  column
	 */
	public int maxColumn = 0;
	/**
	 * @serialField minrow
	 */
	public int minRow = 0;
	/**
	 * @serialField mincolumn
	 */
	public int minColumn = 0;
	/**
	 * @serialField return
	 *                  point
	 */
	public Point p = new Point();
	/**
	 * @serialField rec.point
	 */
	public Point receivedPoint = new Point();
	/**
	 * @serialField return
	 *                  array
	 */
	public Point[] arrayOfPoints;
	/**
	 * @serialField array
	 *                  list for adding points
	 */
	ArrayList<Point> points = new ArrayList<Point>();
	/**
	 * @serialField array
	 *                  list for adding points
	 */
	ArrayList<Point> coordinates = new ArrayList<Point>();
	/**
	 *
	 * @param row position y
	 * @param column position x
	 * @param team teamcolor
	 * @param threshold miniarea
	 * @return point
	 */
	public Point search(final int row, final int column,
			final char team, final int threshold) {

		if (row < 0 || column < 0 || row >= photoPixels.length
				|| column >= photoPixels[0].length) {
			return null;
		} else if (photoPixels[row][column] != team
				|| visited[row][column] == true) {
			visited[row][column] = true;
			return null;

		} else {
			if (row > maxRow) {
				maxRow = row;

			}
			if (column > maxColumn) {
				maxColumn = column;

			}
			if (row < minRow) {
				minRow = row;

			}
			if (column < minColumn) {
				minColumn = column;

			}

			visited[row][column] = true;
			search(row, column + 1, team, threshold);
			search(row, column - 1, team, threshold);
			search(row + 1, column, team, threshold);
			search(row - 1, column, team, threshold);
			area += 4;

		}
		// System.out.println(area);
		if (area >= threshold) {

			p.x = (((maxColumn * 2) + 2) + ((minColumn * 2))) / 2;
			p.y = (((maxRow * 2) + 2) + ((minRow * 2))) / 2;
			return p;
		}
		return null;

	}

	@Override
	public Point[] findPlayers(final String[] photo,
			final int team, final int threshold) {
		if (photo == null) {
			return null;
		}
		int i;
		int j;
		char teamx = (char) (team + '0');

		photoPixels = new char[photo.length][photo[0].length()];
		visited = new boolean[photo.length][photo[0].length()];
		for (i = 0; i < photo.length; i++) {
			for (j = 0; j < photo[0].length(); j++) {
				visited[i][j] = false;
			}
		}
		for (i = 0; i < photo.length; i++) {
			for (j = 0; j < photo[0].length(); j++) {
				photoPixels[i][j] = photo[i].charAt(j);
			}
		}

		for (i = 0; i < photoPixels.length; i++) {
			for (j = 0; (j < photoPixels[0].length); j++) {

				area = 0;
				maxRow = 0;
				maxColumn = 0;
				minColumn = j;
				minRow = i;
				receivedPoint = search(i, j, teamx, threshold);

				if (receivedPoint != null) {

					points.add(new Point(receivedPoint.x, receivedPoint.y));

				}

			}
		}

		Collections.sort(points, new PointCompare());

		arrayOfPoints = new Point[points.size()];
		if (arrayOfPoints == null) {
			return null;
		} else {
			arrayOfPoints = points.toArray(arrayOfPoints);
		}

		points.clear();

		return arrayOfPoints;
	}

}
