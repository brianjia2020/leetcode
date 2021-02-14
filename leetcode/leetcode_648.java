package leetcode;

import utility.TrieNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word: dictionary){
            TrieNode ws = root;
            for(char c: word.toCharArray()){
                if(!ws.map.containsKey(c)) {
                    ws.map.put(c, new TrieNode());
                }
                ws = ws.map.get(c);
            }
            ws.isWord = true;
        }


        String[] words = sentence.split(" ");
        String res = "";
        for(String word: words){
            String temp = getShortestMatch(word, root);
            res += temp + " ";
        }
        return res.strip();
    }

    public String getShortestMatch(String word, TrieNode root){
        String res = "";
        for(char c: word.toCharArray()){
            if(root.map.containsKey(c)){
                res += c;
            } else {
                break;
            }
            root = root.map.get(c);
            if(root.isWord) return res;
        }
        return word;
    }
}
