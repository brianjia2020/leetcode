package company_questions.amazon;

import java.util.Arrays;

public class Q33_ShoppingOptions {

    public static void main(String[] args) {
        int budget = 10;
        int[] jeans = new int[]{2,3};
        int[] shoes = new int[]{4};
        int[] skirts = new int[]{2,3};
        int[] tops = new int[]{1,2};
        System.out.println(getOptions(budget,jeans,shoes,skirts,tops));
    }
    
    static int count=0;
    public static int getOptions(int budget,int[] jeans,int[] shoes,int[] skirts,int[] tops){
        Arrays.sort(jeans);
        Arrays.sort(shoes);
        Arrays.sort(skirts);
        Arrays.sort(tops);
        helper(budget, jeans, shoes, skirts, tops, new int[]{0, 0, 0, 0});
        return count;
    }

    public static void helper(int budget,int[] jeans,int[] shoes,int[] skirts,int[] tops,int[] pos){
        if(pos[0]>=jeans.length) return;
        if(pos[1]>=shoes.length) return;
        if(pos[2]>=skirts.length) return;
        if(pos[3]>=tops.length) return;
        if(jeans[pos[0]]+shoes[pos[1]]+skirts[pos[2]]+tops[pos[3]]<=budget){
            count++;
            int[] copy = pos.clone();
            copy[0]++;
            helper(budget,jeans,shoes,skirts,tops, copy);
            copy = pos.clone();
            copy[1]++;
            helper(budget,jeans,shoes,skirts,tops, copy);
            copy = pos.clone();
            copy[2]++;
            helper(budget,jeans,shoes,skirts,tops, copy);
            copy = pos.clone();
            copy[3]++;
            helper(budget,jeans,shoes,skirts,tops, copy);
        }
    }
}
