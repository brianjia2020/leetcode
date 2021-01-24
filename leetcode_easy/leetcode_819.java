package leetcode_easy;

import java.util.*;

public class leetcode_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> times = new HashMap<>();
        char[] para = paragraph.toCharArray();
        StringBuilder curWord = new StringBuilder();
        Set<String> bans = new HashSet<>(Arrays.asList(banned));

        int maximal = 0;
        String ans = "";
        for (int i = 0; i < para.length; i ++) {// n * O(1)
            if (Character.isAlphabetic(para[i]))
                curWord.append(Character.toLowerCase(para[i]));

            if (!Character.isAlphabetic(para[i]) || i == para.length - 1) {
                if (curWord.length() > 0) {
                    String cur = curWord.toString();// O(n) in total for all words
                    if (!bans.contains(cur)) {
                        times.put(cur, times.getOrDefault(cur, 0) + 1);
                        if (times.get(cur) > maximal) {
                            maximal = times.get(cur);
                            ans = cur;
                        }
                    }
                    curWord = new StringBuilder();
                }
            }
        }

        return ans;
    }
}
