package company_questions.amazon.OA;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q24_MultiprocessorSystem {
    public static void main(String[] args) {
        int num =5;
        int processes = 15;
        int[] abilities = new int[]{3,1,7,2,4};
        System.out.println(getProcessingTime(num,abilities,processes));
    }

    public static int getProcessingTime(int numOfProcessor, int[] abilities, int processes){
        if(abilities==null||abilities.length==0) return -1;
        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int ability: abilities) queue.add(ability);
        int res = 0;
        while (processes>0&&!queue.isEmpty()){
            System.out.println(queue);
            Integer poll = queue.poll();
            if(poll==0) return -1;
            else {
                processes -= poll;
                queue.add(poll/2);
                res++;
            }
        }
        return res;
    }
}
