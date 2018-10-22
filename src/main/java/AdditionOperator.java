import java.math.BigDecimal;

public class AdditionOperator implements BinaryOperator{
    private static AdditionOperator ourInstance = new AdditionOperator();

    public static AdditionOperator getInstance() {
        return ourInstance;
    }

    private AdditionOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal top, BigDecimal second) {
        return top.add( second );
    }

    @Override
    public String operatorString() {
        return ADDITION;
    }
}
