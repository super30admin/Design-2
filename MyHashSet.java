/*
Time Complexity: O(1)
Space Complexity: O(1)
It ran on leetcode
Didnt face any issue while writing the code
*/

class MyHashSet {
	int st[];
    public MyHashSet() {
        st = new int[1000001];
    }
    
    public void add(int key) {
        st[key] = key;
    }
    
    public void remove(int key) {
        st[key] = 0;
    }
    
    public boolean contains(int key) {
        return st[key]==key
    }
}