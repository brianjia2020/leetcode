package company_questions.quora;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q10_AlternatingSum {
    @Test
    public void test(){
        System.out.println(alternatingSum(123));
        System.out.println(alternatingSum2(123));
    }

    public int alternatingSum(int num){
        if (num<10) return num;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while(num!=0){
            stack.push(num%10);
            num /= 10;
        }
        boolean isPos = true;
        while(!stack.empty()){
            int pop = stack.pop();
            res += isPos ? pop:-1*pop;
            isPos = !isPos;
        }
        return res;
    }

    public int alternatingSum2(int num){
        if (num<10) return num;
        int res = 0;
        boolean isPos = true;
        while(num!=0){
            res += isPos?num%10:-1*num%10;
            isPos = !isPos;
            num /= 10;
        }
        return isPos?(-1)*res:res;
    }
}
