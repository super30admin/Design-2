import java.util.*;
class designHashSet {

    private final int MAX_VALUE = 1000001;
    private final int ARRAY_SIZE =100;
    public List<List<Integer>> parentList;
    public designHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            parentList.add(null);
        }
    }

    public void add(int key) {
        int index = key% ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList==null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index,list);
        }else{
            if(!childList.contains(key)){
                childList.add(key);
            }

        }
    }

    public void remove(int key) {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList!=null){
            childList.remove(Integer.valueOf(key));

        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList!=null && childList.contains(key);

    }
    public static void main(String[] args){
        designHashSet myHashSet = new designHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}

