package leetcode_medium;

import java.util.*;

public class leetcode_1010 {
    public static void main(String[] args) {
        int[] arr = new int[]{269,230,318,468,171,158,350,60,287,27,11,384,332,267,412,478,280,303,242,378,129,131,164,467,345,146,264,332,276,479,284,433,117,197,430,203,100,280,145,287,91,157,5,475,288,146,370,199,81,428,278,2,400,23,470,242,411,470,330,144,189,204,62,318,475,24,457,83,204,322,250,478,186,467,350,171,119,245,399,112,252,201,324,317,293,44,295,14,379,382,137,280,265,78,38,323,347,499,238,110,18,224,473,289,198,106,256,279,275,349,210,498,201,175,472,461,116,144,9,221,473};
        int[] arr2 = new int[]{30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(arr2));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        if(time==null||time.length==0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: time){
            int remainder = num%60;
            int other = (remainder==0)?0:60-remainder;
            res += map.getOrDefault(other,0);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return res;
    }
}
