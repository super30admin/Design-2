//problem 2: 
// Time Complexity : Amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Only 26 test case passed but not sure why this logic is failing

class MyHashMap {

    private int[][] matrix;
    int keys;
    int keyItems;

    private int hash1(int val) { // First hash function that do the modulo
        return val % keys;
    }

    private int hash2(int val) {// First hash function that take do the division
        return val / keyItems;
    }

    public MyHashMap() { // declare the variables
        keys = 1000;
        keyItems = 1000;
        matrix = new int[keys][];

    }

    public void put(int key, int value) {
        int valKey = hash1(key);//here use the hash functions
        int valItem = hash2(key);

        if (matrix[valKey] == null) { // if matrix is null no items yet for that key
            matrix[valKey] = new int[keyItems]; // declare the array with keyItems
        }

        matrix[valKey][valItem] = value; // assign the value to the location based on hashing
    }

    public int get(int key) {

        int valKey = hash1(key); //here use the hash functions
        int valItem = hash2(key);

        if (matrix[valKey] == null || matrix[valKey][valItem] == -1) {
            return -1; // if no value for the key or removed return -1
        }

        return matrix[valKey][valItem];
    }

    public void remove(int key) {

        int valKey = hash1(key);//here use the hash functions
        int valItem = hash2(key);

        if (matrix[valKey] == null) {
            return; //if no key found return 
        }

        matrix[valKey][valItem] = -1; // if key found just add -1 to the value

        return;

    }
}