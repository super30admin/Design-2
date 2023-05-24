public class Driver {
    public static void main(String[] args)
    {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,10);
        System.out.println(myHashMap.get(1));
        myHashMap.put(1, 12);
        System.out.println(myHashMap.get(1));
        myHashMap.remove(1);
        System.out.println(myHashMap.get(1));

        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
        myQueue.pop();
        System.out.println(myQueue.empty());
    }
}
