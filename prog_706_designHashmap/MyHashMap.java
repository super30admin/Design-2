package prog_706_designHashmap;
// This solution is based on linear chaining method, where we have an array as a base data structure
// and for every index we are creating a linkedlist.
class MyHashMap {

    class Node{
        private int key;
        private int value;
        private Node next;
        public Node(int key, int value){
            this.key = key ;
            this.value = value ;

        }
    }
    Node[] storage = new Node[10000] ;
    public MyHashMap() {

    }
    public int hashFun(int key){
        return key % 10000 ;
    }
    public Node find(Node head, int key){
        Node prev = null ;
        Node curr = head ;
        while(curr!=null && curr.key!=key){
            prev = curr ;
            curr = curr.next ;
        }
        return prev ;

    }

    public void put(int key, int value) {
        int hashVal = hashFun(key) ;
        if(storage[hashVal] == null){
            storage[hashVal] = new Node(-1, -1) ;

        }
        Node prevNode = find( storage[hashVal], key);
        if(prevNode.next==null){
            prevNode.next= new Node(key, value);
        }
        else{
            prevNode.next.value = value ;
        }
    }

    public int get(int key) {
        int hashVal = hashFun(key) ;
        if(storage[hashVal] == null){
            return -1 ;
        }
        Node prevNode = find( storage[hashVal], key);
        if(prevNode.next ==null){
            return -1 ;
        }
        return prevNode.next.value ;

    }

    public void remove(int key) {
        int hashVal = hashFun(key) ;
        if(storage[hashVal] == null){
            return  ;
        }
        Node prevNode = find( storage[hashVal], key);
        if(prevNode.next ==null){
            return  ;
        }
        else{
            prevNode.next =  prevNode.next.next;
            return ;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */