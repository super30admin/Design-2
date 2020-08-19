import java.util.*;
//Problem- Implement HashSet
// Time Complexity : push - O(1), isEmpty - O(1), pop - O(n), peek - O(n)
// Space Complexity : push - O(n), isEmpty - O(1), pop - O(1) or O(n), peek - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : peek can be achieved in O(1) by maintaining a variable front. 


class Bucket{
    public LinkedList<Integer> bucket;

    public Bucket(){
        bucket = new LinkedList<>();
    }

    public void insert(Integer key){
        int index = this.bucket.indexOf(key);
        if (index == -1){
            this.bucket.addFirst(key);
        }
    }

    public void delete(Integer key){
        //int index = this.bucket.indexOf(key);
        this.bucket.remove(key);
    }

    public boolean exists(Integer key){
        int index = this.bucket.indexOf(key);
        return (index != -1);
    }
}

class MyHashSet{

    public int keyspace;
    public List<Bucket> hash_table;

    public MyHashSet(){
        this.keyspace = 2069;
        this.hash_table = new ArrayList<>();
        for(int i=0;i<this.keyspace;i++){
            this.hash_table.add(new Bucket());
        }
    }

    public void add(int key){
        int hashkey = key % this.keyspace;
        this.hash_table.get(hashkey).insert(key);
    }

    public void remove(int key){
        int hashkey = key % this.keyspace;
        this.hash_table.get(hashkey).delete(key);
    }

    public boolean contains(int key){
        int hashkey = key % this.keyspace;
        return this.hash_table.get(hashkey).exists(key);
    }


    public static void main(String[] args){
        MyHashSet hset = new MyHashSet();
        hset.add(1);
        hset.add(2);
        System.out.println(hset.contains(3));
        System.out.println(hset.contains(2));

    }

}