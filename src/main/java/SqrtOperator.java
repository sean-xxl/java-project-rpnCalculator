import java.math.BigDecimal;
import java.math.MathContext;

public class SqrtOperator implements UnaryOperator {
    private static SqrtOperator ourInstance = new SqrtOperator();

    public static SqrtOperator getInstance() {
        return ourInstance;
    }

    private SqrtOperator() {
    }

    @Override
    public BigDecimal execute(BigDecimal p0) {
        return sqrt( p0, MathContext.DECIMAL64 );
    }

    @Override
    public String operatorString() {
        return SQRT;
    }

    private static final BigDecimal TWO = BigDecimal.valueOf(2L);

    public static BigDecimal sqrt(BigDecimal x, MathContext mc) {
        BigDecimal g = x.divide(TWO, mc);
        boolean done = false;
        final int maxIterations = mc.getPrecision() + 1;
        for (int i = 0; !done && i < maxIterations; i++) {
            // r = (x/g + g) / 2
            BigDecimal r = x.divide(g, mc);
            r = r.add(g);
            r = r.divide(TWO, mc);
            done = r.equals(g);
            g = r;
        }
        return g;
    }
}
