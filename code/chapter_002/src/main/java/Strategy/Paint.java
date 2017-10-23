package Strategy;


/**
 * Class Paint.
 * Incorporates any Shape-like class
 */
public class Paint {

    private Shape shape_;

    /**
     * We can send to constructor any `Shape` object
     */
    public Paint(Shape shape) {
        this.shape_ = shape;
    }

    /**
     * Prints picture to console.
     */
    public void draw() {
        System.out.print(shape_.pic());
    }
}
