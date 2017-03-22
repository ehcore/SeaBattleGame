import java.io.*;

public class GameSeaBattle {

    static int quantityCells;
    static String[][] place4Game;


    public static void main(String[] args) {

        if(args.length != 1){
            //System.err.println("Command format: java GameSeaBattle <number of cells (greater than 4 and less than or equal to 10)>");
            System.err.println("Формат команды: java GameSeaBattle <количество ячеек(больше 4 и меньше или равно 10)>");
            System.exit(0);
        }

        try {
            quantityCells = Integer.parseInt(args[0]);
            if(quantityCells <=4 || quantityCells >10){
                //System.out.println("You entered the wrong number of cells");
                System.out.println("Вы ввели не правильное количество ячеек");
                System.exit(0);
            }
        }catch(Exception exc){
            //System.out.println("You enter not a number");
            System.out.println("Вы ввели не число");
            System.exit(0);
        }

        //System.out.println("Will be created  " + quantityCells + " by " + quantityCells + " cells.");
        System.out.println("Будет создано поле " + quantityCells + " на " + quantityCells + " ячеек.");
        //System.out.println("The game starting");
        System.out.println("Игра начинается.");

        place4Game = GameHelper.makeMassive(quantityCells);

        int countShip = 0;

        //System.out.println("Creation of ships:");
        System.out.println("Создание кораблей:");

        ShipManagement shipManage[] = new ShipManagement[7];
        for(int i = 0; i<shipManage.length ; i++){
            shipManage[i] = new ShipManagement();
            int randomSize = 0;
            do{
               randomSize = (int) (Math.random()*5);
            }while(randomSize == 0);

            if(shipManage[i].createShip(randomSize)){

                System.out.println(shipManage[i].ship);
                countShip++;}
        }

        System.out.println();
        //System.out.println("Created " + countShip + " ships.");
        System.out.println("Создано " + countShip + " кораблей.");

        //System.out.println("Note: name of the cell it is letter and number. Letter from a to g (lowercase), number from 0 to 6. Example: a0");
        //System.out.println("For exit from game, enter \"exit\"");
        System.out.println("Пояснение: имя ячейки это буква и цифра. Буква от a до g (маленькая латинская буква), цифра от 0 до 6. Пример: a0");
        System.out.println("Для выхода введите \"exit\"");


        int num = 0;

        while (ShipManagement.isStillAliveShips(shipManage)) {
            //System.out.println("Enter cell for fire:");
            System.out.println("Введите имя ячейки:");

            BufferedReader reader = new GameHelper().getUserInput();
            try {
                String readFromConsole = reader.readLine().trim();
                if (readFromConsole.contains("exit")){
                    //System.out.println("exit from game");
                    System.out.println("Выход из игры.");
                    System.exit(0);
                }
                ShipManagement.fire(shipManage,readFromConsole);
                num ++;
            } catch (IOException exc) {
                System.out.println("Error reading frome console, try again");
            }
        }
        //System.out.println("Ships destroed on " + num + " steps, congratulations!");
        System.out.println("Корабли уничтожены за " + num + " ходов, поздравляю!");
    }
}
