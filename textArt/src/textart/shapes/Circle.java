package textart.shapes;

import textart.ICanvas;

/**
 * Circle shape
 *
 * @author michal.bubilek
 */
public class Circle implements IShape {

    /**
     * X coordinate of circle center
     */
    int xs;

    /**
     * Y coordinate of circle center
     */
    int ys;

    /**
     * Radius of the circle
     */
    int r;

    /**
     * Circle constructor
     *
     * @param xs X coordinate of circle center
     * @param ys Y coordinate of circle center
     * @param r Radius of the circle
     */
    public Circle(int xs, int ys, int r) {
        this.xs = xs;
        this.ys = ys;
        this.r = r;
    }

    /**
     * Write circle to canvas
     *
     * @param c canvas for shape writing
     */
    public void toCanvas(ICanvas c) {
        for (int y = ys - r; y <= ys + r; y++) {
            for (int x = xs - r; x <= xs + r; x++) {
                if (inCircle(x, y)) {
                    c.writeToPosition(x, y, 1);
                }
            }
        }
    }

    /**
     * Test if coordinates [x,y] is in circle
     *
     * The Pythagorean theorem is used to calculate the distance between points
     * in the 2D
     *
     * @param x input x coordinate
     * @param y input y coordinate
     * @return true if [x,y] is in circle
     */
    private boolean inCircle(int x, int y) {
        return Math.pow(x - xs, 2) + Math.pow(y - ys, 2) <= Math.pow(r, 2);
    }

}
