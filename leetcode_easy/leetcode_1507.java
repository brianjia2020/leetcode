package leetcode_easy;

import java.util.HashMap;

public class leetcode_1507 {
    public String reformatDate(String date){
        HashMap<String,String> monthMap = new HashMap<>();
        monthMap.put("Jan","01");
        monthMap.put("Feb","02");
        monthMap.put("Mar","03");
        monthMap.put("Apr","04");
        monthMap.put("May","05");
        monthMap.put("Jun","06");
        monthMap.put("Jul","07");
        monthMap.put("Aug","08");
        monthMap.put("Sep","09");
        monthMap.put("Oct","10");
        monthMap.put("Nov","11");
        monthMap.put("Dec","12");
        String[] splits = date.split(" ");
        String year = splits[2];
        String month = monthMap.get(splits[1]);
        int n = splits[0].length();
        String day = splits[0].substring(0,n-2);
        if (day.length()==1){
            day = "0" + day;
        }
        return year+"-"+month+"-"+day;
    }
}
