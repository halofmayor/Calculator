import java.util.Stack;

/**
 * Evaluates expressions written in postfix (Reverse Polish Notation).
 */
public class PostfixCalculator {
    /**
     * Evaluates a postfix expression.
     *
     * @param postfix postfix expression (tokens separated by spaces)
     * @return result of evaluation
     */
    public static double PostFixCalculator(String postfix) {
        String[] expression = postfix.split(" ");
        Stack<Double> operands = new Stack<>();

        for (String current : expression) {
            try {
                // Try to parse as number
                double num = Double.parseDouble(current);
                operands.push(num);
            } catch (NumberFormatException e) {
                if (operands.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: missing operands for " + current);
                }
                //It must be an operator
                double b = operands.pop();
                double a = operands.pop();

                switch (current) {
                    case "+":
                        operands.push(a + b);
                        break;
                    case "-":
                        operands.push(a - b);
                        break;
                    case "*":
                        operands.push(a * b);
                        break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        operands.push(a / b);
                        break;
                    default: throw new IllegalArgumentException("Operator not supported: " + current);
                }
            }
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: extra operands");
        }
        return operands.pop();
    }
}
