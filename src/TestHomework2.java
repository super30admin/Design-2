
void main() {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1,1);
    myHashMap.put(2,2);
    System.out.println(myHashMap.get(1));
    System.out.println(myHashMap.get(3));
    myHashMap.put(2,1);
    System.out.println(myHashMap.get(2));
    myHashMap.remove(2);
    System.out.println(myHashMap.get(2));
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);
    System.out.println(myQueue.peek());
    System.out.println(myQueue.pop());
    myQueue.empty();
}