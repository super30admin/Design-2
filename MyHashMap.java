//time complexity = O(10000) or O(1)
//space complexity = O(n)
//successfully executed on leetcode

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value= value;
        this.next= null; 
    }
    }  

     Node primaryStorage[];
    public MyHashMap() {
     this.primaryStorage= new Node[10000];
    
    }
    private int hash(int key){
        return key%10000;
    }
    public Node find(Node head, int key){
        Node prev= head;
        Node curr= head.next;
        while(curr!=null && curr.key!= key){
           prev= curr;
           curr= curr.next;
        }
        return prev;
    
    }
    
    public void put(int key, int value) {
         int indx= hash(key);
         if(primaryStorage[indx]== null){
            primaryStorage[indx] = new Node(-1,-1);


         }
         
            Node prev = find(primaryStorage[indx],key);
            if(prev.next== null){
                prev.next= new Node(key, value);      
            }
            prev.next.value = value;
            
    }
    
    public int get(int key) {
        int indx= hash(key);
         if(primaryStorage[indx]== null){return -1;}
         Node prev = find(primaryStorage[indx],key);
         if(prev.next== null){return -1;}
        
         return prev.next.value;
          

    }
    
    public void remove(int key) {
         int indx= hash(key);
         if(primaryStorage[indx]== null){ return; }
         Node prev = find(primaryStorage[indx],key);
       if(prev.next==null){
           return; 
       }
       prev.next= prev.next.next;
    }
}
