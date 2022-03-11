
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Rectangle> rectangleList = new ArrayList<>(2);
        List<Circle> circleList = new ArrayList<>(2);
        List<String> stringList = new ArrayList<>(2);
        for(int i = 0;i<2;i++){
            rectangleList.add(new Rectangle());
            circleList.add(new Circle());
            stringList.add(new String("HELLO"));
        }

        Test test = new Test();
        test.printDraw(rectangleList);
        test.printDraw(circleList);

        //test.printDraw(stringList);
    }
}
