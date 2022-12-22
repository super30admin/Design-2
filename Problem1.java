class MyHashMap {

    Bucket arr[];
    int arrLength = 10000;


    public MyHashMap() {
        this.arr = new Bucket[arrLength];
    }

    public void put(int key, int value) {
        int hash1 = hash1(key);

        if(arr[hash1] == null){
            Pairs pairs = new Pairs(-1, -1);
            Node node = new Node(pairs);
            arr[hash1] = new Bucket(node);
        }
        Node cursor = findNode(arr[hash1].getNode(), key);

        if(cursor.next == null){
            cursor.next = new Node(new Pairs(key, value));
        }
        else{
            cursor.next.setPairs(new Pairs(key, value));
        }


    }

    public int get(int key) {
        int hash1 = hash1(key);

        if(arr[hash1] == null) return -1;

        Node cursor = findNode(arr[hash1].getNode(), key);

        if(cursor.next == null){
            return -1;
        }
        else{
            return cursor.next.getPairs().getvalue();
        }


    }

    public void remove(int key) {

        int hash1 = hash1(key);

        if(arr[hash1] == null) return;

        Node cursor = findNode(arr[hash1].getNode(), key);

        if(cursor.next == null){
            return;
        }
        else{
            Node temp = cursor.next;
            cursor.next = cursor.next.next;
            temp.next = null;
        }



    }

    public int hash1(int key){
        return key%arrLength;
    }

    public Node findNode(Node node, int key){

        Node prev = null;
        Node curr = node;

        while(curr != null && curr.getPairs().getKey() != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
}

class Bucket{

    Node node;

    Bucket(Node node){
        this.node = node;
    }

    public Node getNode(){
        return this.node;
    }

}

class Node{
    Pairs pairs;
    Node next;

    Node(Pairs pairs){
        this.pairs = pairs;
    }

    public Pairs getPairs(){
        return this.pairs;
    }

    public void setPairs(Pairs pairs){
        this.pairs = pairs;
    }
}


class Pairs{
    int key;
    int value;

    Pairs(int key, int value){
        this.value = value;
        this.key = key;
    }

    public int getvalue(){
        return this.value;
    }

    public int getKey(){
        return this.key;
    }

    public int setvalue(int value){
        return this.value = value;
    }

    public int setKey(int key){
        return this.key = key;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */