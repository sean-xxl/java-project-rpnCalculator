public interface Operator {
    String INPUT_NUMBER = "number";
    String ADDITION = "+";
    String SUBTRACTION = "-";
    String MULTIPLICATION = "*";
    String DIVISION = "/";
    String SQRT = "sqrt";
    String UNDO = "undo";
    String CLEAR = "clear";
    String EXIT = "exit";

    /**
     * Get operator string
     * */
    String operatorString();
}
