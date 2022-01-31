import java.util.LinkedList;

class MyHashSet {

  public final static int SIZE = 10000;
  LinkedList<Integer>[] set;

    public MyHashSet() {
        set = new LinkedList[SIZE];
    }

    public void add(int key) {
      remove(key);
      int index = getIndex(key);
      if(set[index] == null){
        set[index] = new LinkedList<>();
      }
      set[index].addFirst(key);
    }

    public void remove(int key) {
        int index = getIndex(key);
        if(set[index] != null){
          set[index].remove(new Integer(key));
        }
    }

    public boolean contains(int key) {
      int index = getIndex(key);
      if(set[index] != null){
        return set[index].contains(key);
      }
      return false;
    }

    public int getIndex(int key){
      return key%SIZE;
    }
}
