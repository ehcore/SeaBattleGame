
import java.util.*;

abstract public class Ship {

    int size;
    String name;
    private ArrayList<String> locationCells;

    public static Ship getShip(int size){
        switch (size){
            case 4: return new Cruiser(size);
            case 3: return new Frigate(size);
            case 2: return new Boat(size);
            default: return new UnknownBoat(size);
        }
    }

    public ArrayList<String> getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String toString(){
        return this.name;
    }
}

class Cruiser extends Ship {
    public Cruiser(int size){
        this.size = size;
        this.name = "Крейсер";//"Cruiser";
    }
}

class Frigate extends Ship {
    public Frigate(int size){
        this.size = size;
        this.name = "Фригат";//"Frigate";
    }
}
class Boat extends Ship {
    public Boat(int size){
        this.size = size;
        this.name = "Катер";//"Boat";
    }
}

class UnknownBoat extends Ship {
    public UnknownBoat(int size){
        this.size = size;
        this.name = "Неизвестная лодка";//"Unknown Boat";
    }
}