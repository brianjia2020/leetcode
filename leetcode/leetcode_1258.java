package leetcode;

import java.util.*;

public class leetcode_1258 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
//        list.add(List.of("happy","joy"));
//        list.add(List.of("sad","sorrow"));
//        list.add(List.of("joy","cheerful"));
//        String text = "I am happy today but was sad yesterday";
        list.add(List.of("a","b"));
        list.add(List.of("b","c"));
        list.add(List.of("d","e"));
        list.add(List.of("c","d"));
        String text = "a b";

        leetcode_1258 test = new leetcode_1258();
        test.generateSentences(list,text).forEach(System.out::println);
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text){
        List<String> res = new ArrayList<>();
        Map<String, Set<String>> mem = getGroups2(synonyms);
        System.out.println(mem);
        helper2(mem);
        System.out.println(mem);

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

    public Map<String, Set<String>> getGroups2(List<List<String>> synonyms){
        Map<String, Set<String>> mem = new HashMap<>();
        for(List<String> pair: synonyms){
            mem.putIfAbsent(pair.get(0),new HashSet<>());
            mem.putIfAbsent(pair.get(1),new HashSet<>());
            mem.get(pair.get(0)).add(pair.get(1));
            mem.get(pair.get(1)).add(pair.get(0));
        }
        return mem;
    }

    public void helper2(Map<String,Set<String>> mem){
        for(String str: mem.keySet()){
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(str);
            visited.add(str);
            while(!queue.isEmpty()){
                String s = queue.poll();
                for(String temp: mem.get(s)){
                    if(!visited.contains(temp)){
                        mem.get(str).add(temp);
                        queue.add(temp);
                        visited.add(temp);
                    }
                }
            }
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
        System.out.println(sets);
        for(Set<String> set: sets){
            for(String str: set) {
                map.putIfAbsent(str,set);
            }
        }
        return map;
    }


}
