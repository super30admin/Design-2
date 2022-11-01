/*
    Time Complexity = O(N)
    Space Complexity = O(N)
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class MyHashMap {
    int buckets;
    Node[] bucketHeads;
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap(){
        buckets = 1000;
        bucketHeads = new Node[buckets];
    }

    private int getBucket(int key){
        return Integer.hashCode(key) % buckets;
        // return key%buckets;
    }

    private Node findKey(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }


    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(bucketHeads[bucket] == null){
            bucketHeads[bucket] = new Node(-1,-1);
        }

        Node prev = findKey(bucketHeads[bucket], key);

        if(prev.next != null){
            prev.next.value = value;
            return;
        }

        prev.next = new Node(key, value);


    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(bucketHeads[bucket] == null){
            return -1;
        }

        Node prev = findKey(bucketHeads[bucket], key);
        if(prev.next != null){
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(bucketHeads[bucket] == null){
            return;
        }else{
            Node prev = findKey(bucketHeads[bucket], key);
            if(prev.next == null){
                return;
            }else{
                prev.next = prev.next.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1,1);
        hm.put(2,1);
        hm.put(3,3);
        System.out.println(hm.get(3));
        hm.remove(1);
        hm.put(1,3);
        hm.remove(2);
        System.out.println(hm.get(2));
    }
}