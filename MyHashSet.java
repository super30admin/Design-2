class MyHashSet {

    /** Initialize your data structure here. */
    public boolean[][] storage;
    public int indexX;
    public int indexY;
    public MyHashSet() {
        indexX = 1000;
        indexY = 1000;
        storage = new boolean[indexX][indexY];
    }
    
    public void add(int value) {
        int hashCode = hashCode(value);
        int pos = position(value);
        storage[hashCode][pos] = true;
    }
    
    public void remove(int value) {   
        int hashCode = hashCode(value);
        int pos = position(value);    
        if(storage[hashCode] != null){
            storage[hashCode][pos] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int value) {        
        int hashCode = hashCode(value);
        int pos = position(value);
        return storage[hashCode] != null && storage[hashCode][pos];
    }

    public int hashCode(int value){
        return Integer.hashCode(value)%indexX;
    }

    public int position(int value){
        return Integer.hashCode(value)/indexX;
    }

    public static void main(String[] args){
        System.out.println("HashMap Custom Implementation..");
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(10);
        myHashSet.add(7);
        myHashSet.add(9);
        myHashSet.add(11);
        myHashSet.add(10);
        System.out.println(myHashSet.contains(9));
        myHashSet.remove(11);
        System.out.println(myHashSet.contains(11));
        System.out.println(myHashSet.contains(678));

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */