package textart.shapes;

import textart.ICanvas;

/**
 * Rectangle shape
 *
 * @author michal.bubilek
 */
public class Rectangle implements IShape {

    /**
     * X coordinate of the left top corner of rectangle
     */
    int x;

    /**
     * Y coordinate of the left top corner of rectangle
     */
    int y;

    /**
     * Width of the rectangle
     */
    int width;

    /**
     * Height of the rectangle
     */
    int height;

    /**
     * Rectangle constructor
     *
     * @param x X coordinate of the left top corner of rectangle
     * @param y Y coordinate of the left top corner of rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Write rectangle to canvas
     *
     * @param c canvas for shape writing
     */
    public void toCanvas(ICanvas c) {
        for (int yy = y; yy < y + height; yy++) {
            for (int xx = x; xx < x + width; xx++) {
                c.writeToPosition(xx, yy, 1);
            }
        }
    }

}
