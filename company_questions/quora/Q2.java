package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;

public class Q2 {
    @Test
    public void test(){
        String descognail = swap2("descognail", new int[]{3, 2, 3, 1,1});
        System.out.println(descognail);
    }

    public String swap(String s,int [] nums){
        String [] temp = new String[nums.length];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            temp[i] = s.substring(count,count+nums[i]);
            count = count+nums[i];
        }
        StringBuilder res = new StringBuilder();
        for(int i=1;i<temp.length;i+=2){
            res.append(temp[i]);
            res.append(temp[i-1]);
        }
        if(temp.length%2==1) res.append(temp[temp.length-1]);
        return res.toString();
    }

    public String swap2(String s, int[] nums){
        String[] strs = new String[nums.length];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            strs[i] = s.substring(count,count+nums[i]);
            count += nums[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<nums.length;i+=2){
            sb.append(strs[i]);
            sb.append(strs[i-1]);
        }
        if(nums.length%2==1) sb.append(strs[strs.length-1]);
        return sb.toString();
    }
}
