import java.util.ArrayList;

public class MyHashMap {
   /**  Time Complexity : O(1)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No
     Your code here along with comments explaining your approach **/

   //Initializing the array
    int arr[];
    public MyHashMap() {
    //The size selected here is as per the constraints mentioned which is, 0 <= key, value <= 10^6
        arr = new int[1000001];
    }

    public void put(int key, int value) {
//        Assigning value for the array at 'key' index
        arr[key] = value+1;
    }

    public int get(int key) {
//        Returns the value present at 'key' index
        return arr[key]-1;
    }

    public void remove(int key) {
//        Removes the value at 'key' index
        arr[key] = 0;
    }
}
