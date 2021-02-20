package company_questions.amazon.VO;

public class IntegerToRoman {
    public String intToRoman(int num){
        //edge cases:
        StringBuilder res = new StringBuilder();
        if(num<=0) return res.toString();

        //solution:
        //1. define two array of the same length to store in descending order
        //   1000,900,500,400,100,90,50,40,10,9,5,4,1
        //   String[] str = {}, int[] ranges = {};
        //2. for loop to find the range of the number at which range
        //   do a while loop to subtract it until it goes to the next range and eventually to 0

        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] ranges = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};

        for(int i=0;i<ranges.length;i++){
            while(num>=ranges[i]){
                num -= ranges[i];
                res.append(str[i]);
            }
        }
        return res.toString();
    }
}
