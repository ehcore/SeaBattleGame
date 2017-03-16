import java.io.*;

public class GameSeaBattle {

    static int quantityCells;
    static final int size = 3;
    static String[][] place4Game;

    static String[][] makeMassive(int quantityCells){
        String str = "abcdefg";
        String[][] place4Game = new String[quantityCells][quantityCells];
        for(int i = 0; i<quantityCells;i++){
            for(int j=0; j<quantityCells;j++){
                place4Game[i][j] =  str.charAt(i) +"" + j;
            }
        }
        return place4Game;
    }

    public static void main(String[] args) {

        System.out.println("The game starting");


        quantityCells = 7;
        place4Game = makeMassive(quantityCells);

        int countShip = 0;

        System.out.println("Creation of ships");

        ShipManagement shipManage[] = new ShipManagement[5];
        for(int i = 0; i<shipManage.length ; i++){
            shipManage[i] = new ShipManagement();
            if(shipManage[i].createShip()){countShip++;}
        }

        System.out.println();
        System.out.println("Created " + countShip + " ships");

        System.out.println("Note: name of the cell it is letter and number. Letter from a to g (lowercase), number from 0 to 6. Example: a0");

        int num = 0;


        while (ShipManagement.isStillAliveShips(shipManage)) {

            System.out.println("Enter cell for fire:");


            BufferedReader reader = new GameHelper().getUserInput();
            try {
                String readFromConsole = reader.readLine().trim();
                ShipManagement.fire(shipManage,readFromConsole);
                num ++;
            } catch (IOException exc) {
                System.out.println("Error reading frome console, try again");
            }

            }

        System.out.println("Ships destroed on " + num + " steps, congratulations!");

    }
}
