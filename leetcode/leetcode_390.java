package leetcode;

import org.junit.Test;

public class leetcode_390 {
    @Test
    public void test(){
        int x = 1;
        System.out.println(x>>1);
    }

    public int lastRemaining(int n){
        return n == 1 ? 1 : (n / 2 - lastRemaining(n / 2) + 1) * 2;
    }

    private int leftright(int n) {
        if(n==1) return 1;
        if(n<=4) return 2;
        return 2*rightleft(n>>1);
    }

    private int rightleft(int i) {
        return 0;
    }
}
