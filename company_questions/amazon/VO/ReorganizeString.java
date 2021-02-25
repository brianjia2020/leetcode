package company_questions.amazon.VO;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            int count = map.getOrDefault(c,0) + 1;
            if(count>(s.length()+1)/2) return "";
            map.put(c,count);
        }
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
        for(char c: map.keySet()) queue.add(new int[]{c,map.get(c)});
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            if(sb.length()==0|| first[0]!=sb.charAt(sb.length()-1)){
                sb.append((char) first[0]);
                first[1]--;
                if(first[1]>0) queue.add(first);
            } else {
                int[] second = queue.poll();
                sb.append((char) second[0]);
                second[1]--;
                if(second[1]>0) queue.add(second);
                queue.add(first);
            }
        }

        return sb.toString();
    }
}
