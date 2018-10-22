import java.math.BigDecimal;

public class DivisionOperator implements BinaryOperator{
    private static DivisionOperator ourInstance = new DivisionOperator();

    public static DivisionOperator getInstance() {
        return ourInstance;
    }

    private DivisionOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal top, BigDecimal second) {
        return second.divide( top );
    }

    @Override
    public String operatorString() {
        return DIVISION;
    }
}
