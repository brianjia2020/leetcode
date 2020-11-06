package leetcode_medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {

    @Test
    public void test(){
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        permute(list,"",n,0,0);
        return list;
    }

    public void permute(List<String> result, String sb, int n, int open, int close){
        if(sb.length() == 2*n){
            result.add(sb);
            return;
        }

        if(open < n) {
            permute(result, sb + "(", n,open + 1, close);
        }
        if(close < open) {
            permute(result, sb + ")", n,open, close + 1);
        }
    }
}
