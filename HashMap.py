#implemented using linked list when collision occurs


class Node:
            def __init__(self,key,value):
                self.key=key
                self.value=value
                self.next=None

class LinkList:
    def __init__(self,head:Node):
        self.head=head



class MyHashMap:
    


    def __init__(self):
        self.size1=10000
        self.Hashmap=[None]*self.size1
        
    
    def Hash1(self,key: int):
        return int(key%self.size1)


    def put(self, key: int, value: int) -> None:
        index1=self.Hash1(key)
        index2=self.Hash2(key)
        
        if(self.Hashmap[index1] is None):
            self.Hashmap[index1]=LinkList(head=Node(key=key,value=value))
            print(key,"head is null")
            return
        else:
            travnode=self.Hashmap[index1].head
            #print(key)
            while(travnode.next is not None):
                if(travnode.key == key):
                    #print("First loop",key)
                    travnode.value=value
                    return
                travnode=travnode.next
            if(travnode.key == key):
                    #print("in this loop with",key,value)
                    travnode.value=value
                    
            else:
                #print('new value is being created of key',travnode.key,travnode.value,key,value)
                travnode.next=Node(key,value)




    def get(self, key: int) -> int:
        index1=self.Hash1(key)
        index2=self.Hash2(key)
        if(self.Hashmap[index1] == None):
            #print("No",key)
            return -1
        travnode=self.Hashmap[index1].head
        while(travnode.next is not None):
            if(travnode.key == key):
                #print("found",key)
                return travnode.value
            travnode=travnode.next
        if(travnode.key == key):
            #print("found",key)
            return travnode.value
        return -1


    def remove(self, key: int) -> None:
        index1=self.Hash1(key)
        index2=self.Hash2(key)
        prevnode=None
        #print(key)
        if(self.Hashmap[index1] == None):
            return

        travnode=self.Hashmap[index1].head
        while(travnode.next is not None):
            if(travnode.key == key):
                if(prevnode == None):
                    self.Hashmap[index1].head=travnode.next
                    return
                else:
                    prevnode.next=travnode.next
                    return    
            prevnode=travnode
            travnode=travnode.next
        if(travnode.key == key):
                if(prevnode == None):
                    self.Hashmap[index1]=None
                    return
                else:
                    prevnode.next=travnode.next
                    return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)