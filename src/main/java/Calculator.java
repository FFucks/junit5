public class Calculator {

    public Integer divide(Integer first, Integer second) {
        if (first == 0) {
            throw new ArithmeticException("No number can be divided by zero");
        }
        return first / second;
    }
}
