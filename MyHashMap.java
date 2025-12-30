
public class MyHashMap {

	private int length=1000000;
    //1-Create ListNode
    //2-Hash Function
    //3- find element
    //4 - implement get
    // 5 - implement put
    // 6 - implement remove
    ListNode[] map=null;
    class ListNode{
        int key,val;
        ListNode next;
        ListNode(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    public MyHashMap() {
        map = new ListNode[length];
    }

    private int hashCode(int key){
        return Integer.hashCode(key) %  map.length;
    }

    private ListNode findElement(int index, int key){
        if (map[index]==null){
            map[index] =new ListNode(-1,-1);//dummy node
            return map[index];
        }else{
            ListNode currentNode=map[index];
            while ( currentNode.next!=null && currentNode.next.key!=key){
                currentNode=currentNode.next;
            }
            return currentNode;
        }

    }
    
    /*
     * Average: O(1)
     * Worst-case: O(N)
     */
    public void put(int key, int value) {
        if (key<0)
         return ;
        int hash = hashCode(key);
        ListNode prevElement=findElement(hash,key);
        if (prevElement.next!=null){
            prevElement.next.val=value;
        }else{
            prevElement.next= new ListNode(key,value);
        }
    }
    
    /*
     * Average: O(1)
     * Worst-case: O(N)
     */
    public int get(int key) {
        if (key<0) return -1;
        int hash= hashCode(key);
        ListNode prevElement=findElement(hash,key);
        if (prevElement.next!=null){
            return prevElement.next.val;
        }
        return -1;
    }
    
    /*
     * Average: O(1)
     * Worst-case: O(N)
     */
    public void remove(int key) {
        if (key<0)    
          return;
        int hashCode = hashCode(key);
        ListNode prevElement=findElement(hashCode,key);
        if (prevElement.next ==null ){
            return;
        } else{
            prevElement.next=prevElement.next.next;
        }
    }
}
