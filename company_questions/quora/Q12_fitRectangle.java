package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;

public class Q12_fitRectangle {
    @Test
    public void test(){
        int[][] arr = {{3,4},{5,3},{1,2}};
        int width = 3;
        int length = 5;
        System.out.println(fitRectangle(arr,3,5));
    }

    public boolean fitRectangle(int[][] arr,int width, int length){
        for(int i=0;i<arr.length;i++){
            if (arr[i][0]<=width && arr[i][1]<=length) continue;
            if (arr[i][0]<=length && arr[i][1]<= width) continue;
            System.out.println(Arrays.toString(arr[i]));
            return false;
        }
        return true;
    }
}
