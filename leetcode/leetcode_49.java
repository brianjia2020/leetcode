package leetcode;

import java.util.*;

public class leetcode_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String head = String.valueOf(chars);
            if(!map.containsKey((head))) map.put(head,new ArrayList<>());
            map.get(head).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
