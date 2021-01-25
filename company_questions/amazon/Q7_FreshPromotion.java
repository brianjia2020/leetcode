package company_questions.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q7_FreshPromotion {
    public static void main(String[] args) {
        String[][] codeList = {{"apple","apple"},{"banana","anything","banana"}};
        String[] shoppingCart = {"banana","orange","banana","apple","apple"};
        System.out.println(isWinner(codeList,shoppingCart));
    }

    public static int isWinner(String[][] codeList, String[] shoppingCart){
        if(shoppingCart==null||shoppingCart.length==0) return 0;
        Set<String> set = new HashSet<>();
        for(String[] subSet: codeList) {
            set.addAll(Arrays.asList(subSet));
        }
        for(String[] subSet: codeList){
            if (canMatch(subSet,shoppingCart,set)) return 1;
        }
        return 0;
    }

    public static boolean canMatch(String[] subList, String[] shoppingCart,Set<String> set){
        if(shoppingCart.length< subList.length) return false;
        boolean res = true;
        for(int i =0;i< shoppingCart.length - subList.length;i++){
            for(int j=i;j< subList.length;j++){
                if(shoppingCart[j].equals(subList[j])) continue;
                if(subList[j].equals("anything")&&set.contains(shoppingCart[j])) continue;
                res = false;
            }
        }
        return res;
    }
}
