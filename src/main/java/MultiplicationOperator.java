import java.math.BigDecimal;

public class MultiplicationOperator implements BinaryOperator{
    private static MultiplicationOperator ourInstance = new MultiplicationOperator();

    public static MultiplicationOperator getInstance() {
        return ourInstance;
    }

    private MultiplicationOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal top, BigDecimal second) {
        return second.multiply( top );
    }

    @Override
    public String operatorString() {
        return MULTIPLICATION;
    }
}
