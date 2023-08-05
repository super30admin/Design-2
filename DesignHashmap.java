import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashmap {
    //Time Complexity: O(1) asymtotically for get and put and complexity increases as the size of pairs increase
    //Space Complexity: O(1) for creating buckets and O(k) for each pari creating within bucket
    class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    class Bucket{
        private List<Pair> bucket;

        Bucket(){
            bucket = new LinkedList<>();
        }
        public int get(int key){
            for(Pair current: this.bucket){
                if(current.key == key)return current.value;
            }
            return -1;
        }

        public void update(int key, int value){
            for(Pair current: this.bucket){
                if(current.key == key){
                    current.value = value;
                    return;
                }
            }
            this.bucket.add(new Pair(key, value));
        }

        public void remove(int key){
            Pair toRemove = null;
            for(Pair current: this.bucket){
                if(current.key == key){
                    toRemove = current;
                    break;
                }
            }
            if(toRemove != null) this.bucket.remove(toRemove);
        }

    }

    private int key_space = 2069;
    private List<Bucket> hash_table;

    public DesignHashmap() {
        hash_table = new ArrayList<>();
        for(int i = 0; i< 2069; i++){
            hash_table.add(new Bucket());
        }

    }

    public void put(int key, int value) {
        hash_table.get(key%key_space).update(key, value);

    }
    public int get(int key) {
        return hash_table.get(key%key_space).get(key);

    }

    public void remove(int key) {
        hash_table.get(key%key_space).remove(key);
    }
}
