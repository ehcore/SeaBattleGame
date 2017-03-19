import java.io.*;

public class GameHelper {

    public BufferedReader getUserInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

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

}
