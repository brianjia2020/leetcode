package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_460 {

}

class LFUCache{

    Queue<LFUNode> queue = new PriorityQueue<>((o1,o2)->{
        if (o1.freq==o2.freq){
            return Integer.compare(o1.tick,o2.tick);
        } else {
            return Integer.compare(o1.freq,o2.freq);
        }
    });
    Map<Integer,LFUNode> map = new HashMap<>();
    int capacity;
    int num;
    int stamp;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(capacity==0) return -1;
        stamp++;
        if(map.containsKey(key)){
            LFUNode node = map.get(key);
            queue.remove(node);
            LFUNode newNode = new LFUNode(key,node.value,node.freq+1,stamp);
            queue.offer(newNode);
            map.put(key,newNode);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        stamp++;
        if(map.containsKey(key)){
            LFUNode node = map.get(key);
            queue.remove(node);
            LFUNode newNode = new LFUNode(key,value,node.freq+1,stamp);
            map.put(key,newNode);
            queue.offer(newNode);
        } else if (num==capacity){
            LFUNode node = queue.poll();
            queue.remove(node);
            map.remove(node.key,node);
            LFUNode newNode = new LFUNode(key,value,1,stamp);
            map.put(key,newNode);
            queue.offer(newNode);

        } else {
            num++;
            LFUNode newNode = new LFUNode(key,value,1,stamp);
            map.put(key,newNode);
            queue.offer(newNode);
        }
    }

}

class LFUNode{
    int key;
    int value;
    int freq;
    int tick;

    public LFUNode(int key, int value, int freq, int tick){
        this.key = key;
        this.value = value;
        this.freq = freq;
        this.tick = tick;
    }
}
