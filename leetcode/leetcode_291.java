package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_291 {
    public boolean wordPatternMatch(String pattern, String s){
        Map<Character,String> map = new HashMap<>();
        return dfs(map,pattern,s);
    }

    public boolean dfs(Map<Character, String> map, String pattern, String str){
        if(pattern.length()==0) return str.length()==0;
        char c = pattern.charAt(0);
        if(map.containsKey(c)){
            if(!str.startsWith(map.get(c))) return false;
            else return dfs(map,pattern.substring(1),str.substring(map.get(c).length()));
        }
        for(int i=0;i<str.length();i++){
            String word = str.substring(0,i+1);
            if(map.containsValue(word)) continue;
            map.put(c,word);
            if (dfs(map,pattern.substring(1),str.substring(i+1))) return true;
            map.remove(c);
        }
        return false;
    }
}
