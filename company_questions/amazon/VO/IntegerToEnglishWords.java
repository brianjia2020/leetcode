package company_questions.amazon.VO;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
        public String numberToWords(int num){
            //edge cases:
            if (num==0) return "Zero";
            //solution:
            //1. we have to separate number into thousand, million, billion region
            //2. solve simple cases like 123, then 123,000
            Map<Integer, String> map = new HashMap<>();
            map.put(1,"One"); map.put(2,"Two"); map.put(3,"Three");
            map.put(4,"Four"); map.put(5,"Five"); map.put(6,"Six");
            map.put(7,"Seven"); map.put(8,"Eight"); map.put(9,"Nine");
            map.put(10,"Ten"); map.put(11,"Eleven"); map.put(12,"Twelve");
            map.put(13,"Thirteen"); map.put(14,"Fourteen"); map.put(15,"Fifteen");
            map.put(16,"Sixteen"); map.put(17, "Seventeen"); map.put(18, "Eighteen");
            map.put(19, "Nineteen"); map.put(20, "Twenty");
            map.put(30, "Thirty"); map.put(40, "Forty"); map.put(50, "Fifty");
            map.put(60, "Sixty"); map.put(70, "Seventy"); map.put(80, "Eighty");
            map.put(90, "Ninety"); map.put(100, "Hundred");map.put(1000, "Thousand");
            map.put(1000000,"Million");map.put(1000000000,"Billion");
            StringBuilder sb = new StringBuilder();
            if (num>=1000000000){
                sb.append(map.get(num/1000000000));
                sb.append(" ");
                sb.append(map.get(1000000000));
                num %= 1000000000;
            }

            if (num>=1000000){
                if(sb.length()!=0) sb.append(" ");
                sb.append(helper(num/1000000,map));
                sb.append(" ");
                sb.append(map.get(1000000));
                num %= 1000000;
            }

            if (num>=1000){
                if(sb.length()!=0) sb.append(" ");
                sb.append(helper(num/1000,map));
                sb.append(" ");
                sb.append(map.get(1000));
                num %= 1000;
            }

            if (num>0){
                if(sb.length()!=0) sb.append(" ");
                sb.append(helper(num,map));
            }

            return sb.toString();
        }

        public String helper(int num, Map<Integer, String> map){
            StringBuilder sb = new StringBuilder();
            if (num==0) return sb.toString();
            else if (num<=20) sb.append(map.get(num));
            else if (num<100) {
                sb.append(map.get(num/10*10));
                if(num%10>0) {
                    sb.append(" ");
                    sb.append(map.get(num%10));
                }
            } else{
                sb.append(map.get(num/100));
                sb.append(" ");
                sb.append("Hundred");
                if(num%100!=0) {
                    sb.append(" ");
                    sb.append(helper(num%100,map));
                }
            }
            return sb.toString();
        }
}


