class MyHashMap {
/*
* Approach was the use double hashing to store values without collisions similar to a hashset implementation
* 
* Time Complexity :
* put(), get(), remove() - O(1)
* 
* Space Complexity :
* Space complexity is O(N)
* Did this code successfully run on Leetcode : yes
* 
* Any problem you faced while coding this : None
*/

    private Integer primaryArr[][];
    private int arrLength;

    public MyHashMap() {
        this.arrLength=1000;
        this.primaryArr=new Integer[arrLength][];
    }

    int hash1(int val)
    {
        return val%arrLength;
    }

        int hash2(int val)
    {
        return val/arrLength;
    }
    
    public void put(int key, int value) {
        int hash1=hash1(key);
        int hash2=hash2(key);

        if(key==1000000){
            primaryArr[hash1]= new Integer[arrLength+1];
        }

        else if(primaryArr[hash1]==null){
            primaryArr[hash1]= new Integer[arrLength];
        }

        primaryArr[hash1][hash2]=value;
        
    }
    
    public int get(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);

        if(primaryArr[hash1]==null){
            return -1;
        }

        if(primaryArr[hash1][hash2]!=null){
            return primaryArr[hash1][hash2];
        }
        else 
            return -1;
       
    }
    
    public void remove(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
     if(primaryArr[hash1]==null){
            return ;
        }

        if(primaryArr[hash1][hash2]!=null){
            primaryArr[hash1][hash2]=-1;
        }
    }
}
