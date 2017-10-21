package Strategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Class Paint.
 * Incorporates any Shape-like class
 */
public class Paint {

    private Shape shape_;

    /**
     * Just for test purposes:
     * Create a stream to redirect the output to ByteArray
     */
    private ByteArrayOutputStream baos_ = new ByteArrayOutputStream();

    /**
     * We can send to constructor any `Shape` object
     */
    public Paint(Shape shape) {
        this.shape_ = shape;
    }

    /**
     * Prints pseudo-picture to console.
     */
    public void draw() {
        // Save the old System.out
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(new PrintStream(baos_));
        // Print output: goes to ByteArrayOutput stream
        System.out.print(shape_.pic());
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Return our String to _real_ console (just print it)
        System.out.println(baos_.toString());
    }

    /**
     * Returns string which is sent to System.out
     */
    public String getDisplayedString() {
        return this.baos_.toString();
    }
}
