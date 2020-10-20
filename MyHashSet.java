// Time Complexity : For remove and contains its O(n) for add its O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : I am not comfortable with concepts of time,space complexity is there any way to work on the basics?


// Your code here along with comments explaining your approach


class MyHashSet {

    int[] arr=new int[10000];
    int index=0;


    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        arr[index]=key;
        index++;
    }

    public void remove(int key) {

        for(int i=0;i<index;i++)
            if(arr[i]==key)
            {
                arr[i]=-1;
            }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
                return true;
        }
        return false;
    }
}