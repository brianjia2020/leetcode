package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode_146{

}

class LRUCache {
    Value head = new Value(0,0), tail = new Value(0,0);
    int capacity;
    Map<Integer,Value> map = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Value v = map.get(key);
            remove(v);
            addAtHead(v);
            return v.val;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }

        addAtHead(new Value(key,value));
    }

    public void addAtHead(Value v){
        map.put(v.key,v);
        Value headNext = head.next;
        head.next = v;
        v.next = headNext;
        headNext.prev = v;
        v.prev = head;
    }

    public void remove(Value v){
        map.remove(v.key);
        v.prev.next = v.next;
        v.next.prev = v.prev;
    }
}

class Value {
    Value prev,next;
    int key,val;
    public Value(int key, int val){
        this.key = key;
        this.val = val;
    }
}
