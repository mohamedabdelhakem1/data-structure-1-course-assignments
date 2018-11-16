package eg.edu.alexu.csd.datastructure.maze.cs42_cs44_cs65;

import java.awt.Point;

/**
 * @author Muhammad Salah
 *
 */
public class Node {
    /**
     *
     */
    private Point p = null;
    /**
     *
     */
    private boolean v = false;
    /**
     *
     */
    private Integer d = 0;
    /**
     * @param point p
     */
    public void setPoint(final Point point) {
        p =  new Point(point.x, point.y);
    }
    /**
     * @param distance d
     */
    public void setDis(final Integer distance) {
        d = distance;
    }
    /**
     * @return d
     */
    public Integer getDis() {
        return d;
    }
    /**
     * @return p
     */
    public Point getPoint() {
        return p;
    }
    /**
     * @param b boolean
     */
    
    public void setVisited(final boolean b) {
        v = b;
    }
    /**
     * @return v
     */
    public boolean getVisited() {
        return v;
    }
}
