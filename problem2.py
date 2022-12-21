#time complexity: for all the functions: O(n) where n is 1000
#space complexity: O(n) n=1000
#ran in leetcode: yes
# the solution is a single hashing and collsions are handled by chaining(linked list) mechanism
class Node:
        def __init__(self,key,value,next):
            self.key=key
            self.value=value
            self.next=None

class MyHashMap:
    def __init__(self):
        self.L=[None]*1000
        
    def put(self, key: int, value: int) -> None:
        ind=key%1000
        #print("INSIDE PUT")
        if(self.L[ind]==None):
            node=Node(key,value,None)
            self.L[ind]=node
        else:
            temp=self.L[ind]
            is_break=False
            while(temp.next):
                if(temp.key==key):
                    temp.value=value
                    is_break=True
                    break
                temp=temp.next
            if(is_break==False):
                if(temp.key==key):
                    temp.value=value
                else:
                    node=Node(key,value,None)
                    temp.next=node
    
    def get(self, key: int) -> int:
        ind=key%1000
        if(self.L[ind]==None):
            return -1
        else:
            #print("INSIDE GETT")
            temp=self.L[ind]
            while(temp):
                if(temp.key==key):
                    return temp.value
                temp=temp.next
            return -1

    def remove(self, key: int) -> None:
        ind=key%1000
        if(self.L[ind]!=None):
            temp=self.L[ind]
            if(temp.next==None ):
                if(temp.key==key):
                    self.L[ind]=temp.next
                    del(temp)
            elif(temp.key==key):
                self.L[ind]=temp.next
                del(temp)
            else:
                while(temp.next.next and temp.next.key!=key):
                    temp=temp.next
                if(temp.next.key==key):
                    temp1=temp.next
                    temp.next=temp1.next
                    del(temp1)
            


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)