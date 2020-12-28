package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_1089 {
    @Test
    public void test(){
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(arr));
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        if (arr==null||arr.length==0) return;
        int[] arr2 = new int[arr.length];
        int pos = 0;
        for(int i =0;i<arr.length;i++){
            if(pos<arr.length) {
                if (arr[i] == 0) {
                    arr2[pos] = 0;
                    if (pos<arr.length-1) {
                        pos++;
                        arr2[pos] = 0;
                    }
                } else {
                    arr2[pos] = arr[i];
                }
                pos++;
            } else {
                break;
            }
        }
        System.arraycopy(arr2, 0, arr, 0, arr.length);
    }
}
