package leetcode_easy;

public class leetcode_1281 {
    public static void main(String[] args) {
        System.out.println(run(210));
    }

    public static int run(int input){
        if (input < 10) return 0;
        String input1 = Integer.toString(input);
        int sum = 0;
        int multi = 1;
        for (int i=0; i< input1.length();i++){
            int num = Character.getNumericValue(input1.charAt(i));
            sum += num;
            multi = multi * num;
        }
        return multi-sum;
    }
}
