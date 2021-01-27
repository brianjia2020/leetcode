package leetcode;

import org.junit.Test;

public class leetcode_202 {
    @Test
    public void test(){
        System.out.println(isHappy(19012312));
    }
    public boolean isHappy(int n) {
        return calcOperation(n);
    }

    public boolean calcOperation(int n){
        String num = String.valueOf(n);
        int result = 0;
        for (char c: num.toCharArray()){
            result += Character.getNumericValue(c) * Character.getNumericValue(c);
        }
//        System.out.println(result);
        if (result == 1){
            return true;
        }

        if (result == 4){
            return false;
        }

        return calcOperation(result);
    }
}
