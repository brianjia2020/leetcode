package company_questions;

import org.junit.Test;

import java.util.Arrays;

public class Q2 {
    @Test
    public void test(){
        String descognail = swap("descognail", new int[]{3, 2, 3, 1,1});
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
}
