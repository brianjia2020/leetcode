package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leetcode_8 {
    public static void main(String[] args) {

    }

    public int myAtoi(String s){
        //edge cases:
        if(s==null) return 0;
        s = s.trim();
        int sign = 1;
        int index = 0;
        char c = s.charAt(index);
        if(c=='-'){
            sign = -1;
            index++;
        } else if(c=='+'){
            sign = 1;
            index++;
        }

        long sum = 0;
        for(int i= index;i<s.length();i++){
            c = s.charAt(i);
            if(!Character.isDigit(c)){
                return (int) sum*sign;
            }
            sum = sum*10 + (c-'0');
            if(sign==1&&sum>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign==-1&&(-1)*sum<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sign*sum);
    }
}
