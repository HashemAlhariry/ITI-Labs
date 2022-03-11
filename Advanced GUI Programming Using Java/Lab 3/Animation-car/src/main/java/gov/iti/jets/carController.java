package gov.iti.jets;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class carController implements Initializable {

    @FXML
    ImageView carImage;
    @FXML
    Path path;
    @FXML
    ImageView carImage2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        PathTransition pathTransitionCar1 = new PathTransition();
        pathTransitionCar1.setDuration(Duration.millis(6000));
        pathTransitionCar1.setPath(path);
        pathTransitionCar1.setNode(carImage);
        pathTransitionCar1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionCar1.setCycleCount(Timeline.INDEFINITE);
        PathTransition pathTransitionCar2 = new PathTransition();
        pathTransitionCar2.setDuration(Duration.millis(4000));
        pathTransitionCar2.setPath(path);
        pathTransitionCar2.setNode(carImage2);
        pathTransitionCar2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionCar2.setCycleCount(Timeline.INDEFINITE);



        pathTransitionCar1.play();
        pathTransitionCar2.play();



    }

}
