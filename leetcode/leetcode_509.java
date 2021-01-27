package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_509 {
    //1. first with no memorization
    public int fib(int n){
        if(n<2) return n;
        return fib(n-1)+fib(n-2);
    }

    //2. with memorization to avoid duplicated computation
    private Map<Integer,Integer> map = new HashMap<>();
    public int fib2(int n){
        if(n<2) return n;
        if(map.containsKey(n)) return map.get(n);
        int result = fib(n-1) + fib(n-2);
        map.put(n,result);
        return result;
    }
}
