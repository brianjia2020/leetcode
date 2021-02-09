package leetcode;

public class leetcode_367 {
    public boolean isPerfectSquare(int num){
        if(num<2) return true;
        int left = 2;
        int right = num/2;
        while(left<=right){
            long mid = left + (right-left)/2;
            long target = mid*mid;
            if(target==num){
                return true;
            } else if(target<num){
                left = (int) mid+1;
            } else {
                right = (int) mid-1;
            }
        }
        return false;
    }
}
