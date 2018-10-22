import java.math.BigDecimal;
import java.util.Stack;

public interface UnaryOperator extends Operator {

    /**
     * Check if the stack contain the required parameters
     * */
    default void checkParameters( Stack<Node> nums, int position )
    {
        if ( nums.size() < 1 )
        {
            System.out.println( "operator " + operatorString() + " (position: " + position + "): insufficient parameters");
            CalculatorUtil.printStack( nums );
            System.exit( 1 );
        }
        else if ( nums.peek().getType() != Node.Type.NUMBER )
        {
            CalculatorUtil.printStack( nums );
            throw new IllegalArgumentException("The last parameter must be number");
        }
    }

    default void processOperator( Stack<Node> nums, Stack<Node> undoStack, int position )
    {
        checkParameters( nums, position );
        BigDecimal result = execute( nums.peek().getNumber() );

        undoStack.push( nums.pop() );
        undoStack.push( new Node( Node.Type.OPERATOR, operatorString(), null ) );

        nums.push( new Node( Node.Type.NUMBER, null, result ) );
    }

    default void undo( Stack<Node> nums, Stack<Node> undoStack )
    {
        nums.pop();
        nums.push( undoStack.pop() );
    }

    /**
     * Actually execute the operator
     * */
    BigDecimal execute( BigDecimal p0 );
}
