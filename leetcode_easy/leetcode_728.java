package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<Integer>();
        for(int i = left; i <=right; i++){
            if(isSelfDivingNumbers(i)){
                results.add(i);
            }
        }
        return results;
    }

    public static boolean isSelfDivingNumbers(int input){
        boolean result = true;
        String input_string = Integer.toString(input);
        for(char number: input_string.toCharArray()){
            int divider = Character.getNumericValue(number);
            if (divider == 0){
                result = false;
                break;
            }
            if (input % divider != 0) {
                result = false;
                break;
            }

        }
        return result;
    }
}
