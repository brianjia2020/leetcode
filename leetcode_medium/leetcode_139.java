package leetcode_medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_139 {
    boolean result = false;

    @Test
    public void test(){
        String s = "catsanddog";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        boolean strings = wordBreak(s, wordDict);
        System.out.println(strings);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s,set,0,new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] mem){
        if(start == s.length()) return true;
        if (mem[start] != null) return mem[start];

        for(int end = start + 1; end <= s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && wordBreak(s,wordDict,end,mem)){
                return mem[start] = true;
            }
        }

        return mem[start] = false;

    }


}
