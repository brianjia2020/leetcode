package leetcode;

public class leetcode_69 {
    public int mySqrt(int x){
        if (x<2) return x;
        int left = 2;
        int right = x/2;
        int mid = 0;
        long num;
        while(left<=right){
            mid = left + (right-left)/2;
            num = (long) mid*mid;
            if(num==x) return mid;
            if(num>x) right = mid-1;
            else left = mid + 1;
        }
        return right;
    }
}
