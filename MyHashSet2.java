public class MyHashSet {
    boolean[][] nodes ;

    public MyHashSet(){
      nodes = new boolean[1000][];
    }

    public void add(int key){
        int hashcode = key%nodes.length;
        if(nodes[hashcode]==null)
            nodes[hashcode] = new boolean[1000];
        int pos = key/nodes.length;
        nodes[hashcode][pos] = true;


    }
    public void remove(int key){
        int hashcode = key%nodes.length;
         if(nodes[hashcode] != null){
            int pos = key/nodes.length;
            nodes[hashcode][pos] = false;
        }
    }
    public boolean contains(int key){
        int hashcode = key%nodes.length;
        if(nodes[hashcode]==null)
            return false;
        int pos = key/nodes.length;
        if(nodes[hashcode][pos]==false)
            return false;
        return true;

        }


  }
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
