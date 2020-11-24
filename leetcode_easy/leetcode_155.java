package leetcode_easy;

import org.junit.Test;

import java.util.ArrayList;

public class leetcode_155 {
    @Test
    public void test(){

    }
}

class MinStack {
    ArrayList<Integer> collection = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        collection.add(0,x);
    }

    public void pop() {
        collection.remove(0);
    }

    public int top() {
        return collection.get(0);
    }

    public int getMin() {
        int min =  Integer.MAX_VALUE;
        for (Integer num :collection){
            if (num < min){
                min = num;
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
