package company_questions.amazon.OA;

import java.util.Arrays;

public class Q15_reorderLogFile {
    public static String[] reorderLogFiles(String[] logs){
        Arrays.sort(logs,(o1,o2)->{
            int split1 = o1.indexOf(" ");
            int split2 = o2.indexOf(" ");
            boolean isDigit1 = Character.isDigit(o1.charAt(split1+1));
            boolean isDigit2 = Character.isDigit(o2.charAt(split2+1));
            if(isDigit1&&isDigit2){
                return 0;
            } else if (isDigit1){
                return 1;
            } else if (isDigit2){
                return -1;
            } else {
                String word1 = o1.substring(split1+1);
                String word2 = o2.substring(split2+1);
                int res = word1.compareTo(word2);
                if(res==0){
                    res = o1.substring(0,split1).compareTo(o2.substring(0,split2));
                }
                return res;
            }
        });
        return logs;
    }
}
