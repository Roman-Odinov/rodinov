package Strategy;

import org.junit.Test;
import static org.junit.Assert.*;

public class StrategyTest {

    @Test
    public void PaintTest() {
        Triangle triangle = new Triangle();
        Square square = new Square();


        /**
         * TEST that our virtual console gets the same String as should
         */
        Paint paint = new Paint(triangle);
        paint.draw();
        // triangle.pic() -- string we should get
        // paint.getDisplayedString() -- what was displayed
        assertEquals(triangle.pic(), paint.getDisplayedString());

        System.out.println();   // just print a DELIMETER

        paint =  new Paint(square);
        paint.draw();
        // square.pic() -- string we should get
        // paint.getDisplayedString() -- what was displayed
        assertEquals(square.pic(), paint.getDisplayedString());


    }

}