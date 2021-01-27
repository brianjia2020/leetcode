package leetcode;

public class leetcode_374 {
    public int guessNumber(int n){
        int low = 1;
        int high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            int res = guess(mid);
            if(res==0){
                return mid;
            } else if (res == -1){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int guess(int n){
        int target = 60;
        if(n<target) return -1;
        if(n>target) return 1;
        return 0;
    }
}
