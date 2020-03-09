package karelcli;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates() {
        setXY(0, 0);
    }

    public Coordinates(int x, int y) {
        setXY(x, y);
    }

    public Coordinates(Coordinates c) {
        setXY(c.getX(), c.getY());
    }

    public Coordinates setX(int x) {
        this.x = x;
        return this;
    }

    public Coordinates setY(int y) {
        this.y = y;
        return this;
    }

    public Coordinates addX(int x) {
        this.x += x;
        return this;
    }

    public Coordinates addY(int y) {
        this.y += y;
        return this;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public final Coordinates setXY(int x, int y) {
        setX(x);
        setY(y);
        return this;
    }

    public boolean equals(Coordinates c) {
        return x == c.getX() && y == c.getY();
    }

}
