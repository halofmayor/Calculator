public class Calculator {
    public static void main(String[] args) {
        String incorrect = "2/2(1+1)";
        String correct = "2/2*(1+1)";
        System.out.println(PostfixCalculator.PostFixCalculator(InfixToPostfix.InfixToPostfix(incorrect)));
        System.out.println(PostfixCalculator.PostFixCalculator(InfixToPostfix.InfixToPostfix(correct)));
    }
}
