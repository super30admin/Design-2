class MyHashMap {

    //Implement using secondary singly linked list to store key, value pair.
    class Node{
        int key, value;
        Node next;

        //Node class constructor to create node
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }


    //Fxn to get node address for given key and return prev node address,
    // so that we can use this method for removal as well.
    Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr=dummy.next;
        while (curr!=null && curr.key!=key){   //It will take linear time i.e O(n)
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    int buckets;
    Node[] storage;


    //hash fxn to get the bucket value.
    int getBuckets(int key){  //It takes O(1) time.
        return Integer.hashCode(key)%buckets;   //Using inbuilt Hash Fxn, we can also use % to get bucket.
    }

    //Constructor to the HashMap class
    public MyHashMap() {
        buckets= 10000;  //size of the array
        storage =new Node[buckets];  //Linked list
    }

    //Fxn to put key, value pair in HashMap
    public void put(int key, int value) {
        int bucket = getBuckets(key);
        if (storage[bucket]==null){   //Condn to check if the Linked list is empty
            storage[bucket]=new Node(-1,-1); // if it is empty it will assign a dummy value
        }
        Node prev= find(storage[bucket],key);
                                                //It takes linear time i.e O(N)
        if (prev.next==null){ //condn to check if key value does not exist in the linked list
            prev.next= new Node(key,value); //create a new node for the given key and assign the value to it.
        }
        else{
            prev.next.value = value; //if key already exist then update the value
        }
    }


    //Fxn to get the value at the given key.
    //Overall TC will be O(N) time because of Find fxn rest all will take O(1) time.
    public int get(int key) {
        int bucket = getBuckets(key); //getting bucket in the array to check the secondary LL.
        if(storage[bucket]== null){ //Condn to check if it is empty
            return -1; //If not there then retrun -1
        }
        Node prev = find(storage[bucket], key); //if bucket exist then traversing the LL to check the value for the key.
        if (prev.next == null){
            return -1; //If not found retrun -1
        }
        return prev.next.value; //else return the value

    }

    //Fxn to remove value for a given key
    //Overall TC will be O(N) because of find fxn rest will take O(1) time

    public void remove(int key) {
        int bucket = getBuckets(key); //O(1)
        if(storage[bucket]==null){  //O(1)
            return;
        }
        Node prev = find(storage[bucket], key); //O(N)
        if(prev.next==null){ //O(N)
            return;
        }
        prev.next = prev.next.next;
    }

    public static void main(String[] args){
        MyHashMap hm = new MyHashMap();
        hm.put(1002,24);
        hm.put(2002,66);
        hm.put(459,99);
        hm.put(1010,19);
        hm.put(1210,55);
        System.out.println(hm.get(2002));
        hm.remove(1010);
        System.out.println(hm.get(1010));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */