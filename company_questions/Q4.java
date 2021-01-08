package company_questions;

public class Q4 {
    public int findEven(String[] arr){
        int count = 0;
        for(String str: arr){
            if(str.length()%2==0) count++;
        }
        return count;
    }
}
