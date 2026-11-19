
/*
Time Complexity:
put()    = O(1) average, O(n) worst case
get()    = O(1) average, O(n) worst case
remove() = O(1) average, O(n) worst case

Space Complexity: O(n)
n = Number of key value pairs.

Appraoch :
I want to implement hash map using chaining , Static array along with Linked list.[Array of Linked lists]
Put - Firstly I will calulate the the array index for the key using hash function, then will check 
whether is there any linked list formed at that index, if not will create a dummy node and traverse 
through the linked list till the last node then create and add the new node with new key value pair,
if key already exists i will update the value, similarly with remove and get.
*/

class HashMap {
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] arr;

    public HashMap() {
        this.arr = new Node[10000];
        
    }

    int hash1(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int index = hash1(key);
        if(arr[index] == null){
            arr[index] = new Node(-1,-1);
        }

        Node curr = arr[index];
         while(curr.next!=null){
           if( curr.next.key == key){
            curr.next.value = value;
            return;
           }
           curr = curr.next;
         }
         curr.next = new Node(key,value);
    }
    
    public int get(int key) {

        int index = hash1(key);

        if(arr[index] == null) return -1;

        Node curr = arr[index];

        while(curr.next!=null){

            if(curr.next.key == key){
                return curr.next.value;
            }
            curr = curr.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {

        int index = hash1(key);
        if(arr[index] == null) {
            return;
        }

         Node curr = arr[index];

        while(curr.next!=null){

            if( curr.next.key == key){

                curr.next = curr.next.next;
                return;
            }
           curr = curr.next;
        }
         
    }


    public static void main(String[] args) {
        HashMap obj = new HashMap();

        obj.put(2,20);
        obj.put(3,20);
        System.out.println("The value for this key is" +obj.get(3));
        obj.put(5,50);
        obj.put(3,30);
        obj.remove(5);
        System.out.println("The value for this key is" +obj.get(5));
        obj.remove(8);


        
    }
}
              