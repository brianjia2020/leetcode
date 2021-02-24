package company_questions.thomson_reuters;

import java.util.Arrays;

public class countNum {
    /**
     * Given two unsorted array, count how many elements in arr2 are smaller or equal to the element in arr1
     * arr1 = [1,2,3,4,7,9]
     * arr2 = [0,1,2,1,1,4]
     * output = [4,5,5,6,6,6]
     */
    public static void main(String[] args) {
        int[] arr1 = {5, 10, 2, 6, 1, 8, 6, 12};
        int[] arr2 = {6, 5, 11, 4, 2, 3, 7};
        countNum instance = new countNum();
        int[] nums = instance.findNum(arr1, arr2);
        System.out.println(Arrays.toString(nums));
    }

    public int[] findNum(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length];
        if(arr2==null||arr2.length==0) return res;
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            res[i] = binarySearch(arr1[i],arr2);
        }
        return res;
    }

    public int binarySearch(int num, int[] arr2){
        int l = 0;
        int r = arr2.length-1;
        while (l<r){
            int mid = l + (r-l)/2;
            if(arr2[mid]>num){
                r = mid;
            } else if (arr2[mid]<num){
                l = mid + 1;
            } else {
                while(arr2[mid]==num){
                    mid ++;
                }
                return mid;
            }
        }
        if(arr2[l]<= num) return l+1;
        return l;
    }
}
