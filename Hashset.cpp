// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashSet {
public:
    /** Initialize your data structure here. */
    vector<int> my_hash_set;
    MyHashSet() {
       my_hash_set =  vector<int> (10,-1); 
    }
    
    void add(int key) {
        if(key > my_hash_set.size()-1){
            my_hash_set.resize(key+1,-1);
        }
        //find appropriate bucket for the key
        int bucket = (key) % my_hash_set.size(); //gives row
        my_hash_set[bucket] = 1;
    }
    
    void remove(int key) {
        if(key> my_hash_set.size()-1){
        }
        else{
           int bucket = (key) % my_hash_set.size();
            my_hash_set[bucket] =-1 ;
        }   
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(key> my_hash_set.size()-1){
             return false;
        }
        else{
            int bucket = (key) % my_hash_set.size();
            if(my_hash_set[bucket]==-1){
                return false;
            }
            return true;
        }
          
    }
};