package company_questions.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q39_OptimizeBoxWeight {
    public static void main(String[] args) {
        System.out.println(getAnswer(5,new int[]{1,2,5,8,4}));
    }
    public static List<Integer> getAnswer(int n, int[] arr){
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
        int sum = 0;
        for(int num: arr){
            queue.add(num);
            sum+=num;
        }
        List<Integer> res = new ArrayList<>();
        int sumA = 0;
        while(sumA<=sum/2&&!queue.isEmpty()){
            int curMax = queue.poll();
            sumA += curMax;
            res.add(curMax);
        }
        return res;
    }
}
