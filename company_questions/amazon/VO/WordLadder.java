package company_questions.amazon.VO;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curWord = queue.poll();
                char[] arr = curWord.toCharArray();
                if(curWord.equals(endWord)) return level+1;
                for(int j=0;j<curWord.length();j++){
                    char temp = arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j] = c;
                        String s = new String(arr);
                        if(set.contains(s)){
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                    arr[j] = temp;
                }
            }
            level++;
        }

        return 0;
    }


    //wrong!!!!
    public List<List<String>> ladderLength2(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        List<List<String>> res = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                List<String> tempRes = new LinkedList<>();
                String curWord = queue.poll();
                char[] arr = curWord.toCharArray();
                if(curWord.equals(endWord)) {
                    res.add(new LinkedList<>(tempRes));
                }
                for(int j=0;j<curWord.length();j++){
                    char temp = arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j] = c;
                        String s = new String(arr);
                        if(set.contains(s)){
                            queue.add(s);
                            set.remove(s);
                            tempRes.add(s);
                        }
                    }
                    arr[j] = temp;
                }
            }
        }
        return res;
    }


}
