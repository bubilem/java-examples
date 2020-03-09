package textart.shapes;

/**
 * Square shape is special kind of rectangle
 *
 * @author michal.bubilek
 */
public class Square extends Rectangle implements IShape {

    /**
     * Square constructor
     *
     * @param x X coordinate of square
     * @param y Y coordinate of square
     * @param size Width and height of squeare
     */
    public Square(int x, int y, int size) {
        super(x, y, size, size);
    }
}
