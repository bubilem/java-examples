package karelcli;

public class Karel extends Item {

    public static char[] possibleValues = {'S', 'Z', 'V', 'J'};

    public Karel(char value) {
        super(value);
    }

    @Override
    public final Karel setValue(char value) {
        if (new String(possibleValues).contains(String.valueOf(value))) {
            this.value = value;
        }
        return this;
    }

    public void step() {
        switch (this.value) {
            case 'Z':
                this.coordinates.addX(-1);
                break;
            case 'V':
                this.coordinates.addX(1);
                break;
            case 'S':
                this.coordinates.addY(-1);
                break;
            case 'J':
                this.coordinates.addY(1);
                break;
        }
    }

    public void turnLeft() {
        switch (this.value) {
            case 'S':
                this.value = 'Z';
                break;
            case 'J':
                this.value = 'V';
                break;
            case 'Z':
                this.value = 'J';
                break;
            case 'V':
                this.value = 'S';
                break;
        }
    }

}
