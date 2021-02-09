package company_questions.amazon.OA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q36_RoboticsChallenge {
    public static int callPoints(String[] ops){
        Stack<Integer> queue = new Stack<>();
        int sum = 0;
        for(String op: ops){
            if(op.equals("C")){
                Integer num = queue.pop();
                sum -= num;
            } else if(op.equals("D")){
                int num = queue.peek()*2;
                queue.add(num);
                sum += num;
            } else if (op.equals("+")){
                Integer lastNum = queue.pop();
                Integer secondLastNum = queue.peek();
                queue.add(lastNum);
                queue.add(lastNum+secondLastNum);
                sum += lastNum+secondLastNum;
            } else {
                Integer num = Integer.parseInt(op);
                sum += num;
                queue.add(num);
            }
        }
        return sum;

    }
}
