import java.math.BigDecimal;

public class Node {
    public enum Type {
        NUMBER,
        OPERATOR
    }

    private Type _type;
    private String _operator;
    private BigDecimal _number;

    public Node(Type type, String operator, BigDecimal number) {
        _type = type;
        _operator = operator;
        _number = number;
    }

    public Type getType() {
        return _type;
    }

    public String getOperator() {
        return _operator;
    }

    public BigDecimal getNumber() {
        return _number;
    }
}
