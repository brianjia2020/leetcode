package company_questions.quora;

import org.junit.Test;

public class Q14_countEvenString {
    @Test
    public void test(){
        String[] arr = new String[]{"aa", "bbb", "cc"};
        System.out.println(countEvenString(arr));
    }

    public int countEvenString(String[] arr){
        int count = 0;
        for(String str: arr) {
            if(str.length()%2==0) count++;
        }
        return count;
    }
}
