import java.util.*;


public class Problem_2 {

    int[] mapArray;
    public Problem_2()
    {
        mapArray = new int[1000001];
        Arrays.fill(mapArray,-1);
    }

    /* insert into hashmap */
    public void put(int key, int value)
    {
        mapArray[key]= value;
    }

    /* get from a hashmap */
    public int get(int key)
    {
        return mapArray[key];
    }

    /* delete a value from the key */
    public void remove(int key)
    {
        mapArray[key] = -1;
    }
    
    public static void main(String[] args) {

        Problem_2 hashmap = new Problem_2();
        hashmap.put(1, 1);
        hashmap.put(2,2);
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.get(3));
        hashmap.put(2,1);
        System.out.println(hashmap.get(2));
        hashmap.remove(2);
        System.out.println(hashmap.get(2));
        
    }
}
