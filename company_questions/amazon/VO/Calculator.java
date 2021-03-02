package company_questions.amazon.VO;

import java.util.Stack;

public class Calculator {

    //leetcode 224 (2+3-4)+1
    public int calculate1(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

    //leetcode 227 2+3*4
    public int calculate2(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;
        //solution:
        //1. int sum, int number, char sign, stack to store temp result
        //2. loop over each char of s
        //3. if the char is digit, we accumulate that to number
        //4. if the char is ' ', we skip
        //5. if the char is '+-' stack.push the number/-1*number
        //6. if the char is '*/' stack.push the (stack.pop() */ number)
        //7. get all nums from stack, return sum

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int number = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10 + (c-'0');
            }

            if(c!=' ' && !Character.isDigit(c) || i==s.length()-1){
                if(sign == '+'){
                    stack.push(number);
                } else if (sign == '-'){
                    stack.push(-number);
                } else if (sign == '*'){
                    stack.push(stack.pop()*number);
                } else if (sign == '/'){
                    stack.push(stack.pop()/number);
                }
                sign = c;
                number = 0;
            }
        }

        for(int num: stack) sum += num;
        return sum;
    }

    //leetcode 772 2+(2+2*3)
    public int calculate3(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;
        //solution:
        //1. int sum, int number, char sign, stack to store temp result
        //2. loop over each char of s
        //3. if the char is digit, we accumulate that to number
        //4. if the char is ' ', we skip
        //5. if the char is '+-' stack.push the number/-1*number
        //6. if the char is '*/' stack.push the (stack.pop() */ number)
        //7. get all nums from stack, return sum

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int number = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10 + (c-'0');
            }

            if(c=='('){
                int count = 1;
                int j = i + 1;
                while(count>0){
                    if(s.charAt(j)=='('){
                        count += 1;
                    } else if (s.charAt(j)==')'){
                        count--;
                    }
                    j++;
                }
                number = calculate2(s.substring(i+1,j));
                i=j-1;
            }

            if(c!=' ' && !Character.isDigit(c) || i==s.length()-1){
                if(sign == '+'){
                    stack.push(number);
                } else if (sign == '-'){
                    stack.push(-number);
                } else if (sign == '*'){
                    stack.push(stack.pop()*number);
                } else if (sign == '/'){
                    stack.push(stack.pop()/number);
                }
                sign = c;
                number = 0;
            }
        }

        for(int num: stack) sum += num;
        return sum;
    }

}
