class Node:
     def __init__(self,key,value):
         self.key=key
         self.value=value
         self.next=None

class MyHashMap:

    def __init__(self):
        self.bucket_count = 1000
        self.buckets=[None]*self.bucket_count

    def _get_hash(self, key):
        return key % self.bucket_count
    
    def search_node(self,key,curr):      
        while(curr is not None and curr.key != key):
            prev_node=curr
            curr = curr.next
        return prev_node


    def put(self, key: int, value: int) -> None:
        hash_value=self._get_hash(key)
        if(self.buckets[hash_value] is None):
             self.buckets[hash_value]=Node(-1,-1)
             self.buckets[hash_value].next=Node(key,value)
        else:
            prev_node=(self.search_node(key,self.buckets[hash_value]))
            if(prev_node.next is not None):
               prev_node.next.value= value
            else:
                 prev_node.next= Node(key,value)

               
    def get(self, key: int) -> int:
        hash_value=self._get_hash(key)
        if(self.buckets[hash_value] is None):          
            return -1
        else:
            prev_node=self.search_node(key,self.buckets[hash_value])
            if(prev_node.next is not  None):
             return prev_node.next.value
            
            else:
              return -1


        

    def remove(self, key: int) -> None:
      hash_value=self._get_hash(key)
      if(self.buckets[hash_value] is not None):
         prev_node=self.search_node(key,self.buckets[hash_value])
         if (prev_node.next is not None):
            prev_node.next = prev_node.next.next 






# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)