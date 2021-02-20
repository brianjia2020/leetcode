package company_questions.amazon.VO;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;

        //solution:
        //1. have a method to map the each char to int, similar to a map, O(1)
        //2. loop over each char in s, O(n)
        //      compare the i element to i-1.
        //      if i is bigger, I need to subtract the map(i-1)*2
        //      else I will add up the value of map(i).
        int res = 0;
        res += map(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(map(s.charAt(i))>map(s.charAt(i-1))&&res>0){
                res += map(s.charAt(i)) - 2*map(s.charAt(i-1));
            } else {
                res += map(s.charAt(i));
            }
        }
        return res;
    }

    public int map(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
