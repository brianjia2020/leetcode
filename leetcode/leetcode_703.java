package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_703 {
    public static void main(String[] args) {

    }
}

class KthLargest{

    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums){
        this.k = k;
        queue = new PriorityQueue<>(k);
        for(int num: nums){
            add(num);
        }
    }

    public int add(int val){
        if(k>queue.size()){
            queue.offer(val);
        } else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

}