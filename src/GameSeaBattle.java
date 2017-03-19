import java.io.*;

public class GameSeaBattle {

    static int quantityCells;
    static final int size = 3;
    static String[][] place4Game;


    public static void main(String[] args) {

        System.out.println("The game starting");

        quantityCells = 7;
        place4Game = GameHelper.makeMassive(quantityCells);

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
        System.out.println("For exit from game, enter \"exit\"");


        int num = 0;

        while (ShipManagement.isStillAliveShips(shipManage)) {
            System.out.println("Enter cell for fire:");

            BufferedReader reader = new GameHelper().getUserInput();
            try {
                String readFromConsole = reader.readLine().trim();
                if (readFromConsole.contains("exit")){
                    System.out.println("exit from game");
                    System.exit(0);
                }
                ShipManagement.fire(shipManage,readFromConsole);
                num ++;
            } catch (IOException exc) {
                System.out.println("Error reading frome console, try again");
            }
        }
        System.out.println("Ships destroed on " + num + " steps, congratulations!");
    }
}
