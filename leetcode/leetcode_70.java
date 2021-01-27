package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(map);
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static int climbStairs(int n){
        if(n==1) {
            map.put(1,1);
            return 1;
        }
        if(n==2) {
            map.put(2,2);
            return 2;
        }
        if(map.containsKey(n)) return map.get(n);
        int res = 0;
        for(int i=n-2;i<=n-1;i++){
            res += climbStairs(i);
        }
        if(!map.containsKey(n)) {
            map.put(n, res);
        }
        return res;
    }
}
