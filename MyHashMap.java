// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// Designed a HashMap using an array of linked lists (buckets) to resolve collisions via separate chaining.
// The map resizes (rehashes) when the load factor exceeds 2.0 to maintain efficient operations.


import java.util.LinkedList;

public class MyHashMap{
    private class Node{
        int key, value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int n; // total no of entries
    private int N; // total no of buckets
    LinkedList<Node> buckets[];

    public MyHashMap(){
        this.N = 4;
        buckets = new LinkedList[N];

        for(int i = 0; i < N; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key){
        return Math.abs(key) % N;
    }

    private int searchInLL(int key, int bi){
        LinkedList<Node> ll = buckets[bi];
        for(int i = 0; i < ll.size(); i++){
            if(ll.get(i).key == key){
                return i;
            }
        }
        return -1;
    }

    private void rehash(){
        LinkedList<Node> oldBuckets[] = buckets;
        N = N * 2;
        buckets = new LinkedList[N];

        for(int i = 0; i < N; i++){
            buckets[i] = new LinkedList<>();
        }

        n = 0;
        for(int i = 0; i < oldBuckets.length; i++){
            LinkedList<Node> ll = oldBuckets[i];

            for(int j = 0; j < ll.size(); j++){
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }

    public void put(int key, int value){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di == -1){
            buckets[bi].add(new Node(key, value));
            n++;
        }else{
            Node node = buckets[bi].get(di);
            node.value = value;
        }

        double lambda = (double)n/N;
        if(lambda > 2.0){
            rehash();
        }
    }

    public int get(int key){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di == -1){
            return -1;
        }else{
            Node node = buckets[bi].get(di);
            return node.value;
        }
    }

    public void remove(int key){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di == -1){
            return;
        }else{
            Node node = buckets[bi].remove(di);
            n--;
        }
    }
}