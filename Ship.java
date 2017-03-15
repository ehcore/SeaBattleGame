
import java.util.*;

public class Ship {


    private ArrayList<String> locationCells;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public ArrayList<String> getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }



}
