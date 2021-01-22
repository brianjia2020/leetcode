package company_questions.amazon;

import java.util.Arrays;

public class Q1_GetMaxValue {
    public static void main(String[] args) {
        int[] arr2 = new int[]{2,4,7,3};
        System.out.println(getMaxValue(arr2));
    }

    public static int getMaxValue(int[] arr){
        //edge cases
        if(arr==null||arr.length==0) return 0;
        if(arr.length==1) return arr[0];
        Arrays.sort(arr);
        arr[0] =1;
        for(int i =1;i<arr.length;i++){
            if ((arr[i]-arr[i-1])>1){
                arr[i] = arr[i-1] + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-1];
    }


}
