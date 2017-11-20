package Strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * TEST that our virtual console gets the same String as should
 */
public class StrategyTest {

    @Test
    public void TriangleTest() {
        String triangleShape = "  *  \n * * \n*****";

        /**
         * Create a stream to redirect the output to ByteArray
         */
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new Paint(new Triangle()).draw();
        assertEquals(output.toString(), triangleShape);


    }

    @Test
    public void SquareTest() {
        Square square = new Square();
        String squareShape = "*****\n*   *\n*****";

        /**
         * Create a stream to redirect the output to ByteArray
         */
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new Paint(new Square()).draw();
        assertEquals(output.toString(), squareShape);


    }

}