import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

public class CalculatorUtil {
    public static final BigDecimal MIN_DEC = new BigDecimal("0.0000000000000001");

    public static void printStack( Stack<Node> nums )
    {
        System.out.print( "stack: ");
        for ( Node node : nums )
        {
            switch ( node.getType() ) {
                case NUMBER:
                    printNumber( node.getNumber() );
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

    public static void printNumber( BigDecimal num )
    {
        BigDecimal decimal = num.remainder( BigDecimal.ONE, MathContext.DECIMAL64 ).abs();
        if ( decimal.compareTo( MIN_DEC ) < 0 )
        {
            num = num.setScale(0, BigDecimal.ROUND_DOWN );
            System.out.print( num + " " );
        }
        else
        {
            System.out.print( num.setScale( 10, BigDecimal.ROUND_HALF_UP ) + " " );
        }
    }
}
