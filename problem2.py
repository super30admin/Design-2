# Both the solutions - Linear Chaining and Double Hashing 

# Solution -1 :
# Linear Chaining collision handling technique
# Time Complexity - O(k) - put, get, retrieve
class Node:
    def __init__(self,x):
        self.val=x
        self.next=None
        
class MyHashMap:

    def __init__(self):
        self.primary=[None]*10000
    
    def primary_hash(self,key):
        return key%1000
    
    def find(self,pIndx,key):
        head = self.primary[pIndx]
        # print(head.val)
        prev=head
        curr=head.next
        while(curr!=None):
            if curr.val[0]==key:
                return (curr,prev)    
            curr=curr.next
            prev=prev.next
        return (curr,prev)
        
    
        

    def put(self, key: int, value: int) -> None:
        pIndx=self.primary_hash(key)
        if self.primary[pIndx]==None: 
            self.primary[pIndx]=Node((-1,-1))
            self.primary[pIndx].next=Node((key,value))
        # print(self.primary[pIndx])
        else:
            curr,prev=self.find(pIndx,key)

            if curr!=None:
                curr.val=(key,value)
            else:
                prev.next=Node((key,value))
            
    
    def get(self, key: int) -> int:
        pIndx=self.primary_hash(key)
        if self.primary[pIndx]==None:
            return -1
        curr,prev=self.find(pIndx,key)
        if curr!=None:
            return curr.val[1]
        else:
            return -1
        
        
            
    def remove(self, key: int) -> None:
        pIndx=self.primary_hash(key)
        if self.primary[pIndx]!=None:
            curr,prev=self.find(pIndx,key)
            if curr!=None:
                prev.next=prev.next.next
            
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)






# Solution -2 :
# # Double Hashing collision handling technique
# # Time Complexity - O(1) - put, get, remove
# class MyHashMap:

#     def __init__(self):
#         self.primary=[None]*1000
    
#     def primary_hash(self,key):
#         return key%1000
    
#     def secondary_hash(self,key):
#         return key//1000
        

#     def put(self, key: int, value: int) -> None:
#         pIndx=self.primary_hash(key)
#         if self.primary[pIndx]==None:
#             if pIndx==0:
#                 self.primary[pIndx]=[None]*1001
#             else:
#                 self.primary[pIndx]=[None]*1000
#         sIndx=self.secondary_hash(key)
#         self.primary[pIndx][sIndx]=value
        
        

#     def get(self, key: int) -> int:
#         pIndx=self.primary_hash(key)
#         if self.primary[pIndx]==None:
#             return -1
#         else:
#             sIndx=self.secondary_hash(key)
#             if self.primary[pIndx][sIndx]==None:
#                 return -1
#             else:
#                 return self.primary[pIndx][sIndx]
            
        

#     def remove(self, key: int) -> None:
#         pIndx=self.primary_hash(key)
#         sIndx=self.secondary_hash(key)
#         if self.primary[pIndx]!=None and self.primary[pIndx][sIndx]!=None:
#                 self.primary[pIndx][sIndx]=None
        


# # Your MyHashMap object will be instantiated and called as such:
# # obj = MyHashMap()
# # obj.put(key,value)
# # param_2 = obj.get(key)
# # obj.remove(key)