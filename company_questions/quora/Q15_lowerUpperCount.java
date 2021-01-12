package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Q15_lowerUpperCount {
    @Test
    public void test(){
        int[] A = {5,1,-8,2};
        int[] B = {1,2,-3,-10};
        System.out.println(lowerUpperCount2(A,B,1,20));
    }

    //overtime, O(n^2)
    public int lowerUpperCount(int[]A,int[]B,int lower, int upper){
        int count = 0;
        for(int a: A){
            for(int b: B){
                if(a*a+b*b>=lower&&a*a+b*b<=upper) {
                    System.out.println(a);
                    System.out.println(b);
                    System.out.println();
                    count++;
                };
            }
        }
        return count;
    }

    public int lowerUpperCount2(int[]A,int[]B,int lower,int upper){
        int count = 0;
        for (int i=0;i<A.length;i++) A[i] = A[i]*A[i];
        for (int i=0;i<B.length;i++) B[i] = B[i]*B[i];
        Arrays.sort(A);
        Arrays.sort(B);
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));
        for(int a: A){
            int count1 = 0;
            int lower_remain = lower - a;
            int upper_remain = upper - a;
            for(int b:B) {
                if (b >= lower_remain && b <= upper_remain) {
                    count1++;
                } else {
                    break;
                }
            }
            if(count1==0) break;
            count += count1;
        }
        return count;
    }
}
