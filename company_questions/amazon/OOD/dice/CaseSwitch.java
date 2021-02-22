package company_questions.amazon.OOD.dice;

import java.util.*;

public class CaseSwitch {
    public static void main(String[] args) {
        String s= "a_adadc_adfa";
        System.out.println(new CaseSwitch().switchCase(s,"camel"));
    }

    public String switchCase(String s, String targetCase) {
        //edge cases:
        if (s==null||s.length()==0) return "";
        Set<String> supportedCases = new HashSet<>();
        supportedCases.add("camel");
        supportedCases.add("snake");
        supportedCases.add("dash");
        if(targetCase==null||!supportedCases.contains(targetCase)) return "";

        //solution:
        //1. identify the case for s
        //2. split the s by camel(Capital Letter), snake(_) or dash(-)
        //3. convert to target case and return
        String resCase = findCase(s);
        List<String> tempSplit;
        if(resCase!=null){
            tempSplit = splitWords(s,resCase);
            return combineWords(tempSplit, targetCase);
        } else return "";

    }

    public String findCase(String s){
        for(char c: s.toCharArray()){
            if (c>='A'&&c<='Z') return "camel";
            else if (c=='_') return "snake";
            else if (c=='-') return "dash";
        }
        return null;
    }

    public List<String> splitWords(String s, String resCase){
        if(resCase.equals("snake")) return  Arrays.asList(s.split("_"));
        else if (resCase.equals("dash")) return Arrays.asList(s.split("-"));
        else if (resCase.equals("camel")){
            List<String> res = new ArrayList<>();
            String temp = "";
            for(char c: s.toCharArray()){
                if(c>='A'&&c<='Z'){
                    res.add(temp);
                    temp = "";
                }
                temp += c;
            }
            res.add(temp);
            return res;
        }
        else return new ArrayList<>();
    }

    public String combineWords(List<String> lists, String targetCase){
        String res = lists.get(0);
        for(int i=1;i<lists.size();i++){
            if(targetCase.equals("camel")) {
                String temp = lists.get(i).substring(0,1).toUpperCase() + lists.get(i).substring(1);
                res += temp;
            } else if (targetCase.equals("snake")){
                res += "_" + lists.get(i);
            } else if (targetCase.equals("dash")){
                res += "-" + lists.get(i);
            }
        }
        return res;
    }


}
