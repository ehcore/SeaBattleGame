
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

        quantityCells = 7;
        place4Game = makeMassive(quantityCells);

        int countShip = 0;

        ShipManagement drDC[] = new ShipManagement[100];
        for(int i = 0; i<drDC.length ; i++){
            drDC[i] = new ShipManagement();
            if(drDC[i].createShip()){countShip++;}
        }

        System.out.println("created " + countShip + " ships");
    }
}
