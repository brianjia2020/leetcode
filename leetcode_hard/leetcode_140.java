package leetcode_hard;

import org.junit.Test;

import java.util.*;

public class leetcode_140 {
    @Test
    public void test(){
        String s = "catsanddog";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> strings = wordBreak(s, wordDict);
        System.out.println(strings);
    }

    Map<String,List<String>> memory = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, set);
    }

    public List<String> dfs(String s, Set<String> set){
        if(memory.containsKey(s)) return memory.get(s);

        List<String> result = new ArrayList<>();

        if (set.contains(s)) {
            result.add(s);
        }

        for(int i = 0; i < s.length(); i++){
            String right = s.substring(i);
            if (!set.contains(right)) continue;

            String left = s.substring(0,i);
            List<String> leftResult = append(dfs(left, set),right);

            result.addAll(leftResult);
        }


        memory.put(s,result);
        return memory.get(s);
    }

    private List<String> append(List<String> dfs, String word) {
        List<String> result = new ArrayList<>();
        for (String prefix: dfs){
            prefix += " "+word;
            result.add(prefix);
        }
        return result;
    }
}
