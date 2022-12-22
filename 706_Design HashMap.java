// Time Complexity : o(n/k) k = size of buckets
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. the 2d array approach did not work


// Your code here along with comments explaining your approach
/*
 *  used liner chaining using linked list for collision handling
 *
 * */


import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    Buckets[] buckets ;

    public MyHashMap() {
        buckets = new Buckets[1000];
        for(int i = 0; i < 1000; i++){
            buckets[i] = new Buckets();
        }

    }


    public void put(int key, int value) {
        int bucketIndex = key%1000;
        buckets[bucketIndex].add(key, value);
    }

    public int get(int key) {
        int bucketIndex = key%1000;
        return buckets[bucketIndex].get(key)  ;
    }

    public void remove(int key) {
        int bucketIndex = key%1000;
        buckets[bucketIndex].remove(key);
    }
}
class Pair {
    int key;
    int value;

    Pair(int key, int value){
        this.key = key;
        this.value =value;
    }
}
class Buckets{
    List<Pair> items;

    Buckets(){
        items = new ArrayList<>();
    }

    int contains(int key){
        int index = 0;
        for(Pair item : items){
            if(item.key == key){
                return index;
            }
            index++;
        }
        return -1;
    }

    void add(int key, int value){
        int index = contains(key);
        if( index == -1){
            items.add(new Pair(key, value));
            return;
        }
        items.remove(index);
        items.add(new Pair(key, value));

    }

    void remove(int key){
        int index = contains(key);
        if( index == -1){
            return;
        }
        items.remove(index);
    }

    int get(int key){
        for(Pair item : items){
            if(item.key == key){
                return item.value;
            }
        }
        return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */