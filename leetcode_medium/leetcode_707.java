package leetcode_medium;

import org.junit.Test;

public class leetcode_707 {
    @Test
    public void test1(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
//        myLinkedList.printAllValues();
//        int i = myLinkedList.get(1);
//        System.out.println(i);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.printAllValues();
//        int i1 = myLinkedList.get(1);
//        System.out.println(i1);
//        myLinkedList.printAllValues();
//        System.out.println("Length is");
//        System.out.println(myLinkedList.length);
    }

    @Test
    public void test2(){
//        ["MyLinkedList","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex",
//        "addAtTail","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtTail"]
//        [[],[0],[1,4],[8],[5],[4,3],[0],[5],[6,3],[7],[5],[4]]
        MyLinkedList t2 = new MyLinkedList();
        t2.addAtHead(0);
        t2.addAtIndex(1,4);
//        t2.addAtTail(8);
//        t2.addAtHead(5);
//        t2.addAtIndex(4,3);
//        t2.addAtTail(0);
//        t2.addAtTail(5);
//        t2.addAtIndex(6,3);
        t2.deleteAtIndex(1);
//        t2.deleteAtIndex(5);
//        System.out.println(t2.length);
        t2.addAtTail(4);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList{
    int length;
    ListNode head;

    public void printAllValues(){
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur =cur.next;
        }
    }

    public MyLinkedList(){
        length = 0;
        head = new ListNode(0);
    }

    public int get(int index){
        if (length==0) return -1;
        if (index < 0 || index >= length) return -1;
        ListNode temp = head;
        for(int i =0; i <= index;i++){
            temp = temp.next;
        }
        return temp.val;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        if(length>0){
            ListNode oldHead = head.next;
            head.next = newNode;
            newNode.next = oldHead;
            length++;
        } else if (isEmpty()){
            head.next = newNode;
            length++;
        }
    }

    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);
        if (length>0) {
            ListNode tail = head;
            for (int i = 0; i < length; i++) {
                tail = tail.next;
            }
            tail.next = newNode;
            length++;
        } else if (isEmpty()){
            head.next = newNode;
            length++;
        }
    }

    public void addAtIndex(int index, int val){
        if(index <0 || index >= length+1) return;

        if (index == length){
            addAtTail(val);
        } else if (index == 0){
            addAtHead(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode pre = null;
            ListNode cur = head;
            for(int i =0;i<=index;i++){
                pre = cur;
                cur = cur.next;
            }
            pre.next = newNode;
            newNode.next = cur;
            length++;
        }
    }

    public void deleteAtIndex(int index){
        if(length==0|| index <0 || index >= length) return;
        if (index == 0){
            head = head.next;
            length--;
        } else if (index == length-1){
            ListNode temp = head;
            for(int i =0;i<index;i++){
                temp = temp.next;
            }
            temp.next = null;
            length--;
        } else {
            ListNode pre = null;
            ListNode cur = head;
            for (int i =0;i<=index;i++){
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            length--;
        }
    }
}
