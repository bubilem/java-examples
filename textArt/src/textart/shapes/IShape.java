package textart.shapes;

import textart.ICanvas;

/**
 * Shape Interface
 * @author michal.bubilek
 */
public interface IShape {

    /**
     * Write shape (rectangle, square, circle...) to canvas
     * @param c canvas for shape writing
     */
    public void toCanvas(ICanvas c);
}
