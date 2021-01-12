package company_questions.quora;

import org.junit.Test;

public class Q16_checkTrend {
    @Test
    public void test(){

    }

    public boolean isInTrend(int[]arr){
        if (arr==null||arr.length<3) return false;
        for(int i=0;i<arr.length-2;i++){
            if(arr[i]>=arr[i+1]&&arr[i+1]>=arr[i+2]) continue;
            if(arr[i]<=arr[i+1]&&arr[i+1]<=arr[i+2]) continue;
            return false;
        }
        return true;
    }
}
