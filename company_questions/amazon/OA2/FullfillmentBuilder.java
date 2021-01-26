package company_questions.amazon.OA2;

import java.util.*;

public class FullfillmentBuilder {

    public static void main(String[] args) {
        List<Integer> parts = new ArrayList<>();
        parts.add(4);
        parts.add(8);
        parts.add(10);
        parts.add(6);
        System.out.println(getBestTime(parts));
    }

    public static int getBestTime(List<Integer> parts){
        //edge cases
        if(parts==null||parts.size()==0) return 0;

        //O(log n)
        Queue<Integer> queue = new PriorityQueue<>(parts);

//        parts.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });

        int res = 0;
        while(queue.size()>1){
            Integer firstSmall = queue.poll();
            Integer secondSmall = queue.poll();
            res += (firstSmall+secondSmall);
            queue.add((firstSmall+secondSmall));
        }
        return res;
    }

}
