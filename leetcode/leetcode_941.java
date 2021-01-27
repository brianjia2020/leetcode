package leetcode;

public class leetcode_941 {
    public boolean validMountainArray(int[] arr){
        if(arr==null||arr.length<3) return false;
        int pos = 0;
        while(arr[pos]<arr[pos+1]&&pos<arr.length-2){
            pos++;
        };
        if(pos==0) return false;
        while(arr[pos+1]>arr[pos]&&pos<arr.length-1){
            pos++;
        }
        return pos == arr.length - 1&& arr[pos]>arr[pos+1];
    }
}
