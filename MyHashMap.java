import java.util.Arrays;
// Time Complexity : O(1)
// Space Complexity : O(n)
class MyHashMap {

    private int firstLevelArray;
    private int secondLevelArray;
    private int[][] storage;

    public MyHashMap() {
        this.firstLevelArray=1000;
        this.secondLevelArray=1000;
        this.storage=new int[firstLevelArray][];
    }

    private int firstHashing(int key){
        return key%firstLevelArray;
    }

    private int secondHashing(int key){
        return key/secondLevelArray;
    }

    public void put(int key, int value) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]==null){
            if(firstHashingValue==0){
                storage[firstHashingValue]=new int[secondLevelArray+1];
            }
            else{
                storage[firstHashingValue]=new int[secondLevelArray];
            }
            Arrays.fill( storage[firstHashingValue], -1 );
        }
        storage[firstHashingValue][secondHashingValue]=value;
    }

    public int get(int key) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]==null){
            return -1;
        }
        return storage[firstHashingValue][secondHashingValue];
    }

    public void remove(int key) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]!=null){
            storage[firstHashingValue][secondHashingValue]=-1;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        myHashMap.get(1);
        myHashMap.get(3);
        myHashMap.put(2,1);
        myHashMap.get(2);
        myHashMap.remove(2);
        myHashMap.get(2);
    }
}
