package company_questions.amazon.VO;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    Node head,tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key){
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            addAtHead(temp);
            return temp.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size()>=capacity){
            remove(tail.prev);
        }

        addAtHead(new Node(key,value));
    }

    public void addAtHead(Node node){
        map.put(node.key,node);
        Node oldFirst = head.next;
        head.next = node;
        node.next = oldFirst;
        oldFirst.prev = node;
        node.prev = head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node{
        int key,value;
        Node prev,next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
