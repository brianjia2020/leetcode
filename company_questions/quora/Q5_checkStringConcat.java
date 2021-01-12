package company_questions.quora;

import org.junit.Test;

public class Q5_checkStringConcat {
    @Test
    public void test(){
        String[] A = new String[]{"one","two","four"};
        String[] B = new String[]{"onetwo","onetwofour"};
        boolean b = checkConcat(A, B);
        System.out.println(b);
    }

    public boolean checkConcat(String[] A, String[] B){
        for(String str: B){
            for(String str2: A) {
                if(str.startsWith(str2)&&!str.equals("")) {
                    str = str.substring(str2.length());
//                    System.out.println(str);
                } else if (str.equals("")){
                    break;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
