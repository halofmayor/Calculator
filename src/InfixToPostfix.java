import java.util.Stack;

/**
 * Class to convert infix expressions
 * into postfix notation (Reverse Polish Notation).
 */
public class InfixToPostfix {
    /**
     * Returns the precedence of a given operator.
     * Higher value means higher precedence.
     */
    static int prec(char c) {
        if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    /**
     * Converts an infix expression to postfix (RPN).
     *
     * @param s infix expression
     * @return postfix expression
     */
    public static String InfixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                //Append the full number.
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    res.append(s.charAt(i));
                    i++;
                }

                res.append(' ');
                i--;

                //Handle implicit multiplication.
                if (i + 1 < s.length() && s.charAt(i + 1) == '(') {
                    st.push('*');
                }
            }

            else if (c == '(') {
                st.push(c);
            } else if (c == ')'){
                //Pop until matching '('
                while (!st.isEmpty() && st.peek() != '('){
                    res.append(st.pop()).append(' ');
                }
                // discard '('
                if (!st.isEmpty()){
                    st.pop();
                }
            }

            else {
                // Pop operators with higher or equal precedence
                while (!st.isEmpty() && st.peek() != '(' && prec(st.peek()) >= prec(c)){
                    res.append(st.pop()).append(' ');
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop()).append(' ');
        }

        return res.toString().trim();
    }
}
