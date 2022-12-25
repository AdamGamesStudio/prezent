public class Manager {
    public static final int EQUALS = 0, DIVIDE = 1, MULTIPLY = 2, MINUS = 3, PLUS = 4, CLEAR = 5;

    public long n1;
    public long n2;

    public int activeOperators = 0;

    public int o1 = 0;

    public boolean canPressOperator = false;
    public boolean operator = false;

    public void clear() {
        n1 = 0;
        n2 = 0;
        activeOperators = 0;
        o1 = 0;
        canPressOperator = false;
        operator = false;
    }
}
