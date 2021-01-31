package leetcode;

public class leetcode_52 {
    public static void main(String[] args) {

    }

    int count;
    public int totalQueens(int n){
        int [] arr = new int[n];
        helper(arr,0,n);
        return count;
    }

    public void helper(int[] arr, int m, int n){
        if(m==n) {
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            arr[m] = i;
            if(judge(arr,m)){
                helper(arr,m+1,n);
            }
        }
    }



    public boolean judge(int[] arr, int m){
        for(int i=0;i<m;i++){
            if(arr[i]==arr[m]||Math.abs(arr[i]-arr[m])==Math.abs(i-m)){
                return false;
            }
        }
        return true;
    }
}
