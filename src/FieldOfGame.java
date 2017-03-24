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
        primaryStage.setTitle("тест кнопок javafx");

        GridPane rootNode = new GridPane();
        //rootNode.
        //rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 340, 220);

        primaryStage.setScene(myScene);

        //Label lbl = new Label("Нажмите на кнопку");

        //Button btn1 = new Button("Песочные часы");
        //Button btn2 = new Button("Аналоговые часы");

        //Button btn1 = new Button("Песочные часы");
        //Button btn2 = new Button("Аналоговые часы");

        //btn1.setContentDisplay(ContentDisplay.TOP);
        //btn2.setContentDisplay(ContentDisplay.BOTTOM);

        //btn1.setOnAction((ae)-> lbl.setText("Запущены песочные часы"));
        //btn2.setOnAction((ae)-> lbl.setText("Запущены аналоговые часы"));

        //Image im = new Image("hourglass.png");
        //ImageView iv = new ImageView(im);

        /*
        rootNode.setRowIndex(btn1,0);
        rootNode.setColumnIndex(btn1,4);

        rootNode.setRowIndex(btn2,5);
        rootNode.setColumnIndex(btn2,2);

        rootNode.setRowIndex(lbl,10);
        rootNode.setColumnIndex(lbl,0);


        rootNode.getChildren().addAll(btn1,btn2,lbl);

        */


        int quantity = 10;

        Button btn[][] = new Button[quantity][quantity];



        for(int i=0; i<quantity ; i++){

            for(int j = 0; j<quantity; j++){

                btn[i][j] = new Button("i"+i + "j" + j);

                rootNode.add(btn[i][j],i,j);

                String textButton = btn[i][j].getText();
                btn[i][j].setOnAction((ae)-> primaryStage.setTitle("Нажата кнопка " + textButton));

            }

        }


       // rootNode.add(btn1,0,0);
        //rootNode.add(btn2,0,15);
        //rootNode.add(lbl,10,0);

        primaryStage.show();
    }
}
