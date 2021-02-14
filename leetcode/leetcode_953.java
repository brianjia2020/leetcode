package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_953 {
    public boolean isAlienSorted(String[] words, String order){
        Map<Character,Integer> mapping = new HashMap<>();
        for(int i=0;i<order.length();i++){
            mapping.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length;i++){
            if(compareOrder(words[i],words[i+1],mapping)){
                return false;
            }
        }
        return true;
    }

    public boolean compareOrder(String s1, String s2, Map<Character,Integer> mapping){
        int m = s1.length();
        int n = s2.length();
        int k = Math.min(m,n);
        for(int i=0;i<k;i++){
            if(mapping.get(s1.charAt(i))<mapping.get(s2.charAt(i))){
                return false;
            } else if (mapping.get(s1.charAt(i)).equals(mapping.get(s2.charAt(i)))){
            } else {
                return true;
            }
        }
        return m <= n;
    }

}
