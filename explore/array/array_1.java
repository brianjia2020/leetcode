package explore.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class array_1 {

    @Test
    public void test(){
        int[] arr = new int[]{-2,0,10,-19,4,6,-8};
        boolean b = checkIfExist(arr);
        System.out.println(b);
    }

    public boolean checkIfExist(int[] arr){
        Set<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for(int num:arr){
            if(num!=0) set.add(num);
            if(num==0) zeroCount++;
        }
        if (zeroCount!=0&&zeroCount%2==0) return true;
        for(int num: arr){
            if(set.contains(num*2)){
                return true;
            }
        }
        return false;
    }
}
