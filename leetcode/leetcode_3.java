package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new leetcode_3().lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring2(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;
        //solution:
        //a map to record the position of each char's latest position
        //if it is not in the map, it's new and I update the max and map
        //if it is in the map, the latest temp string is j-i+1 and j = map.get(i) + 1
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-j+1);
            System.out.println("j="+j+"i="+i+"max="+max);
            System.out.println(map);
        }
        return max;
    }

    //O(n^2)
    public int lengthOfLongestSubstring3(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;
        //solution:
        //to enumerate all possibilities at each position
        //then compare the string length with max
        //return the max
        int max = 0;
        for(int i = 0;i<s.length();i++){
            int j = i+1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            while(j<s.length()&&!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }

            max = Math.max(max,set.size());
        }
        return max;

    }

    public int lengthOfLongestSubstring(String s){
        if(s==null||s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,j-i+1);
        }
        System.out.println(map);
        return max;
    }
}
