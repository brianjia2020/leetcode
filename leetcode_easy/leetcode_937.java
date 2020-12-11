package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class leetcode_937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //find the split " " between identifier and words
                int split1 = o1.indexOf(" ");
                int split2 = o2.indexOf(" ");

                boolean isDigit1 = Character.isDigit(o1.charAt(split1+1));
                boolean isDigit2 = Character.isDigit(o2.charAt(split2+1));

                if(isDigit1 && isDigit2){
                    return 0;
                } else if (isDigit1 && !isDigit2){
                    return 1;
                } else if (!isDigit1 && isDigit2){
                    return -1;
                } else {
                    String word1 = o1.substring(split1+1);
                    String word2 = o2.substring(split2+1);
                    int res = word1.compareTo(word2);
                    if (res == 0) {
                        String id1 = o1.substring(0, split1);
                        String id2 = o2.substring(0, split2);
                        res = id1.compareTo(id2);
                    }
                    return res;
                }
            }
        });
        return logs;
    }
}
