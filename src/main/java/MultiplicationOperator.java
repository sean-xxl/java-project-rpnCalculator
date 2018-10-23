import java.math.BigDecimal;
import java.math.MathContext;

public class MultiplicationOperator implements BinaryOperator{
    private static MultiplicationOperator ourInstance = new MultiplicationOperator();

    public static MultiplicationOperator getInstance() {
        return ourInstance;
    }

    private MultiplicationOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal top, BigDecimal second) {
        return second.multiply( top, MathContext.DECIMAL64 );
    }

    @Override
    public String operatorString() {
        return MULTIPLICATION;
    }
}
