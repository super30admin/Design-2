import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

    final int ARRAY_SIZE = 100;

    List<List<Integer>> mainList;

    public MyHashSet() {
        mainList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0; i< ARRAY_SIZE; i++){
            mainList.add(null);
        }
    }

    public void add(int key) {
        int index = findIndex(key);
        List<Integer> childList = mainList.get(index);

        if(childList == null) {
            List<Integer> newList = new ArrayList<>();
            newList.add(key);
            mainList.set(index,newList);
        }else{
            childList.add(key);
        }
    }

    public void remove(int key) {

    }

    public boolean contains(int key) {
        int index = findIndex(key);

        List<Integer> childList = mainList.get(index);
        if(childList != null){
            return childList.contains(key);
        }
        return false;
    }

    private int findIndex(int key) {
        return key % ARRAY_SIZE;
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(3);
        obj.add(4);
        boolean param_3 = obj.contains(30);
        System.out.println("param_3 = " + param_3);
    }
}
