package leetcode_easy;

public class leetcode_66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
        {
            return new int[]{1};
        }
        int carry = 0;
        for (int i = digits.length-1;i>=0;i--){
            if (digits[i] !=9 ){
                digits[i] += carry;
                carry = 0;
                break;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }

        if (carry == 1){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
