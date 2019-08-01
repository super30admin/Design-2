public class DesignHashSet{
    private int size;
    boolean[][] set;
    
    public DesignHashSet(int total){
        this.size = (int)Math.ceil(Math.sqrt(total));
        set = new boolean[size][size];
    }

    public void add(int value){
        int row = hashFunction1(value);
        int col = hashFunction2(value);
        set[row][col] = true;

    }

    public void remove(int value){
        int row = hashFunction1(value);
        int col = hashFunction2(value);
        set[row][col] = false;
    }

    public boolean contains(int value){
        int row = hashFunction1(value);
        int col = hashFunction2(value);
        return set[row][col];
    }

    public int hashFunction2(int value){
        return value /size;
    }

    public int hashFunction1(int value){
        return value % size;
    }

    public static void main(String args[]){
        DesignHashSet hashSet = new DesignHashSet(1000);
        hashSet.add(400);
        hashSet.add(200);
        System.out.println(hashSet.contains(200));
        hashSet.remove(200);
        System.out.println(hashSet.contains(200));
        hashSet.add(50);
        System.out.println(hashSet.contains(20));
    }
}