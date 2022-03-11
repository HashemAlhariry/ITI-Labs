package gov.iti.jets;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp  extends Application
{
    
    public static void main( String[] args ) {
       Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


  /*
        MoveTo moveTo = new MoveTo(100, 50);
        HLineTo hLineTo1= new HLineTo(300);

        LineTo line1 = new LineTo(400, 150);

        HLineTo hLineTo2= new HLineTo(600);

        ArcTo arcTo1 = new ArcTo();
        arcTo1.setX(600);
        arcTo1.setY(50);
        arcTo1.setRadiusX(50);
        arcTo1.setRadiusY(50);

        HLineTo hLineTo3= new HLineTo(400);

        LineTo line4 = new LineTo(300, 150);

        HLineTo hLineTo4= new HLineTo(100);


        ArcTo arcTo2 = new ArcTo();
        arcTo2.setX(100);
        arcTo2.setY(50);
        arcTo2.setRadiusX(50);
        arcTo2.setRadiusY(50);
        arcTo2.setSweepFlag(true);


        LineTo line2 = new LineTo(509, 200);
        LineTo line3 = new LineTo(160, 200);
        ArcTo arcTo2 = new ArcTo();
        arcTo2.setX(160);
        arcTo2.setY(50);
        arcTo2.setRadiusX(50);
        arcTo2.setRadiusY(50);
        arcTo2.setSweepFlag(true);


        Path path = new Path();
        path.getElements().addAll(moveTo,hLineTo1, line1,hLineTo2,arcTo1,hLineTo3,line4,hLineTo4,arcTo2);

        path.setStrokeWidth(20);
        path.setStroke(Color.DARKSLATEGREY);



        Group root = new Group(path);
   */


        BorderPane pane = FXMLLoader.load(getClass().getResource("/mainView.fxml"));
        Scene scene = new Scene(pane,700,300);
        primaryStage.setScene(scene);
        primaryStage.show();


     }

}
 