package leetcode_easy;

import java.util.Arrays;

public class leetcode_1299 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[] {17,18,5,4,6,1})));
        System.out.println(Arrays.toString(replaceElements2(new int[] {17,18,5,4,6,1})));
    }

    public static int[] replaceElements(int [] arr){
        if (arr.length == 1) { return new int[]{-1};}

        for (int i =0; i < arr.length-1;i++){
            int max = arr[i+1];
            for(int j =i+1; j < arr.length;j++) {
                if (max <= arr[j]) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }

        arr[arr.length-1] = -1;
        return arr;
    }

    public static int[] replaceElements2(int [] arr){
        if (arr.length == 1) { return new int[]{-1};}
        int max_to_right = arr[arr.length-1];
        int temp = -1;
        for (int i = arr.length-2; i >= 0; i--){
            //System.out.println(arr[i]);
            temp = arr[i];
            arr[i] = max_to_right;
            if ( temp > max_to_right){
                max_to_right = temp;
            }
            //System.out.println(arr[i+1]);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}
