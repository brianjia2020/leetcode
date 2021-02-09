package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_456 {

    public static void main(String[] args) {
        leetcode_456 instance = new leetcode_456();
        boolean pattern = instance.find132pattern(new int[]{3,1, 4, 2});
        System.out.println(pattern);

    }

    public boolean find132pattern(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num <= min){
                min = num;
            } else {
                while(!stack.isEmpty()){
                    if(stack.peek()>=num) break;
                    stack.pop();
                    if(stack.pop()>num) return true;
                }
                stack.push(num);
                stack.push(min);
            }
            System.out.println(stack);
        }
        return false;

    }

}
