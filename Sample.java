// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : unable to do the O(1) time complexity

// Your code here along with comments explaining your approach
class MyHashMap {
    //Creating the two Arraylists
    private ArrayList<Integer> keys, values;
    public MyHashMap() {
        keys=new ArrayList<Integer>();
        values=new ArrayList<Integer>();
    }

    //checking the key is present or not if it's not there we will get -1
    public void put(int key, int value) {
        int x=keys.indexOf(key);
        if(x!=-1){
            values.set(x,value);
        }
        else{
            keys.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        int x = keys.indexOf(key);
        if(x!=-1){
            return values.get(x);
        }
        else{
            return -1;
        }
    }

    public void remove(int key) {
        int x = keys.indexOf(key);
        if(x!=-1){
            keys.remove(x);
            values.remove(x);
        }
    }
}
