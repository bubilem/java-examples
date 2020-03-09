package karelcli;

public class Item {

    protected Coordinates coordinates;
    protected char value;

    public Item(char value, Coordinates c) {
        this.coordinates = c;
        this.value = value;
    }

    public Item(char value) {
        this.coordinates = new Coordinates();
        this.value = value;
    }   

    public Item setValue(char value) {
        this.value = value;
        return this;
    }

    public char getValue() {
        return value;
    }
    
    public Coordinates getCoordinates(){
        return coordinates;
    }
    
    public Item setCoordinates(Coordinates c){
        coordinates = c;
        return this;
    }

}
