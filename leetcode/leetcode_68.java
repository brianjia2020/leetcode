package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_68 {
    public static void main(String[] args) {
        String[] res = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        leetcode_68 example = new leetcode_68();
        List<String> strings = example.fullJustify(res, 16);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth){
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while(index<n){
            int totalChars = words[index].length();
            int last = index+1;
            while(last<n){
                if(totalChars+words[last].length()+1>maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int gap = last - index - 1;
            StringBuilder sb = new StringBuilder();
            if(last == n || gap == 0){
                for(int i= index;i<last;i++){
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                while(sb.length()<maxWidth) sb.append(" ");
            } else {
                int spaces = (maxWidth-totalChars)/gap;
                int rest = (maxWidth-totalChars)%gap;
                for(int i = index;i<last-1;i++){
                    sb.append(words[i]);
                    sb.append(' ');
                    for(int j=0;j<spaces+ (i-index<rest?1:0);j++){
                        sb.append(' ');
                    }
                }
                sb.append(words[last-1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }


}
