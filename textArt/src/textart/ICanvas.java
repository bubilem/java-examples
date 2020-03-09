package textart;

import textart.shapes.IShape;

/**
 * Canvas Interface
 *
 * @author michal.bubilek
 */
public interface ICanvas {

    /**
     * Add shape (rectangle, square, circle...) to canvas
     *
     * @param shape shape to add
     */
    public void add(IShape shape);

    /**
     * Remove shape from canvas by index
     *
     * @param index shape index in ArrayList
     */
    public void rem(int index);

    /**
     * Remove shape from canvas by shape
     *
     * @param shape shape to remove
     */
    public void rem(IShape shape);

    /**
     * Write value to canvas [x,y] position
     *
     * @param x x coordinate on canvas
     * @param y y coordinate on canvas
     * @param value value to write
     */
    public void writeToPosition(int x, int y, int value);

    /**
     * Print canvas to CLI
     */
    public void print();

}
