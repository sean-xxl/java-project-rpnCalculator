import java.math.BigDecimal;
import java.util.Stack;

public interface BinaryOperator extends Operator {
    /**
     * Check if the stack contain the required parameters
     * */
    default void checkParameters( Stack<Node> nums, int position )
    {
        if ( nums.size() < 2 )
        {
            System.out.println( "operator " + operatorString() + " (position: " + position + "): insufficient parameters");
            CalculatorUtil.printStack( nums );
            System.exit( 1 );
        }
        else if ( nums.get( nums.size() -2).getType() != Node.Type.NUMBER ||
                nums.peek().getType() != Node.Type.NUMBER )
        {
            CalculatorUtil.printStack( nums );
            throw new IllegalArgumentException("These two parameters must be numbers");
        }
    }

    default void processOperator( Stack<Node> nums, Stack<Node> undoStack, int position )
    {
        checkParameters( nums, position );
        Node p0 = nums.pop();
        Node p1 = nums.pop();
        BigDecimal result = execute( p0.getNumber(), p1.getNumber() );

        undoStack.push( p0 );
        undoStack.push( p1 );
        undoStack.push( new Node( Node.Type.OPERATOR, operatorString(), null ) );

        nums.push( new Node( Node.Type.NUMBER, null, result ) );
    }

    default void undo( Stack<Node> nums, Stack<Node> undoStack )
    {
        nums.pop();
        nums.push( undoStack.pop() );
        nums.push( undoStack.pop() );
    }

    /**
     * Actually execute the operator
     * */
    BigDecimal execute( BigDecimal top, BigDecimal second );
}
