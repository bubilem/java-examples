package textart;

import textart.shapes.Circle;
import textart.shapes.Square;
import textart.shapes.Rectangle;

/**
 * Main run class
 *
 * Demo print basic shapes on CLI
 *
 * @author michal.bubilek
 */
public class TextArt {

    public static void main(String[] args) {

        Canvas c = new Canvas(45, 11);

        /* Star Trek USS Enterprise */
        Rectangle nacelle = new Rectangle(0, 1, 16, 2);
        c.add(nacelle);
        c.add(new Rectangle(4, 8, 19, 3));
        c.add(new Rectangle(10, 3, 3, 5));
        c.add(new Rectangle(22, 2, 21, 3));
        c.add(new Circle(24, 9, 1));
        c.add(new Circle(22, 3, 1));
        c.add(new Circle(43, 3, 1));
        c.add(new Circle(33, 3, 3));
        c.add(new Square(22, 4, 3));
        c.add(new Square(20, 6, 3));
        c.print();

        System.out.println("");

        c.rem(nacelle);
        c.rem(1);
        c.print();

    }

}
