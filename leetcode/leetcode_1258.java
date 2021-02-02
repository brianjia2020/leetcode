package leetcode;

import java.util.*;

public class leetcode_1258 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(List.of("happy","joy"));
        list.add(List.of("sad","sorrow"));
        list.add(List.of("joy","cheerful"));
        String text = "I am happy today but was sad yesterday";

        leetcode_1258 test = new leetcode_1258();
        test.generateSentences(list,text).forEach(System.out::println);
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text){
        List<String> res = new ArrayList<>();
        Map<String, Set<String>> mem = getGroups(synonyms);
        generateSentences(mem,text.split(" "),res,0,"");
        Collections.sort(res);
        return res;
    }

    public void generateSentences(Map<String,Set<String>> mem, String[] text, List<String> res, int index, String curr){
        if(index == text.length) {
            res.add(curr.stripLeading());
            return;
        }
        if(mem.containsKey(text[index])){
            for(String word: mem.get(text[index])) {
                generateSentences(mem, text, res, index + 1, curr + " " + word);
            }
        } else {
            generateSentences(mem, text, res, index + 1, curr + " " + text[index]);
        }
    }

    //wrong way to get groups, can only detect [a,b],[b,c] one way of relationship
    //we need to dfs to traverse
    public Map<String, Set<String>> getGroups(List<List<String>> synonyms){
        Map<String,Set<String>> map = new HashMap<>();
        List<Set<String>> sets = new ArrayList<>();
        for(List<String> synonym: synonyms){
            boolean ifHas = false;
            for(Set<String> set: sets){
                if(set.contains(synonym.get(0))||set.contains(synonym.get(1))){
                    ifHas = true;
                    set.add(synonym.get(0));
                    set.add(synonym.get(1));
                }
            }
            if(!ifHas) {
                Set<String> set = new HashSet<>();
                set.add(synonym.get(0));
                set.add(synonym.get(1));
                sets.add(set);
            }
        }
        for(Set<String> set: sets){
            for(String str: set) {
                map.putIfAbsent(str,set);
            }
        }
        return map;
    }
}
