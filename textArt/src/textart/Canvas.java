package textart;

import java.util.ArrayList;
import java.util.List;
import textart.shapes.IShape;

/**
 * Canvas for writing shapes
 *
 * @author michal.bubilek
 */
public class Canvas implements ICanvas {

    /**
     * Canvas width
     */
    private final int width;

    /**
     * Canvas height
     */
    private final int height;

    /**
     * Canvas width
     */
    List<IShape> items;

    private int canvas[][];

    /**
     * Canvas constructor
     *
     * @param width canvas width
     * @param height canvas height
     */
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        items = new ArrayList<>();
        canvas = new int[width][height];
    }

    /**
     * Add shape to canvas
     *
     * @param shape shape to add
     */
    public void add(IShape shape) {
        items.add(shape);
    }

    /**
     * Remove shape from canvas by index
     *
     * @param index list of shapes index
     */
    public void rem(int index) {
        items.remove(index);
    }

    /**
     * Remove shape from canvas by shape
     *
     * @param shape shape to remove
     */
    public void rem(IShape shape) {
        items.remove(shape);
    }

    /**
     * Write value to canvas [x,y] position
     *
     * @param x x coordinate on canvas
     * @param y y coordinate on canvas
     * @param value value to write
     */
    public void writeToPosition(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            canvas[x][y] = value;
        }
    }

    /**
     * Print canvas to CLI
     */
    public void print() {
        canvas = new int[width][height];
        items.forEach(item -> item.toCanvas(this));
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(canvas[x][y] != 0 ? Character.toString((char) 0x2593) : Character.toString((char) 0x2591));
            }
            System.out.print("\n");
        }
    }

}
