class MyHashSet {

    int temp[];
    boolean check;

    /** Initialize your data structure here. */
    public MyHashSet() {
        temp = new int[1000000];
    }

    public void add(int key) {
        check = (temp[key] == 0);
        if (check) temp[key]++;
    }

    public void remove(int key) {
        check = (temp[key]>0);
        if (check) temp[key]--;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        check = (temp[key]!=0);
        return check;
    }
}



public class HashSetImplementation{
    public static void main(String[] args){
          MyHashSet obj = new MyHashSet();
          obj.add(key);
          obj.remove(key);
          boolean param_3 = obj.contains(key);


    }
}
