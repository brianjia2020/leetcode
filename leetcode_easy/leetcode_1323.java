package leetcode_easy;

public class leetcode_1323 {
    public static void main(String[] args) {
        System.out.println(maximum96Number(996947399));
    }

    public static int maximum96Number(int num){
        String maxNum = Integer.toString(num);
        int pos = -1;
        boolean changed = false;
        String res = "";
        for(int i = 0; i < maxNum.length(); i++){
            if (maxNum.charAt(i) == '6'){
                pos = i;
                changed = true;
                break;
            }
        }

        if ( changed ) {
            return num+ (int) Math.pow(10,maxNum.length() - pos-1)*3;
        } else {
            return num;
        }



    }
}
