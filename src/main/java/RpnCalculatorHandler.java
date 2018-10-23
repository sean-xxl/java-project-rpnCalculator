import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by sxu on 10/22/18.
 */
public class RpnCalculatorHandler {
    private Stack<Node> _numbers;
    private Stack<Node> _undoStack;

    public RpnCalculatorHandler()
    {
        _numbers = new Stack<>();
        _undoStack = new Stack<>();
    }

    public Stack<Node> getNumbers()
    {
        return _numbers;
    }

    public Stack<Node> getUndoStack()
    {
        return _undoStack;
    }


    public void processInput( String str, int position )
    {
        switch ( str )
        {
            case Operator.ADDITION:
                AdditionOperator.getInstance().processOperator( _numbers, _undoStack, position );
                break;
            case Operator.SUBTRACTION:
                SubtractionOperator.getInstance().processOperator( _numbers, _undoStack, position );
                break;
            case Operator.MULTIPLICATION:
                MultiplicationOperator.getInstance().processOperator( _numbers, _undoStack, position );
                break;
            case Operator.DIVISION:
                DivisionOperator.getInstance().processOperator( _numbers, _undoStack, position );
                break;
            case Operator.SQRT:
                SqrtOperator.getInstance().processOperator( _numbers, _undoStack, position );
                break;
            case Operator.UNDO:
                handleUndo();
                break;
            case Operator.CLEAR:
                handleClear();
                break;
            case Operator.EXIT:
                System.exit( 0 );
            default:
                try {
                    _numbers.push( new Node( Node.Type.NUMBER, null, new BigDecimal( str ) ) );
                    _undoStack.push( new Node( Node.Type.OPERATOR, Operator.INPUT_NUMBER, null ) );
                }
                catch ( NumberFormatException e )
                {
                    throw new IllegalArgumentException( "Illegal argument: " + str );
                }
                break;
        }
    }

    private void handleUndo()
    {
        if ( _undoStack.size() > 0 )
        {
            Node top = _undoStack.pop();
            switch ( top.getOperator() )
            {
                case Operator.ADDITION:
                    AdditionOperator.getInstance().undo( _numbers, _undoStack );
                    break;
                case Operator.SUBTRACTION:
                    SubtractionOperator.getInstance().undo( _numbers, _undoStack );
                    break;
                case Operator.MULTIPLICATION:
                    MultiplicationOperator.getInstance().undo( _numbers, _undoStack );
                    break;
                case Operator.DIVISION:
                    DivisionOperator.getInstance().undo( _numbers, _undoStack );
                    break;
                case Operator.SQRT:
                    SqrtOperator.getInstance().undo( _numbers, _undoStack );
                    break;
                case Operator.CLEAR:
                    handleUndoClear();
                    break;
                default:
                    _numbers.pop();
            }
        }
        else if ( _numbers.size() > 0 )
        {
            _numbers.pop();
        }
        else
        {
            throw new IllegalArgumentException( "No operation can be undo" );
        }
    }

    private void handleClear()
    {
        int size = _numbers.size();
        for ( int j = 0; j < size; j++ )
        {
            _undoStack.push( _numbers.pop() );
        }
        _undoStack.push( new Node( Node.Type.OPERATOR, Operator.CLEAR, null ) );
    }

    private void handleUndoClear()
    {
        _numbers.clear();
        int size = _undoStack.size();
        for (int i = 0; i < size; i++)
        {
            if ( _undoStack.peek().getType() == Node.Type.NUMBER )
            {
                _numbers.push( _undoStack.pop() );
            }
            else
            {
                break;
            }
        }
    }
}
