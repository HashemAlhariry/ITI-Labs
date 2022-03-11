
import java.util.List;

public class Test {

    public void printDraw(List<? extends Shape> shape){
        for(int i=0;i<shape.size();i++){
            shape.get(i).draw();
            shape.get(i).area();
        }

    }


}
