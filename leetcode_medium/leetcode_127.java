package leetcode_medium;

import org.junit.Test;

import java.util.*;

public class leetcode_127 {
    @Test
    public void test(){

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i =0; i< size;i++){
                String cur = queue.remove();
                char[] words = cur.toCharArray();
                if (cur.equals(endWord)) return level+1;
                for (int j =0;j<cur.length();j++){
                    char temp = words[j];
                    for (char z='a';z<'z';z++){
                        words[j] = z;
                        String s = new String(words);
                        if(set.contains(s)) {
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                    words[j] = temp;
                }
            }
            level += 1;
        }

        return 0;
    }
}
