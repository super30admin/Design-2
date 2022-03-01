// Time Complexity :for adding O(1), for removing and containing  O(n)
// Space Complexity : used one array O(n), variables
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : in removing the element, the java defaults the value to zero so i added -1 while initilizing contructor
I used array to implement the given problem, do I need to implement with same time complexity as in hashset


class MyHashSet {
    int top=-1;
    int[] arr=new int[10001];
    public MyHashSet() {
        
        //MyHashSet hs = new MyHashSet();
        //hs.add(1);
         for(int i=0;i<arr.length;i++){
                arr[i] = -1;
            }
    }
    
    public void add(int key) {
        
        if(!contains(key)){
            top++;
            arr[top] = key;
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            int temp=arr.length;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==key){
                    temp=i;
                }
            }
            for(int i=temp;i<arr.length-1;i++){
                
                arr[i] = arr[i+1];
            }
        }
    }
    
    public boolean contains(int key) {
            for(int i=0;i<arr.length;i++){
                if(arr[i]==key){
                    return true;
                }
            }   
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
