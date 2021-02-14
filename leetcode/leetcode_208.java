package leetcode;

public class leetcode_208 {
    public static void main(String[] args) {

    }
}
class TrieNode{
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){};
    public TrieNode(char c ){
        TrieNode node = new TrieNode();
    }
}

class Trie{
    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null){
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws = ws.children[c-'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws = ws.children[c-'a'];
        }
        return true;
    }
}
