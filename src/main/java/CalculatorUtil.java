import java.util.Stack;

public class CalculatorUtil {

    public static void printStack( Stack<Node> nums )
    {
        System.out.print( "stack: ");
        for ( Node node : nums )
        {
            switch ( node.getType() ) {
                case NUMBER:
                    System.out.print( node.getNumber() + " " );
                    break;
                case OPERATOR:
                    System.out.print( node.getOperator() + " " );
                    break;
                default:
                    System.out.print( node + " ");
            }
        }
        System.out.println();
    }
}
