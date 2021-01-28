package explore.algorithm;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,2};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        int pivot = arr.length/2;
        int[] leftList = mergeSort(Arrays.copyOfRange(arr, 0, pivot));
        int[] rightList = mergeSort(Arrays.copyOfRange(arr, pivot, arr.length));
        return merge(leftList, rightList);
    }

    public static int[] merge(int[] leftList, int[] rightList){
        int l = 0;
        int r = 0;
        int w = 0;
        int[] res = new int[leftList.length+rightList.length];
        while(l<leftList.length&&r<rightList.length){
            if(leftList[l]<=rightList[r]){
                res[w] = leftList[l];
                l++;
            } else {
                res[w] = rightList[r];
                r++;
            }
            w++;
        }
        while(l<leftList.length) res[w++] = leftList[l++];
        while(r<rightList.length) res[w++] = rightList[r++];
        return res;
    }
}
