import java.math.BigDecimal;

public class SubtractionOperator implements BinaryOperator {

    private SubtractionOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal top, BigDecimal second) {
        return second.subtract( top );
    }

    @Override
    public String operatorString() {
        return SUBTRACTION;
    }

    private static class SubtractionOperatorInstance {
        private static final SubtractionOperator INSTANCE = new SubtractionOperator();
    }

    public static SubtractionOperator getInstance() {
        return SubtractionOperatorInstance.INSTANCE;
    }
}
