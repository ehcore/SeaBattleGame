
import java.util.*;

public class ShipManagement {

    Ship ship;

    boolean createShip(){
        int quantityCells = GameSeaBattle.quantityCells;
        int size = GameSeaBattle.size;

        ship = new Ship();

        Direction direction = getDirection();
        ArrayList<String> locationCells;

        boolean canBeInstall;

        int firstCell;
        int lastCell;
        int line;

        Date startDate = new Date();

        do{
            Date endDate = new Date();
            long quantitySec = endDate.getTime() - startDate.getTime();
            if((quantitySec) > 5){ return false;}

            line = getLine(quantityCells);

            int startLine = line > 0 ? line - 1 : 0;
            int endLine   = line < (quantityCells -1) ? line + 1 : quantityCells -1;

            firstCell = getFirstCell();
            lastCell  = firstCell + size;

            int afterFirstCell = firstCell > 0 ? firstCell - 1 : 0;
            int beforeLastCell = lastCell < (quantityCells -1) ? lastCell + 1 : quantityCells -1;

            HashMap<String,Integer> hashMap = new HashMap<String,Integer>(4);
            hashMap.put("startLine",startLine);
            hashMap.put("endLine",endLine);
            hashMap.put("afterFirstCell",afterFirstCell);
            hashMap.put("beforeLastCell",beforeLastCell);

            canBeInstall = checkCells(hashMap,direction);

        } while(!canBeInstall);

        String[][] massive = GameSeaBattle.place4Game;

        String valueCell;

        locationCells = new ArrayList<String>();

        if (direction == Direction.Vertical) {
            for(int x = firstCell; x < lastCell; x++){
                valueCell = massive[x][line];
                locationCells.add(valueCell);
                GameSeaBattle.place4Game[x][line] = null;
            }
        }else if(direction == Direction.Horizontal){
            for(int x = firstCell; x < lastCell; x++){
                valueCell = massive[line][x];
                locationCells.add(valueCell);
                GameSeaBattle.place4Game[line][x] = null;
            }
        }

        for(String cell : locationCells){
            System.out.println(cell);
        }

        ship.setLocationCells(locationCells);
        return true;
    }

    static boolean fire(ShipManagement shipManage[],String cell){

        System.out.println("You entered:" + cell);
        for(int i = 0; i<shipManage.length ; i++){
            ArrayList<String> locationCells = shipManage[i].ship.getLocationCells();
            if(locationCells == null){continue;}
            if(locationCells.contains(cell)){
                System.out.println("Hit! " + cell);
                locationCells.remove(cell);
                return true;}
        }
        System.out.println("Fail! " + cell);
        return false;
    }

    Direction getDirection(){
        int dir = (int) (Math.random()*10);
        if(dir<5) return Direction.Horizontal;
        else return Direction.Vertical;
    }

    int getLine(int quantityCells){
        int line = (int) (Math.random()* quantityCells);
        return line;
    }

    private int getFirstCell(){
        int firstCell;
        do{
            firstCell = (int) (Math.random() * 10);
        }
        while (firstCell>(GameSeaBattle.quantityCells - GameSeaBattle.size - 1));

        return firstCell;
    }

    public boolean checkCells(HashMap hashMap, Direction dir){

        int startLine      = (int) hashMap.get("startLine");
        int endLine        = (int) hashMap.get("endLine");
        int afterFirstCell = (int) hashMap.get("afterFirstCell");
        int beforeLastCell = (int) hashMap.get("beforeLastCell");

        String[][] massive = GameSeaBattle.place4Game;

        if (dir == Direction.Vertical) {
            for (int i = afterFirstCell; i <= beforeLastCell; i++) {
                for (int j = startLine; j <= endLine; j++) {
                    if (massive[i][j] == null) return false;
                }
            }
        }else if(dir == Direction.Horizontal){
            for (int i =  startLine ; i <=  endLine ; i++) {
                for (int j = afterFirstCell; j <= beforeLastCell; j++) {
                    if (massive[i][j] == null) return false;
                }
            }
        }
        return true;
    }

    static boolean isStillAliveShips(ShipManagement shipManage[]){

        for(int i = 0; i<shipManage.length ; i++){
            ArrayList<String> locationCells = shipManage[i].ship.getLocationCells();
            if(locationCells == null){continue;}
                if (!locationCells.isEmpty()) {
                    return true;
                }
        }
        return false;
    }
}
