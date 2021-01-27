package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_692 {
    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k =2;
        System.out.println(topKFrequent(words,k));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String word: words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            } else {
                map.put(word,1);
                res.add(word);
            }
        }
        res.sort((o1,o2)->{
            if(map.get(o1).equals(map.get(o2))) return o1.compareTo(o2);
            else return Integer.compare(map.get(o2),map.get(o1));
        });

        return res.subList(0,k);
    }
}
