package Strategy;

/**
 * Class Square.
 * Builds ASCII square
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("*****\n");
        sb.append("*   *\n");
        sb.append("*****");
        return sb.toString();
    }
}
