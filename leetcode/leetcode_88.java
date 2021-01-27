package leetcode;

public class leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] arr = new int[m+n];
        int i =0,j=0,pos=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                arr[pos]=nums1[i];
                i++;
            } else {
                arr[pos]=nums2[j];
                j++;
            }
            pos++;
        }
        while(i<m){
            arr[pos]=nums1[i];
            i++;
            pos++;
        }
        while(j<n){
            arr[pos]=nums2[j];
            j++;
            pos++;
        }
        System.arraycopy(arr,0,nums1,0,arr.length);
    }
}
