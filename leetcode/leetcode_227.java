package leetcode;

import java.time.temporal.ChronoField;
import java.util.Stack;

public class leetcode_227 {

    //similar to 224
    public int calculate(String s) {
        //edge cases:
        if (s == null || s.length() == 0) return 0;

        //solution:
        int res = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else if (sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int temp : stack) {
            res += temp;
        }

        return res;
    }
}
