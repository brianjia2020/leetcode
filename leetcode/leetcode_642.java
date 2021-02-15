package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_642 {

}

class AutocompleteSystem{
    class TrieNode implements Comparable<TrieNode>{
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode (){
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        @Override
        public int compareTo(TrieNode o) {
            if(this.times == o.times) {
                return this.s.compareTo(o.s);
            } else {
                return Integer.compare(o.times,this.times);
            }
        }

        public void update(TrieNode node){
            if(!this.hot.contains(node)){
                this.hot.add(node);
            }
            Collections.sort(hot);
            if(hot.size()>3) {
                hot.remove(hot.size()-1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times){
        root = new TrieNode();
        sb = new StringBuilder();
        for(int i=0;i<times.length;i++){
            add(sentences[i],times[i]);
        }
    }

    public void add(String sentence, int time){
        TrieNode temp = root;
        List<TrieNode> list = new ArrayList<>();
        for(char c: sentence.toCharArray()){
            if(temp.children[c]==null){
                temp.children[c] = new TrieNode();
            }
            temp = temp.children[c];
            list.add(temp);
        }
        temp.s = sentence;
        temp.times += time;
        for(TrieNode node: list){
            node.update(temp);
        }
    }

    public List<String> input(char c){
        List<String> res = new ArrayList<>();
        if(c=='#'){
            add(sb.toString(),1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }
        sb.append(c);
        if(cur!=null){
            cur = cur.children[c];
        }
        if(cur==null){
            return res;
        }

        for(TrieNode node: cur.hot){
            res.add(node.s);
        }
        return res;
    }
}
