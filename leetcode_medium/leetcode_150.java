package leetcode_medium;

import org.junit.Test;

import java.util.Stack;

public class leetcode_150 {
    @Test
    public void test(){
        String[] inputs = new String[]{"4","13","5","/","+"};
        int i = evalRPN(inputs);
        System.out.println(i);
    }
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack();
        for (String token: tokens){
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    int tmp = stack.pop();
                    stack.push(stack.pop() - tmp);
                    break;
                case "/":
                    int demo= stack.pop();
                    stack.push(stack.pop() / demo);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
