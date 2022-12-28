class MyHashMap:
    class Node(object):
        def __init__(self,key,val):
            self.key = key
            self.val = val
            self.next = None
    

    def __init__(self):
        self.hashList = [None]*100000
    def getIndex(self,key):
        return hash(key)%len(self.hashList)
    	
    def getPrevNode(self,head,key):
        curr = head
        prev = None
        
        while curr!=None and curr.key!=key:
            prev = curr
            curr = curr.next
        
        return prev
        

    def put(self, key: int, value: int) -> None:
        i = self.getIndex(key)
        
        if self.hashList[i] == None:
            self.hashList[i] = self.Node(-1, -1)
        prev_Node = self.getPrevNode(self.hashList[i],key)   
        
        if prev_Node.next == None: #saying key is not present
            prev_Node.next = self.Node(key,value)
        else: #saying key is  present
            prev_Node.next.val = value
            
     

    def get(self, key) :
        i = self.getIndex(key)
        if self.hashList[i] == None:
            return -1
        prev_node = self.getPrevNode(self.hashList[i], key)
        return -1 if prev_node.next == None else prev_node.next.val
         
        

    def remove(self, key: int) -> None:
        i = self.getIndex(key)
        
        if self.hashList[i] == None: #if the Node does not exist, do nothing
            return
        
        prev_Node = self.getPrevNode(self.hashList[i],key)
        if prev_Node.next == None: #saying we didn't find the key in this bucket
            return None
        
        else:
            prev_Node.next = prev_Node.next.next