package company_questions;

import org.junit.Test;

public class Q1 {
    @Test
    public void test1(){
        int i = sumOfProduct(123456);
        System.out.println(i);
    }

    public int sumOfProduct(int num){
        int product = 1;
        int sum = 0;
        while(num>0){
            product *= (num%10);
            sum += num%10;
            num = num/10;
        }
        System.out.println(product);
        System.out.println(sum);
        return product-sum;
    }
}
