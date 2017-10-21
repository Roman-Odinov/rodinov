package Strategy;

/**
 * Class Triangle.
 * Builds ASCII tringle
 */
public class Triangle implements Shape {
    @Override
    public String pic(){
        StringBuilder sb = new StringBuilder();
        sb.append("  *  \n");
        sb.append(" * * \n");
        sb.append("*****");
        return sb.toString();
    }

}
