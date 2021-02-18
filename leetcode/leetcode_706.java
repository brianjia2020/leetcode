package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_706 {

}

class myHashMap{

    int[] ans;

    public myHashMap(){
        ans = new int[1000000];
        Arrays.fill(ans,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ans[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return ans[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ans[key] = -1;
    }
}

class myHashMap2{

    Node[] lists;
    int size;

    public myHashMap2(){
        lists =  new Node[20];
        size = 20;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = hashFunc(key);
        if(lists[i]==null){
            lists[i] = new Node(key,value);
        } else {
            Node cur = lists[i];
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key, value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hashFunc(key);
        if(lists[i]==null) return -1;
        Node cur = lists[i];
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hashFunc(key);
        if(lists[i]==null) return;
        Node cur = lists[i];
        while(cur!=null){
            if(cur.key==key) cur.val = -1;
            cur=cur.next;
        }
    }

    public int hashFunc(int key){
        return key%20;
    }

    class Node {
        int key, val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

}