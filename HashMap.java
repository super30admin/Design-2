// Time Complexity : O(1)
// Space Complexity : O(N) - SQRT OF N
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach
//Created two hash functions -
// 1. for getting primary array index
//2. for getting secondary array index to store key. Instead of creating a bollean array,
// I created int secondary array for storing keys.
class MyHashMap {
    int size = 1000;
    int [][] arr;

    public int hash1(int key){
        return key%size;
    }

    public int hash2(int key){
        return key/size;
    }
    public MyHashMap() {
        arr = new int[1000][];
    }
    //o(n) if nested stack is empty
    //o(1) otherwise
    public void put(int key, int value) {
        int pIndex = this.hash1(key);
        int sIndex = this.hash2(key);
        if(arr[pIndex]==null){
            arr[pIndex] = new int[1001];
            for(int i=0;i<1001;i++){
                arr[pIndex][i]=-1;
            }
        }

        arr[pIndex][sIndex]= value;
    }
    //o(1)
    public int get(int key) {
        int pIndex = this.hash1(key);
        int sIndex = this.hash2(key);
        if(arr[pIndex]==null){
            return -1;
        }
        else if(arr[pIndex][sIndex]==-1){
            return -1;
        }
        else{
            return arr[pIndex][sIndex];
        }
    }
    //o(1)
    public void remove(int key) {
        int pIndex = this.hash1(key);
        int sIndex = this.hash2(key);
        if(arr[pIndex]!=null){
            if(arr[pIndex][sIndex]!=-1){
                arr[pIndex][sIndex]=-1;
            }
        }
    }
}

