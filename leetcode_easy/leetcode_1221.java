package leetcode_easy;

public class leetcode_1221 {
    public static void main(String[] args) {
        System.out.println(run("LRLRLR"));
    }

    public static int run(String s){
        int balanced_count = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'L'){
                count ++;
            } else {
                count --;
            }

            if (count == 0){
                balanced_count ++;
            }
        }
        return balanced_count;
    }
}
