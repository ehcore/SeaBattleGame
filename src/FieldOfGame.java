import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class FieldOfGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("dweded");

        primaryStage.setTitle("тест кнопок javafx");

        GridPane rootNode = new GridPane();

        Scene myScene = new Scene(rootNode, 340, 240);
        primaryStage.setResizable(false);

        primaryStage.setScene(myScene);

        int quantity = GameSeaBattle.quantityCells;//10;

        Button btn[][] = new Button[quantity][quantity];

        String place4Game[][] = GameSeaBattle.place4Game;//GameHelper.makeMassive(quantity);

        for(int i=0; i<quantity ; i++){

            for(int j = 0; j<quantity; j++){

                btn[i][j] = new Button(place4Game[i][j]);

                rootNode.add(btn[i][j],i,j);

                String textButton = btn[i][j].getText();
                Button tempRefBut = btn[i][j];
                btn[i][j].setOnAction((ae)-> {
                    primaryStage.setTitle("Нажата кнопка " + textButton);
                    tempRefBut.setVisible(false);
                   // rootNode.add(new Label("*"),i,j);

                });

            }

        }


        primaryStage.show();
    }
}
