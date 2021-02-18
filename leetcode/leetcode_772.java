package leetcode;

import java.util.Stack;

public class leetcode_772 {

    public static void main(String[] args) {
        String s = "6-4/2";
        System.out.println(new leetcode_772().calculate(s));
    }

    int index  = 0;
    public int calculate(String s){
        Stack<String> stack = new Stack<>();
        String curStr = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(curStr);
                curStr = "";
            } else if(s.charAt(i)==')'){
                System.out.println(curStr);
                int curRes = eval(curStr);
                System.out.println(curRes);
                curStr = stack.peek() + curRes;
                System.out.println(curStr);
                stack.pop();
            } else {
                curStr += s.charAt(i);
            }
        }

        return eval(curStr);
    }

    public int eval(String temp){
        int res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for(int i=0;i<temp.length();i++){
            if(Character.isDigit(temp.charAt(i))){
                cur = temp.charAt(i)-'0';
                while(i+1<temp.length()&&Character.isDigit(temp.charAt(i+1))){
                    cur = cur*10+(temp.charAt(i+1)-'0');
                    i++;
                }
            }

            if(!Character.isDigit(temp.charAt(i))||i==temp.length()-1){
                System.out.println(temp.charAt(i) + " " + sign);
                if(sign=='+') stack.push(cur);
                else if(sign=='-') stack.push(-1*cur);
                else if(sign=='*') stack.push(stack.pop()*cur);
                else if(sign=='/') stack.push(stack.pop()/cur);

                if(sign=='+' || sign=='-') sign = sign==temp.charAt(i)?'+':'-';
                else sign = temp.charAt(i);
                cur = 0;

            }

        }
        System.out.println(stack);
        for(int num: stack) res += num;
        return res;
    }
}
