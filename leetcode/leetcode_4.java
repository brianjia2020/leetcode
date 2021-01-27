package leetcode;

import org.junit.Test;

public class leetcode_4 {
    @Test
    public void test(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0;
        int start2 = 0;
        int pos = 0;
        int[] newArray = new int[nums1.length+nums2.length];
        while (start1 < nums1.length && start2 < nums2.length){
            if (nums1[start1] <= nums2[start2]){
                newArray[pos++] = nums1[start1++];
            } else {
                newArray[pos++] = nums2[start2++];
            }
        }

        while (start1 < nums1.length){
            newArray[pos++] = nums1[start1++];
        }
        while (start2 < nums2.length){
            newArray[pos++] = nums2[start2++];
        }
        if (newArray.length%2==0){
            return (newArray[newArray.length/2-1] + newArray[newArray.length/2])/2.0;
        } else{
            return newArray[newArray.length/2];
        }
    }

}
