package leetcode_hard;

public class leetcode_410 {
    public int splitArray(int[] nums, int m) {
        int lo=0,hi=0;int ans=0,mid=0;
        for(int i=0;i<nums.length;i++){
            lo=Math.max(lo,nums[i]);
            hi+=nums[i];
        }
        while(hi-lo>1){
            mid=(hi-lo)/2+lo;
            if(isPos(mid,nums,m)){
                ans=Math.min(ans,mid);
                hi=mid;
            }
            else
                lo=mid;
        }
        if(isPos(lo,nums,m))
            ans=lo;
        else if(isPos(hi,nums,m))
            ans=hi;
        return ans;
    }
    public static boolean isPos(int sumDecided,int nums[],int div){
        int sumCur=0;
        int divCount=1;
        for(int i=0;i<nums.length;i++){
            sumCur+=nums[i];
            if(sumCur>sumDecided){
                divCount++;
                sumCur=nums[i];
            }
        }
        if(divCount<=div)
            return true;
        else
            return false;
    }
}
