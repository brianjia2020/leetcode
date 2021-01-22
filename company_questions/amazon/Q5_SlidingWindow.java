package company_questions.amazon;

import java.util.Arrays;

public class Q5_SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,6,8};
        int[] window = slidingWindow(arr, 3);
        System.out.println(Arrays.toString(window));
    }

    public static int[] slidingWindow(int[] arr, int size){
        //edge cases when the input arr is null or the window size is too big
        if(arr==null||arr.length<size) return arr;
        //define a res with size of length of arr plus 1 minus the window size
        int[] res = new int[arr.length-size+1];
        for(int i = 0;i<arr.length-size+1;i++){
            for(int j=i;j<i+size;j++){
                res[i] += arr[j];
            }
        }
        return res;
    }
}
