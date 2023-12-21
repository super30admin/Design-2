public class MyHashMapTester {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();

        obj.put(5, 2);

        int param_2 = obj.get(5);

        System.out.println(param_2);

        obj.remove(5);

        System.out.println(obj.get(5));
    }
}
