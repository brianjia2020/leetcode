package leetcode_easy;

import org.junit.Test;

public class leetcode_326 {
    @Test
    public void test(){
        boolean result = isPowerOfThree(0);
        System.out.println(result);
    }

    public boolean isPowerOfThree(int n){

        if (n==0) return false;
        while(n%3==0){
            n = n/3;
        }
        return n ==1;
    }

}
